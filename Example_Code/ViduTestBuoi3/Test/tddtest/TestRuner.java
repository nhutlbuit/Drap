package tddtest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRuner {

	public TestRuner(){
		try{
		UnitTest test = new BookTest();
		test.runTest();
		System.out.println("Success");
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Failure");
		}
	}

	public static void main(String[] args) {
		new TestRuner();
	}
}
