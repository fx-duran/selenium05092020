package Ejercicio092620;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ejercicio092620 {

    public static void main( String[] args ){
    	
        System.out.println( "Ejercicio 06.09.2020" );
        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        
        //1. Login en OrangeHR
        WebElement txtUserName = driver.findElement(By.id("txtUsername"));
        WebElement txtPassword = driver.findElement(By.id("txtPassword"));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));       		
        txtUserName.sendKeys("Admin");
        txtPassword.sendKeys("admin123");
        btnLogin.click();
                
        //2.  Click en Directory tab
        WebElement tabDirectory = driver.findElement(By.id("menu_directory_viewDirectory"));
        tabDirectory.click();
        
        //3. Búsqueda
        //3.1 Capturar nombre
        WebElement txtName = driver.findElement(By.id("searchDirectory_emp_name_empName"));
        txtName.sendKeys("Robert");     
        
        //3.2 Seleccionar rol
        Select dropdownJobTitle = new Select(driver.findElement(By.id("searchDirectory_job_title")));
        dropdownJobTitle.selectByVisibleText("Sales Manager");  
        
        //3.3 Seleccionar ubicación    
        Select dropdownLocation = new Select(driver.findElement(By.id("searchDirectory_location")));
        dropdownLocation.selectByValue("3,1,2,-1");;  
        
        //3.4 Comenzar búsqueda
        WebElement btnSearch = driver.findElement(By.id("searchBtn"));
        btnSearch.click();
        
        //4. Validar resultado búsqeda
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);       		
        String resultName = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/table/tbody/tr[2]/td[2]/ul/li[1]/b")).getText();
        System.out.println(resultName);
        boolean verifyName = resultName.contains("Robert");
	    if(verifyName){
	    	System.out.println("El resultado contiene el nombre Robert");
	    } else {
	    	System.out.print("ERROR: el resultado NO contiene el nombre Robert");
	    }       
          
        //5. Logout    
        WebElement btnWelcome = driver.findElement(By.id("welcome"));
        btnWelcome.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);       		
        WebElement btnLogout = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[10]/ul/li[2]/a"));
        btnLogout.click();
        
        //6. Cerrar Navegador
	    driver.close();

    }
}
	
	
	
