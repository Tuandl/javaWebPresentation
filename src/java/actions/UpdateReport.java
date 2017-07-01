/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import db.RegistrationDAO;
import dtos.Patient;
import dtos.Report;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author TUANDASE62310
 */
public class UpdateReport {
    
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private static final String BACK = "back";

    private String searchValue, reportID, patientID, patientName, surgeryName,
            operatedDoctor, anesthesiologist, processOfSurgery, action;
    private Date DOB, timeStart, timeEnd;
    private boolean isMale;
    private Report report;

    public UpdateReport() {
    }

    public String execute() throws Exception {
        String url = FAIL;
        HttpServletRequest request = ServletActionContext.getRequest();
        if(action.equalsIgnoreCase("back")){
            url = BACK;
        } else {
            Patient p = new Patient();
            p.setUsername(patientID);
            p.setName(patientName);
            p.setIsMale(isMale);
            p.setDOB(DOB);
            report = new Report();
            report.setPatient(p);
            report.setReportID(reportID);
            report.setSurgeryName(surgeryName);
            report.setOperatedDoctor(operatedDoctor);
            report.setAnesthesiologist(anesthesiologist);
            report.setProcessOfSurgery(processOfSurgery);
            report.setTimeEnd(timeEnd);
            report.setTimeStart(timeStart);

            Map session = ActionContext.getContext().getSession();
            RegistrationDAO dao = new RegistrationDAO();
            if (dao.updateReportByID(reportID, surgeryName, operatedDoctor,
                    anesthesiologist, timeStart, timeEnd, processOfSurgery,
                    (String) session.get("username"))) {
                url = SUCCESS;
                request.setAttribute("noti", "Update Successful!!");
            } else {
                request.setAttribute("error", "Update Failed!!");
            }
        }
        return url;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    
    public Report getReport() {
        return report;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
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

    public String getProcessOfSurgery() {
        return processOfSurgery;
    }

    public void setProcessOfSurgery(String processOfSurgery) {
        this.processOfSurgery = processOfSurgery;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.DOB = sdf.parse(DOB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        try {
            this.timeStart = sdf.parse(timeStart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        try {
            this.timeEnd = sdf.parse(timeEnd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

}
