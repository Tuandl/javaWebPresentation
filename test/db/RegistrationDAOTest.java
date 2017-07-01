/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import dtos.Employee;
import dtos.Patient;
import dtos.RegistrationDTO;
import dtos.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TUANDASE62310
 */
public class RegistrationDAOTest {
    
    public RegistrationDAOTest() {
    }

    /**
     * Test of checkLogin method, of class RegistrationDAO.
     */
    @Test
    public void testCheckLogin() {
        RegistrationDAO dao = new RegistrationDAO();
        RegistrationDTO dto;
        dto= dao.checkLogin("e001", "123456");
        assertTrue(dto instanceof Employee);
        assertEquals("Tuan", dto.getName());
        dto= dao.checkLogin("e002", "123456");
        assertTrue(dto instanceof Employee);
        assertEquals("Huy", dto.getName());
        dto= dao.checkLogin("p001", "123456");
        assertTrue(dto instanceof Patient);
        assertEquals("uyen", dto.getName());
    }
    
    @Test
    public void testUpdatePatient(){
        RegistrationDAO dao = new RegistrationDAO();
        assertTrue(dao.updatePatient("p001", "uyen", false, new Date(), "DL", 
                "p001@gmail.com", "0123456789"));
        assertFalse(dao.updatePatient("a65sd4a6s54da8s9", "asdas", true, new Date(), "asd", "", ""));
    }
    
    @Test
    public void testInsertPatient(){
        RegistrationDAO dao = new RegistrationDAO();
        assertTrue(dao.insertPatient("ASDF", "", true, new Date(), 
                "", "", "", ""));
        assertFalse(dao.insertPatient("ASDF", "", true, new Date(),
                "", "", "", ""));
        try {
            Connection conn = MyConnection.getMyConnection();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE "
                    + "FROM Patient WHERE PatientID = 'ASDF'");
            stm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testInsertSurgery(){
        RegistrationDAO dao = new RegistrationDAO();
        assertTrue(dao.insertSugery("asdfasdf", "", new Date(), new Date(), 
                "e001", "", "p001", "", "e001", "e001"));
        assertFalse(dao.insertSugery("asdfasdf", "", new Date(), new Date(), 
                "e001", "", "p001", "", "e001", "e001"));
        try {
            Connection conn = MyConnection.getMyConnection();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE "
                    + "FROM Report WHERE Surgery_record_id = 'asdfasdf'");
            stm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testSearchByLikePatientName(){
        RegistrationDAO dao = new RegistrationDAO();
        Patient p = new Patient();
        p.setUsername("P001");
        p.setName("uyen");
        Report report = new Report("Emergency", p);
        List<Report> rps;
        rps = dao.findByLikePatientname("u");
        assertEquals(rps.get(0).getSurgeryName(), "Emergency");
        assertEquals(rps.get(0).getPatient().getUsername(), "P001");
        assertEquals(rps.get(0).getPatient().getName(), "uyen");
        
        rps = dao.findByLikePatientname("uy");
        assertEquals(rps.get(0).getSurgeryName(), "Emergency");
        assertEquals(rps.get(0).getPatient().getUsername(), "P001");
        assertEquals(rps.get(0).getPatient().getName(), "uyen");
        
        rps = dao.findByLikePatientname("uyen");
        assertEquals(rps.get(0).getSurgeryName(), "Emergency");
        assertEquals(rps.get(0).getPatient().getUsername(), "P001");
        assertEquals(rps.get(0).getPatient().getName(), "uyen");
        
        rps = new ArrayList<>();
        assertEquals(0, dao.findByLikePatientname("123465sdfadsfsdfad").size());
    }
    
    @Test
    public void testFindReportByID(){
        RegistrationDAO dao = new RegistrationDAO();
        Report res = dao.findReportByReportID("R001");
        assertEquals("P001", res.getPatient().getUsername());
        assertEquals("uyen", res.getPatient().getName());
        assertNotEquals(null , res.getPatient().getDOB());
        assertFalse(res.getPatient().isIsMale());
        assertEquals("Emergency", res.getSurgeryName());
        assertEquals("E001", res.getOperatedDoctor());
        assertEquals("E002", res.getAnesthesiologist());
        assertNotEquals(null, res.getTimeStart());
        assertNotEquals(null, res.getTimeEnd());
        assertEquals("Emergency", res.getProcessOfSurgery());
    }
    
    @Test
    public void testUpdateReport(){
        RegistrationDAO dao = new RegistrationDAO();
        assertTrue(dao.updateReportByID("R001", "Emergency", "E001", "E002", 
                new Date(0), new Date(1000), "Emergency", "E001"));
        assertFalse(dao.updateReportByID("adflkjahsdfuh", "Emergency", "E001", "E002", 
                new Date(0), new Date(1000), "Emergency", "E001"));
        assertFalse(dao.updateReportByID("R001", "Emergency", "asdflujahsdflkjh", "E002", 
                new Date(0), new Date(1000), "Emergency", "E001"));
        assertFalse(dao.updateReportByID("R001", "Emergency", "E001", "aflakjshdflkjhasd", 
                new Date(0), new Date(1000), "Emergency", "E001"));
        assertFalse(dao.updateReportByID("R001", "Emergency", "E001", "E002", 
                new Date(0), new Date(1000), "Emergency", "alksdjfhalkjsdhf"));
        
    }
}
