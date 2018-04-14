package Serialization;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sever {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null; 

	    try { 
	         serverSocket = new ServerSocket(89); 
	        } 
	    catch (IOException e) 
	        { 
	         System.err.println("Could not listen on port: 89."); 
	         System.exit(1); 
	        } 

	    Socket clientSocket = null; 

	    try { 
	         System.out.println ("Waiting for Client");
	         clientSocket = serverSocket.accept(); 
	        } 
	    catch (IOException e) 
	        { 
	         System.err.println("Accept failed."); 
	         System.exit(1); 
	        } 

	    ObjectOutputStream out = new ObjectOutputStream(
	                                     clientSocket.getOutputStream()); 
	    ObjectInputStream in = new ObjectInputStream( 
	                                     clientSocket.getInputStream()); 

	   
           Person p = null;
	    try {
	    	p = (Person) in.readObject();
	        }
	    catch (Exception ex)
	        {
	         System.out.println (ex.getMessage());
	        }


	    System.out.println (p.getFirstName()+p.getLastName());

	    Person p1 = new Person("nga_sv", "thu_sv");
	    
	    out.writeObject(p1); 
	    out.flush();


	    out.close(); 
	    in.close(); 
	    clientSocket.close(); 
	    serverSocket.close(); 
	   } 
	}


