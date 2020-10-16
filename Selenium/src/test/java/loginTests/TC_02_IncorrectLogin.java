package loginTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.variablesGlobales;
import driverSetUp.DriverSetUp;
import navigationPages.loginPage;

public class TC_02_IncorrectLogin {
	WebDriver driver = DriverSetUp.setUpDriver();
	
	//Login Page Object
	loginPage login = new loginPage(driver);
	
	@BeforeTest
	public void startWebDriver() {
		driver.get(variablesGlobales.HOME_PAGE);
		driver.manage().window().maximize();
	}
	
  @Test
  public void TC_02 () {
	  boolean isIncorrect = login.loginIncorrect(variablesGlobales.USER_ADMIN, "incorrectpassword");
	  Assert.assertTrue(isIncorrect);
  }
  
  @AfterTest
  public void closeDriver() {
	  driver.quit();
  }
  

}
