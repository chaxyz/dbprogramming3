package dbprogramming3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB11 {
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
            
            // order a command through statement object
            Statement statement= con.createStatement();
            String sql = "delete from student where studentID = '111111'" ;
            statement.execute(sql);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbprogramming3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbprogramming3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

