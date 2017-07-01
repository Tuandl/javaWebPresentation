/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import db.RegistrationDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author TUANDASE62310
 */
public class InsertReport {
    
    private static final String SUCCESS = "success";
    
    private String patientUsername, reportID, processOfSurgery,
            status, operatedDoctor, anesthesiologist, surgeryName;
    private Date timeStart, timeEnd;
    
    public InsertReport() {
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        Map session = ActionContext.getContext().getSession();
        HttpServletRequest request = ServletActionContext.getRequest();
        if(dao.insertSugery(reportID, processOfSurgery, timeStart, timeEnd, 
                (String)session.get("username"), status, patientUsername, surgeryName, 
                operatedDoctor, anesthesiologist)){
            this.patientUsername = null;
            this.reportID = null;
            this.processOfSurgery = null;
            this.status = null;
            this.operatedDoctor = null;
            this.anesthesiologist = null;
            this.timeEnd = null;
            this.timeStart = null;
            this.surgeryName = null;
            request.setAttribute("success", "Insert Successful");
        } else {
            request.setAttribute("fail", "Insert Failed!!");
        }
        return SUCCESS;
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    
    public String getPatientUsername() {
        return patientUsername;
    }

    public void setPatientUsername(String patientUsername) {
        this.patientUsername = patientUsername;
    }

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public String getProcessOfSurgery() {
        return processOfSurgery;
    }

    public void setProcessOfSurgery(String processOfSurgery) {
        this.processOfSurgery = processOfSurgery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperatedDoctor() {
        return operatedDoctor;
    }

    public void setOperatedDoctor(String operatedDoctor) {
        this.operatedDoctor = operatedDoctor;
    }

    public String getAnesthesiologist() {
        return anesthesiologist;
    }

    public void setAnesthesiologist(String anesthesiologist) {
        this.anesthesiologist = anesthesiologist;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            this.timeStart = sdf.parse(timeStart);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try {
            this.timeEnd = sdf.parse(timeEnd);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
