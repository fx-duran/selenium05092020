package AutomationTraining.Selenium;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert {
	
	SoftAssert softAssert1 = new SoftAssert();
	
  @Test
  public void softAssertEquals() {
	  
	  int a = 5;
	  int b = 10;
	  int x = 8;
	  int y = 8;
	  
	  softAssert.assertEquals(a, b);
	  softAssert.softAssertEquals(x, y);
	  
	  softAssert1.assertAll(;)
  }
}
