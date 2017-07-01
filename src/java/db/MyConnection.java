/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author TUANDASE62310
 */
public class MyConnection {

    private static final String connectString = "jdbc:sqlserver://localhost:1433;"
            + "database = JavaWebPresentation;"
            + "username = sa;"
            + "password = 123456789;";

    private MyConnection() {
    }
    
    public static Connection getMyConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
