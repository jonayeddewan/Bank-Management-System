
package bank.management.system;

import java.sql.*; 
        
public class Connector {
    
    Connection c;
    Statement s;
    public Connector()
    {
        try
        {
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///BankManagementSystems", "root", " ");
            s = c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
