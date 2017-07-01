/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author TUANDASE62310
 */
public class Report implements Serializable{
    private String reportID, processOfSurgery, creator, status, surgeryName, 
            OperatedDoctor, Anesthesiologist;
    private Date timeStart, timeEnd;
    private Patient patient;

    public Report() {
    }

    public Report(String surgeryName, Patient patient) {
        this.surgeryName = surgeryName;
        this.patient = patient;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    public String getOperatedDoctor() {
        return OperatedDoctor;
    }

    public void setOperatedDoctor(String OperatedDoctor) {
        this.OperatedDoctor = OperatedDoctor;
    }

    public String getAnesthesiologist() {
        return Anesthesiologist;
    }

    public void setAnesthesiologist(String Anesthesiologist) {
        this.Anesthesiologist = Anesthesiologist;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
}
