package dbprogramming3;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author Student
 */
public class LAB15 {

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
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");

            // order a command through statement
            Statement statement = con.createStatement();
            String sql = "select * from student";

            // keep a result in object of ResultSet , we must iterrate through this object
            ResultSet result = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = result.getMetaData();

            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
            }
            System.out.println();

            while (result.next()) {
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    System.out.printf("%-12s\t", result.getObject(i));
                }
                System.out.println();
            }
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbprogramming3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbprogramming3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
