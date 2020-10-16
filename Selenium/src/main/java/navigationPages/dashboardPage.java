package navigationPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashboardPage {
	
	public dashboardPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Login PageObjects o WebElements

	@FindBy (id="welcome")
	private WebElement btnProfile;
	@FindBy (xpath = "/html/body/div[1]/div[1]/div[10]/ul/li[2]/a")
	private WebElement btnLogout;
	
	
	public void logout () {
		
		btnProfile.click();
		btnLogout.click();
		
	}
	
}
