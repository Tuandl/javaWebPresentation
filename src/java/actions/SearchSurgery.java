/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import db.RegistrationDAO;
import dtos.Report;
import java.util.List;

/**
 *
 * @author TUANDASE62310
 */
public class SearchSurgery {
    
    private static final String FAIL = "fail";
    private static final String SUCCESS = "success";
    
    private String searchValue;
    private String action;
    private List<Report> result;
    
    public SearchSurgery() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        if(action.equalsIgnoreCase("reset")){
            searchValue = "";
        } 
        if(action.equalsIgnoreCase("search")){
            RegistrationDAO dao = new RegistrationDAO();
            result = dao.findByLikePatientname(searchValue);
            url = SUCCESS;
        }
        return url;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Report> getResult() {
        return result;
    }
}
