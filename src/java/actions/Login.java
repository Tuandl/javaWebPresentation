/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import db.RegistrationDAO;
import dtos.Employee;
import dtos.Patient;
import dtos.RegistrationDTO;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author TUANDASE62310
 */
public class Login {
    
    private static final String FAIL = "fail";
    private static final String EMPLOYEE = "emp";
    private static final String PATIENT = "patient";
    
    private String username, password;
    private String name, address, email, phone;
    private boolean isMale;
    private Date DOB;
    
    public Login() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        RegistrationDAO dao = new RegistrationDAO();
        RegistrationDTO dto = dao.checkLogin(username, password);
        if(dto == null){
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("error", "Invalid Username or password");
        } else {
            Map session = ActionContext.getContext().getSession();
            session.put("name", dto.getName());
            if(dto instanceof Employee) {
                url = EMPLOYEE;
                session.put("role", "emp");
                session.put("username", username);
            }
            if(dto instanceof Patient){
                url = PATIENT;
                session.put("role", "patient");
                name = dto.getName();
                address = dto.getAddress();
                email = dto.getEmail();
                phone = dto.getPhone();
                isMale = dto.isIsMale();
                DOB = dto.getDOB();
            }
        }
        
        return url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
    
    
}
