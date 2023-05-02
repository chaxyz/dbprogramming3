package dbprogramming3;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class LAB9 {
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
            String sql = "insert into student (studentID,firstname,lastname,email,deptID) " 
                    + "values('111111','aaa','bbb','aaaa@gmail.com','IT')";
            
            
            statement.executeUpdate(sql);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbprogramming3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbprogramming3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
