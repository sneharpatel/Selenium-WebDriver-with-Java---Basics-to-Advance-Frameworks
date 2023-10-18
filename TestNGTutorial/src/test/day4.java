package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
	
	
	@Parameters({"URL"})
	@Test
	public void webLoginHomeLoan(String uname) {
		
		System.out.println("WebLoginHomeLoan");
		System.out.println(uname);
		
	}
	
	@Test
	public void mobileLoginHomeLoan() {
		System.out.println("MobileLoginHomeLoan");
		
	}
	
	@Test(groups= {"Smoke"})
	public void loginAPIHomeLoan() {
		
		System.out.println("LoginAPIHomeLoan");
	}

}
