import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PS {

	
	public void doThis() {
		System.out.println("I am here");
	}
	
	@BeforeMethod
	public void beforeRun() {
		
		System.out.println("Before method will run first: Run me first");
	}
	
	@AfterMethod
	public void afterRun() {
		System.out.println("After method will run first: Run me last");
	}


}
