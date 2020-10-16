package navigationPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	public loginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Login PageObjects o WebElements

	@FindBy(id="txtUsername")
	private WebElement userNameTXT;
	@FindBy(id="txtPassword")
	private WebElement passwordTXT;
	@FindBy(id="btnLogin")
	private WebElement loginBtn;
	@FindBy (xpath="//*[@id=\"spanMessage\"]")
	private WebElement errorMessage;
	
	
	public void login (String user, String password) {
		
		userNameTXT.sendKeys(user);
		passwordTXT.sendKeys(password);
		loginBtn.click();
		
	}
	
	public boolean loginIncorrect (String user, String password) {
		
		userNameTXT.sendKeys(user);
		passwordTXT.sendKeys(password);
		loginBtn.click();
		  
		boolean errorMsj = errorMessage.getText().contains("Invalid credentials");
		
		return errorMsj;
		
	}
	
}
