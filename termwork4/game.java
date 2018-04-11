import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class game extends Applet
implements ActionListener
{
	String msg=" ";
	TextField t1;
        TextField t2,t3;
        Label l1;
        String RES;
        String RES1;
	String a1;
	Button clear,result;
        private Connection con;
        private Statement st;
        private ResultSet rs;
	
	public void init()
	{
		Color k=new Color(120,89,90);
		setBackground(k);
              //  l1=new Label("ANY NUMBER");  
                t1=new TextField("ENTER ANY NUMBER");
                t2=new TextField("SCORE");
                t3=new TextField("enter your name");
                result=new Button("result");
		add(t1);
                add(t2);
                add(t3);
		//add(clear);
                add(result);
                //add(l1);
		t1.addActionListener(this);
                t2.addActionListener(this);
                t3.addActionListener(this);
               result.addActionListener(this);
               
               try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con =DriverManager.getConnection("jdbc:mysql://localhost:3306/random?useSSL=false","root","");
                   st=con.createStatement();
            
                  }catch(Exception ex){
                    System.out.println("Erro:"+ex);
              } 
	   }
 
               public void getData(String a1,String RES,String RES1){
               try{
                   String query="INSERT INTO score(name,win,loss) VALUE ('"+a1+"','"+RES+"','"+RES1+"');";
                   st.executeUpdate(query);
                   }catch(Exception ex){
                    System.out.println("Erro:"+ex);
                 }
              }
        
	       public void actionPerformed(ActionEvent e)
	        {
		   Random t = new Random();
                   int a=t.nextInt(2);
                   System.out.println(a);
                   String s1=t1.getText();  
		   int z=Integer.parseInt(s1);
                   if(e.getSource()==result)
                     {  
		       if(z==a)
		         {
                         t2.setText("you win");//score=1
		         }
                       else
                          {
                         t2.setText("you lose");//score=0
                          }
                     }
	   
                    a1=t3.getText();//username
                    String a2=t2.getText();//score
                    if(a2.equals("you win"))
                      {
                        RES="1";
                        RES1="0";
                      }
                    if(a2.equals("you lose"))
                      {
                        RES="0";
                        RES1="1";
                      }
                
                      getData(a1, RES, RES1);
           
                }
             }      
