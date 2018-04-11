import java.net.*;  
import java.io.*;  
class MyServer{  
public static void main(String args[])throws Exception{  
ServerSocket ss=new ServerSocket(3333);  //establishing connection
Socket s=ss.accept();//return socket and establish connection between server and client  
DataInputStream din=new DataInputStream(s.getInputStream()); //to get data from client 
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  //to send data from server to client
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
String str="",str2=""; 


while(!str.equals("stop")){  
  
str=din.readUTF();  
System.out.println("client says: "+str);  
System.out.print("server: ");
str2=br.readLine();  
dout.writeUTF(str2);  
dout.flush();  
}  
din.close();  
s.close();  
ss.close();  
}}  
