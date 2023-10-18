package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	
	
	@BeforeClass
	public void beforeClas() {
		
		System.out.println("Beforeclas method will execute first before all methods in class day3");
	}
	
	@Test(groups= {"Smoke"})
	public void webLoginCarLoan() {
		
		System.out.println("WebLoginCarLoan");
		
	}
	
	
	@AfterClass
	public void afterClas() {
		
		System.out.println("afterclas method will execute after all methods in class day3");
	}
	
	@BeforeMethod
	public void beforeMethodExecution() {
		System.out.println("I will execute before each test of class day3");
		
	}
	
	@AfterMethod
	public void AfterMethodExecution() {
		System.out.println("I will execute after each test of class day3");
		System.out.println("****************");
		
	}
	
@Parameters({ "URL", "APIKey/username" })
	@Test
	public void mobileLoginCarLoan(String urlName, String username) {
		System.out.println("Mobile Login CarLoan");
		System.out.println(urlName); // this should print carloan.com
		System.out.println(username); // this should print carloan.com
		
		
	}
	
	@BeforeSuite
	public void bfSuite() {
		System.out.println("I am no 1");
	}
	
	// enabled is a helper attribute
	@Test(enabled=false)
	public void mobileSigninCarLoan() {
		System.out.println("Mobile Signin CarLoan");
		
	}
	
	// timeOut is a helper attribute
	@Test(dataProvider="getData") 
	public void mobileLogOutCarLoan(String username, String password) {
		System.out.println("Mobile LogOut CarLoan");
		System.out.println(username);
		System.out.println(password);
		
	}
	
	// dependsOnMethods, enabled = helper attributes
	@Test(dependsOnMethods = {"webLoginCarLoan", "mobileLogOutCarLoan"}) 
	public void APICarLoan() {
		
		System.out.println("API CarLoan");
	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		//1. 1st combination of user name and password - good credit history
		//2. 2nd user name, password - no credit history
		//3. 3rd user name, password - fruadelent credit history
		
		Object[][] data = new Object[3][2];
		
		// 1st data set
		data[0][0] = "firstsetusername";
		data[0][1] = "firstpassword";
		
		// 2nd data set
		data[1][0] = "secondsetusername";
		data[1][1] = "secondpassword";
		
		//3rd data set
		data[2][0] = "thirdsetusername";
		data[2][1] = "thirdpassword";
		
		return data;
		
	}


}
