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

public class Client {

	public static void main(String[] args)  throws IOException{
		Socket echoSocket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {
            // echoSocket = new Socket("taranis", 7);
            echoSocket = new Socket("127.0.0.1", 89);
            
            out = new ObjectOutputStream(echoSocket.getOutputStream());
            in = new ObjectInputStream(echoSocket.getInputStream());

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: taranis.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: taranis.");
            System.exit(1);
        }

        Person p1 = new Person("nga", "thuy");
        Person p2 = null;

        System.out.println ("Sending object person 1: " + p1 + " to Server");
	    out.writeObject(p1);
        out.flush();
        System.out.println ("Send object person 1, waiting for return value");

        try {
             p2 = (Person) in.readObject();
            }
        catch (Exception ex)
            {
             System.out.println (ex.getMessage());
            }

	System.out.println("Got object person 2: " + p2 + " from Server");

	out.close();
	in.close();
	echoSocket.close();
    }

}
