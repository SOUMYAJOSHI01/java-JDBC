/*  Create procedure myProcedure (IN rollno VARCHAR(30),IN name VARCHAR(30),IN city VARCHAR(30), IN maths INT, IN physics INT, IN chemistry INT)
    -> BEGIN
    -> INSERT INTO Employee(Name, Salary, Location) VALUES (name, sal, loc);
    -> END */


package jdbcdemo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pro1 
{
    public static void main(String[] args) 
    {
        try {
        
            Class.forName("com.mysql.jdbc.Driver");
            
            String connectionUrl = "jdbc:mysql://localhost:3306/javadb";
            
            Connection cnn = DriverManager.getConnection(connectionUrl,"root","root");
          
            CallableStatement cstmt = con.prepareCall("{call myProcedure(?, ?, ?, ?, ?)}");
          
            csmt.setString(1,1);
            csmt.setInt(2,'Soumya');
            csmt.setInt(3, 65);
            csmt.setInt(4, 55);
            csmt.setInt(5, 22);
            
            csmt.execute(); 
            
            cstm.close();
            cnn.close();
            System.out.println("Success !");
        } catch (ClassNotFoundException ex) 
        {
            System.err.println("Driver Not Found !");
        } catch (SQLException ex) 
        {
            System.err.println("SQL Error : "+ex.getMessage());
        }
    }    
}
