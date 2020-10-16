package C1Bank;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	
    public static void main( String[] args ){
    	
    	//1. Open Browser
        System.out.println( "C1 Login POC" );
        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://creditoneinteractive.com/development/shield.php?message=Sign+In+with+a+valid+Username+and+Password&location=%2Fdevelopment%2F1-2-1%2Ftransactional%2Findex.php");
        driver.manage().window().maximize();
        
        //2. Login 
        WebElement txtUserName = driver.findElement(By.id("username"));
        WebElement txtPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//*[@id='shield']/div/div/div/div/div/div/div/div[2]/div/div/div/div/form/div[3]/button"));    
        
        txtUserName.sendKeys("jkepler");
        txtPassword.sendKeys("Cr3dit1717!22");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
        btnLogin.click();
        
        
        //3. Logout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
        WebElement btnLogout = driver.findElement(By.xpath("/html/body/div[1]/div/header/nav[1]/div/div[2]/div/div[1]/div[3]/a"));
        btnLogout.click();
        
                
        //4. Close Browser
	    driver.close();

    }
}
