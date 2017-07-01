/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import db.RegistrationDAO;
import dtos.Patient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author TUANDASE62310
 */
public class UpdatePatient {

    private String username, name, address, email, phone;
    private boolean isMale;
    private Date DOB;

    public UpdatePatient() {
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out.println(username);
        System.out.println(name);
        System.out.println(address);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(isMale);
        System.out.println(DOB.toString());
        if (dao.updatePatient(username, name, isMale, DOB, address, email, phone)) {
            request.setAttribute("success", "Update Successful!");
        } else {
            request.setAttribute("fail", "Update Failed!");
        }
        return "success";
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
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    
}
