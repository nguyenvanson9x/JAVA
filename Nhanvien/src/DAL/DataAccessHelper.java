/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nambh
 */
public class DataAccessHelper {

    protected Connection con;
    String HostName = "localhost";
    String port = "1433";
    String dbName = "ProjectManagement";
    String use = "sa";
    String pass = "123456";
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    String URL = "jdbc:sqlserver://" + HostName + ":" + port + ";database=" + dbName;
    
    public void getConnect(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, use, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void getClose(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
