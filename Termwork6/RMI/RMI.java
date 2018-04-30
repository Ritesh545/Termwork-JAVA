import java.rmi.*;  
public interface RMI extends Remote{  
        public int length(String s) throws RemoteException;
	public String upperCase(String s) throws RemoteException;
	public String reverse(String s) throws RemoteException; 
}  