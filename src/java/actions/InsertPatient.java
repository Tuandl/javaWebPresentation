/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import db.RegistrationDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author TUANDASE62310
 */
public class InsertPatient {
    
    private static final String SUCCESS = "success";
    
    private String username, name, password, address, email, phone, status;
    private boolean isMale;
    private Date DOB;
    
    public InsertPatient() {
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        if(dao.insertPatient(username, name, isMale, DOB, address, email, phone, password)){
            username = null;
            name = null;
            password = null;
            address = null;
            email = null;
            phone = null;
            status = null;
            isMale = false;
            DOB = null;
            request.setAttribute("success", "Insert Successfull");
        } else {
            request.setAttribute("error", "Insert Failed!!");
        }
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
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
    
    
}
