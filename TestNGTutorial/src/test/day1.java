package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class day1 {
	

	
	@Test
	public void demo() {
		System.out.println("Hello World");
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void secondTest() {
		System.out.println("Bye");
	}
	
	@AfterTest
	public void lastExecution() {
		System.out.println("I will execute last");
	}
	
	@AfterSuite
	public void afSuite() {
		System.out.println("I am no 1 from last");
	}

}


// what section-16, video - 143 for all topics covered in TestNG framework
