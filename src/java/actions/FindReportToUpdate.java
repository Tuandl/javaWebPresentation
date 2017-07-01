/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import db.RegistrationDAO;
import dtos.Report;
import java.util.Date;

/**
 *
 * @author TUANDASE62310
 */
public class FindReportToUpdate {
    
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    
    private String reportID;
    private String searchValue;
    private Report report;
    
    public FindReportToUpdate() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        RegistrationDAO dao = new RegistrationDAO();
        report = dao.findReportByReportID(reportID);
        if(report != null) url = SUCCESS;
        return url;
    }

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Report getReport() {
        return report;
    }
    
    
   
}
