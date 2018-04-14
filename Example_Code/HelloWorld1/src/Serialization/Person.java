package Serialization;

import java.io.Serializable;

public class Person implements Serializable,Runnable {
	 private String firstName;
	  private String lastName;
	  // stupid example for transient : transient not writte 
	  transient private Thread myThread;

	  public Person(String firstName, String lastName) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.myThread = new Thread();
	  }

	  public String getFirstName() {
	    return firstName;
	  }

	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }

	  public String getLastName() {
	    return lastName;
	  }

	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }

	  @Override
	  public String toString() {
	    return "Person [firstName=" + firstName + ", lastName=" + lastName
	        + "]";
	  }
// compare thread vs service
	@Override
	public void run() {
		// TODO Auto-generated method stub 
		
		
	}

}
