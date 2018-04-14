
package Serialization;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialize implements Runnable {
	static Thread thrd1 ;
	static Thread thrd2 ;
	 private Thread t;
	   private String threadName;
	static int i;
	//static Serialize runnable = new Serialize(threadName);
   
	Serialize( String name){
	       threadName = name;
	       System.out.println("Creating " +  threadName );
	   }
	public static void main(String[] args)  {
		Serialize T1 = new Serialize( "Thread-1");
	      T1.start();
	      
	      Serialize T2 = new Serialize( "Thread-2");
	      T2.start();
		
//		runThread1();
//		
//		runThread2();
		
		
//		(new Thread(new Serialize())).start();
//		(new Thread(new Serialize())).start();
		
		    String filename = "Serialize.file";
		    Person p = new Person("Nam", "Hoang le");
		   

		    // save the object to file
		    FileOutputStream fos = null;
		    ObjectOutputStream out = null;
		    try {
		      fos = new FileOutputStream(filename);
		      out = new ObjectOutputStream(fos);
		      out.writeObject(p);
//		      System.out.println();

		      out.close();
		    } catch (Exception ex) {
		      ex.printStackTrace();
		    }
		    // read the object from file
		    // save the object to file
		    FileInputStream fis = null;
		    ObjectInputStream in = null;
		    try {
		      fis = new FileInputStream(filename);
		      in = new ObjectInputStream(fis);
		      // ep kieu (Person) khi reserialize, vi khi reserialize no ko biet kieu object.
		      p = (Person) in.readObject();
		      in.close();
		    } catch (Exception ex) {
		      ex.printStackTrace();
		    }
		    
		    System.out.println(p.getFirstName()+p.getLastName());
		  }
	
	@Override
	public void run() {
		for ( i = 0; i < 20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		// TODO Auto-generated method stub
		
	}
	 public void start ()
	   {
	      System.out.println("Starting " +  threadName );
	      if (t == null)
	      {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }

	
//	public static void runThread1(){
//		
//		thrd1 = new Thread(runnable, "Thread1");
//		thrd1.start();
//		System.out.println("Thread1 start...");
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		thrd1.stop();
//		
//		
//		
//	};
//	
//	@SuppressWarnings("deprecation")
//	public static void runThread2(){
//		if (thrd2== null) {
//
//		thrd2 = new Thread(runnable, "Thread2");
//		thrd2.start();
//		
//		
//		System.out.println("Thread2 start...");
//		try {
//			
//			if(i==10){
//				System.out.println("Thread2 counter = 11 completed...");
//				Thread.sleep(8000);
//			};
//			thrd2.stop();
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//		
//		
//		
//	};
	}


