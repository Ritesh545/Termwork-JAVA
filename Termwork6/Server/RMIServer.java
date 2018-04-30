import java.rmi.*;  
import java.rmi.server.*; 
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject; 
import java.rmi.registry.LocateRegistry; 
public class RMIServer extends UnicastRemoteObject implements RMI{  
RMIServer()throws RemoteException{  
super();  
}  
	public int length(String s){
		return s.length();
	}

	public String upperCase(String s){
		String upper;
		upper = s.toUpperCase();
		return upper;
	}

	public String reverse(String s){
		String reverse = "";

		for(int i = s.length()-1; i >= 0; i--)
			reverse = reverse + s.charAt(i);

		return reverse;
	} 
  

public static void main(String args[]) { 
      try { 
           Registry registry = LocateRegistry.createRegistry(1099); 
           registry.bind("Server",new RMIServer());  
         System.err.println("Server ready"); 
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}