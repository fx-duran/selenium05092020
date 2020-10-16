package loginTests;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import commonMethods.variablesGlobales;
import driverSetUp.DriverSetUp;
import navigationPages.dashboardPage;
import navigationPages.loginPage;

public class TC_03_Logout {
	WebDriver driver = DriverSetUp.setUpDriver();
	
	//Login Page Object
	loginPage login = new loginPage(driver);
	dashboardPage dashboard = new dashboardPage(driver);
	
	@BeforeTest
	public void startWebDriver() {
		driver.get(variablesGlobales.HOME_PAGE);
		driver.manage().window().maximize();
	}
	
  @Test
  public void TC_03 () {
	  login.login(variablesGlobales.USER_ADMIN, variablesGlobales.PASSWORD_ADMIN);
	  dashboard.logout();
  }
  
  @AfterTest
  public void closeDriver() {
	  driver.quit();
  }
  
}
