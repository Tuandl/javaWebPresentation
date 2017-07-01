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
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author TUANDASE62310
 */
public class RegistrationDAO {

    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public RegistrationDAO() {
    }

    private void closeConenction() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Return dtos.Employee if login as employee
     * Return dtos.Patient if login as patient
     * Return null if invalid usename or password or sql error
     */
    public RegistrationDTO checkLogin(String username, String password) {
        RegistrationDTO res = null;
        String sql;
        try {
            sql = "SELECT EmployeeName From Employee WHERE "
                    + "EmployeeID = ? and EmpPass = ?";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                res = new Employee();
                res.setName(rs.getString("EmployeeName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConenction();
        }
        if (res != null) {
            return res;
        }

        try {
            sql = "SELECT PatientName, gender, DOB, PatientAddr, Email, Phone"
                    + " From Patient WHERE "
                    + "PatientID = ? and PatientPass = ?";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                res = new Patient();
                res.setName(rs.getString("PatientName"));
                res.setIsMale(rs.getBoolean("gender"));
                res.setDOB(new Date(rs.getTimestamp("DOB").getTime()));
                res.setAddress(rs.getString("PatientAddr"));
                res.setEmail(rs.getString("Email"));
                res.setPhone(rs.getString("phone"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConenction();
        }

        return res;
    }

    public boolean updatePatient(Patient patient) {
        boolean res = false;
        String sql;
        try {
            sql = "UPDATE Patient "
                    + "SET PatientName = ?, Gender = ?, "
                    + "DOB = ?, PatientAddr = ?,"
                    + "Email = ?, Phone = ? "
                    + "WHERE PatientID = ?";
            Connection conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, patient.getName());
            stm.setBoolean(2, patient.isIsMale());
            stm.setTimestamp(3,
                    new Timestamp(patient.getDOB().getTime()));
            stm.setString(4, patient.getAddress());
            stm.setString(5, patient.getEmail());
            stm.setString(6, patient.getPhone());
            stm.setString(7, patient.getUsername());
            if (stm.executeUpdate() == 1) {
                res = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConenction();
        }
        return res;
    }

    public boolean updatePatient(String username,
            String name, boolean isMale, Date DOB,
            String address, String email, String phone) {
        Patient patient = new Patient();
        patient.setUsername(username);
        patient.setName(name);
        patient.setIsMale(isMale);
        patient.setDOB(DOB);
        patient.setAddress(address);
        patient.setEmail(email);
        patient.setPhone(phone);
        return updatePatient(patient);
    }

    public boolean insertPatient(Patient patient) {
        boolean res = false;
        String sql;
        try {
            sql = "INSERT INTO Patient (PatientID, PatientName, "
                    + "Gender, DOB, PatientAddr, Email, "
                    + "Phone, PatientPass) VALUES (?, ?, ?, ?,"
                    + "?, ?, ?, ?)";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, patient.getUsername());
            stm.setString(2, patient.getName());
            stm.setBoolean(3, patient.isIsMale());
            stm.setTimestamp(4, 
                    new Timestamp(patient.getDOB().getTime()));
            stm.setString(5, patient.getAddress());
            stm.setString(6, patient.getEmail());
            stm.setString(7, patient.getPhone());
            stm.setString(8, patient.getPassword());
            res = stm.executeUpdate() == 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConenction();
        }
        return res;
    }
    
    public boolean insertPatient(String username, String name, 
            boolean isMale, Date DOB, String address, 
            String email, String phone, String password){
        Patient patient = new Patient();
        patient.setUsername(username);
        patient.setName(name);
        patient.setIsMale(isMale);
        patient.setDOB(DOB);
        patient.setAddress(address);
        patient.setEmail(email);
        patient.setPhone(phone);
        patient.setPassword(password);
        return insertPatient(patient);
    }
    
    public boolean insertSugery(String id, String process, Date timeStart,
            Date timeEnd, String creator, String status, String patientID, 
            String surgeryName, String operatedDoctor, String Anesthesiologist){
        boolean res = false;
        String sql;
        try {
            sql = "INSERT INTO Report (Surgery_Record_ID, "
                    + "ProcessOfSurgery, TimeOfStart, TimeOfEnd,"
                    + "Creator_Emp, DateOfCreate, Status, "
                    + "PatientID, SurgeryName, OperatedDoctor, "
                    + "Anesthesiologist) VALUES (?,?,?,?,?,?,?,"
                    + "?,?,?,?)";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, process);
            stm.setTimestamp(3, new Timestamp(timeStart.getTime()));
            stm.setTimestamp(4, new Timestamp(timeEnd.getTime()));
            stm.setString(5, creator);
            stm.setTimestamp(6, new Timestamp(new Date().getTime()));
            stm.setString(7, status);
            stm.setString(8, patientID);
            stm.setString(9, surgeryName);
            stm.setString(10, operatedDoctor);
            stm.setString(11, Anesthesiologist);
            res = stm.executeUpdate() == 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConenction();
        }
        return res;
    }
    
    public List<Report> findByLikePatientname(String patientName){
        ArrayList<Report> res = null;
        String sql;
        try {
            sql = "SELECT a.PatientID, PatientName, SurgeryName, b.Surgery_Record_ID "
                    + "FROM Patient a "
                    + "INNER JOIN report b ON a.PatientID = b.PatientID "
                    + "WHERE a.PatientName LIKE ? ";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + patientName + "%");
            rs = stm.executeQuery();
            res = new ArrayList<>();
            while(rs.next()){
                Patient p = new Patient();
                p.setUsername(rs.getString("PatientID"));
                p.setName(rs.getString("PatientName"));
                Report report = new Report(rs.getString("SurgeryName"), p);
                report.setReportID(rs.getString("Surgery_Record_ID"));
                res.add(report);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConenction();
        }
        return res;
    }
    
    public Report findReportByReportID(String reportID){
        Report res = null;
        String sql;
        try {
            sql = "SELECT a.PatientID, a.PatientName, a.DOB, a.Gender, b.SurgeryName, "
                    + "b.OperatedDoctor, Anesthesiologist, TimeOfStart, TimeOfEnd, "
                    + "ProcessOfSurgery "
                    + "FROM Patient a "
                    + "INNER JOIN Report b ON a.PatientID = b.PatientID "
                    + "WHERE b.Surgery_Record_ID = ?";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, reportID);
            rs = stm.executeQuery();
            res = new Report();
            if(rs.next()){
                Patient p = new Patient();
                p.setUsername(rs.getString("PatientID"));
                p.setName(rs.getString("PatientName"));
                p.setDOB(rs.getTimestamp("DOB"));
                p.setIsMale(rs.getBoolean("Gender"));
                res.setPatient(p);
                res.setSurgeryName(rs.getString("SurgeryName"));
                res.setOperatedDoctor(rs.getString("OperatedDoctor"));
                res.setAnesthesiologist(rs.getString("Anesthesiologist"));
                res.setTimeStart(rs.getTimestamp("TimeOfStart"));
                res.setTimeEnd(rs.getTimestamp("TimeOfEnd"));
                res.setProcessOfSurgery(rs.getString("ProcessOfSurgery"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConenction();
        }
        return res;
    }
    
    public boolean updateReportByID(String reportID, String surgeryName, 
            String operatedDoctor, String anesthesiologist, 
            Date timeStart, Date timeEnd, String processSurgery, String creator){
        boolean res = false;
        String sql;
        try {
            sql = "UPDATE Report "
                    + "SET SurgeryName = ?, OperatedDoctor = ?, Anesthesiologist = ?, "
                    + "timeOfStart = ?, timeOfEnd = ?, ProcessOfSurgery = ?, "
                    + "Creator_Emp = ?, DateOfCreate = ? "
                    + "WHERE Surgery_Record_ID = ?";
            conn = MyConnection.getMyConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, surgeryName);
            stm.setString(2, operatedDoctor);
            stm.setString(3, anesthesiologist);
            stm.setTimestamp(4, new Timestamp(timeStart.getTime()));
            stm.setTimestamp(5, new Timestamp(timeEnd.getTime()));
            stm.setString(6, processSurgery);
            stm.setString(7, creator);
            stm.setTimestamp(8, new Timestamp(new Date().getTime()));
            stm.setString(9, reportID);
            res = stm.executeUpdate() == 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConenction();
        }
        return res;
    }
}
