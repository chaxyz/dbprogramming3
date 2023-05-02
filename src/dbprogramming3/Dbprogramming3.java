/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbprogramming3;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Student
 */
public class Dbprogramming3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb3";
        String username = "root";
        String password = "mysql@sit";
        try {
            // load driver into project
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            System.out.println("Driver loaded");
            
            // build object connection
            Connection con= DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            
            // order a command through statement
            Statement statement= con.createStatement();
            String sql = "select * from student";
            
            // keep a result in object of ResultSet , we must iterrate through this object
            ResultSet result = statement.executeQuery(sql);
            
            //loop through array to get attitube 
            while(result.next()){
                System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4));
            
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbprogramming3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbprogramming3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
