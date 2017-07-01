/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

/**
 *
 * @author TUANDASE62310
 */
public class Logout {
    
    public Logout() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        session.clear();
        return "success";
    }
    
}
