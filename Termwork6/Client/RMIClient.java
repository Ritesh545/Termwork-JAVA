import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;  

public class RMIClient {  
   private RMIClient() {}  
   public static void main(String[] args) {  
      try {  
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099); 
    
         // Looking up the registry for the remote object 
         RMI stub = (RMI) registry.lookup("Server"); 
    
         // Calling the remote method using the obtained object 
         	if(args.length==0){
				System.out.println("Usage: <filename> <String> ");
				System.exit(0);
			}

			String s= args[0];

			int length;
			String upper;
			String reverse;
			length = stub.length(s);
			upper = stub.upperCase(s);
			reverse = stub.reverse(s);

			System.out.println("Length of String = " +length);
			System.out.println("UpperCase of given String =  " +upper);
			System.out.println("Reverse of given String =  " +reverse);
	  ; 
         
         // System.out.println("Remote method invoked"); 
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}