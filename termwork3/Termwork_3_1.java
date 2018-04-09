import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
class Termwork_3_1
{
public static void main (String args[])
  {
  try
  {
      Class.forName ("com.mysql.jdbc.Driver");
      Connection con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/termwork3","root", "");
      //con.setAutoCommit (false);
      //con.setTransactionIsolation (Connection.TRANSACTION_READ_COMMITTED);
      Reader read = new Reader (con);
      Update write = new Update (con);
      try
      {
	write.start ();
	read.start ();
      } 
      catch (Exception e) 
      {
	System.out.print (e);
      } 
 
} 
catch (SQLException e)
    {
      e.printStackTrace ();
  
    } 
catch (ClassNotFoundException ex)
    {
    Logger.getLogger (Termwork_3_1.class.getName ()).log (Level.SEVERE, null,ex);

    } 
  } 
} 
class Reader extends Thread
{

Connection con;
 
Reader (Connection con) 
  {
  this.con = con;
  
  } 
public void run ()
  {
    
try
    {
      
Statement stmt = con.createStatement ();
ResultSet rs = stmt.executeQuery ("select * from student");
//while (rs.next ())
//System.out.println (rs.getString (1) + "  " + rs.getString (2) + "  " + rs.getInt (3));
File file = new File("C:\\Users\\Ritesh\\Desktop\\ghanta\\xyz.txt");
        FileWriter fstream = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fstream);
    while(rs.next())  {
        String s1=rs.getString(1);
        String s2=rs.getString(2);
        int s3=rs.getInt(3);
    System.out.println(s1+"  "+s2+"  "+s3);
    
        out.write(s1+" ");
        out.write(s2+" ");
        out.write(Integer.toString(s3)+" ");
         }
        out.close();
        
        }
    

catch (SQLException e)
{
e.printStackTrace ();
    
}   catch (IOException ex) {
        Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
    }
  
}

}


 
class Update extends Thread
{
  
Connection con;
Update (Connection con) 
  {
    this.con = con;
  }
  
public void run ()
  {  
try
  {
this.sleep (1000);
Statement stmt = con.createStatement ();
stmt.executeUpdate ("update student set usn='2sd15cs001' where sem=7");
      //System.out.println("h");
    } catch (SQLException e)
    {  
e.printStackTrace ();
} catch (InterruptedException ex)
    {      
Logger.getLogger (Update.class.getName ()).log (Level.SEVERE, null,ex);

} 
} 
} 
