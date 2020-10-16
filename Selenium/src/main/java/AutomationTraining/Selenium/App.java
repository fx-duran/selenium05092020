package AutomationTraining.Selenium;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Curso Automatización 05.09.2020" );
        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;//Tomando el path del driver en el sistema
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");//Setear propiedad del .exe
        WebDriver driver = new ChromeDriver();//Inicializando el driver
        driver.get("https://opensource-demo.orangehrmlive.com/");//Iniciar Chrome en la URL especificada
        driver.manage().window().maximize();
        
        //Obteniendo elementos/ objetos de la página Login
        
        WebElement txtUserName = driver.findElement(By.id("txtUsername"));
        WebElement txtPassword = driver.findElement(By.id("txtPassword"));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));       		
        		
        //Haciendo Login
        
        txtUserName.sendKeys("Admin");
        txtPassword.sendKeys("admin123");
        btnLogin.click();
        
        //Validación de Home Page
        String urlDashboard = driver.getCurrentUrl();
        System.out.println("URL " + urlDashboard);
        urlDashboard.contains("/dashboard");
        
        //Find Elements
        List<WebElement> firstLevelMenu = driver.findElements(By.xpath("//*[@class='firstLevelMenu']/b"));
        System.out.println("Número de elementos: " + firstLevelMenu.size());
        
        String primerMenu = firstLevelMenu.get(0).getText();
        System.out.println(primerMenu);
        String segundoMenu = firstLevelMenu.get(1).getText();
        System.out.println(segundoMenu);
        
        for (int i = 0; i < firstLevelMenu.size(); i++) {
        	System.out.println("El nombre del menu es: " + firstLevelMenu.get(i).getText());
        }
        
        int b = 0;
        
		do {
			System.out.println("El nombre del menu es: " + firstLevelMenu.get(b).getText());
			++b;
		} while (b < firstLevelMenu.size());
        		
        
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        
        //Navegación en la página
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();
        
        
        //Assign Leave
//        WebElement assignLeaveBtn = driver.findElement(By.className("quickLinkText"));
//        assignLeaveBtn.click();
        
        //Validar texto
//        String welcomeMsj =  driver.findElement(By.id("welcome")).getText();
//        boolean verifyWelcomeMsj = welcomeMsj.contains("Smith");
//        if(verifyWelcomeMsj){
//        	System.out.println("El mensaje de bienvenida contiene el nombre Smith");
//        } else {
//        	System.out.print("ERROR: el mensaje NO contiene el nombre esperado");
//        }
        
        //Dropdowns
//        Select oSelect = new Select(driver.findElement(By.id("assignleave_txtLeaveType")));
//        oSelect.selectByVisibleText("Maternity US");
        
        //Seleccionar Fecha
//        WebElement txtFromDate = driver.findElement(By.id("assignleave_txtFromDate"));
//        WebElement txtToDate = driver.findElement(By.id("assignleave_txtToDate"));
//        txtFromDate.clear();
//        txtFromDate.sendKeys("2020-09-26");
//        txtToDate.clear();
//        txtToDate.sendKeys("2020-09-27");
        
        
        
        //Obteniendo elementos/ objetos de la página Logout
        
        WebElement btnWelcome = driver.findElement(By.id("welcome"));
        btnWelcome.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        		
        WebElement btnLogout = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[10]/ul/li[2]/a"));
        btnLogout.click();
        
        //Cerrar Navegador
        driver.close();
//        driver.quit();

    }
}
