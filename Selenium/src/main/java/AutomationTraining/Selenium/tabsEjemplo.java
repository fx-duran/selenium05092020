package AutomationTraining.Selenium;

import java.io.File;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tabsEjemplo {

	public static void main(String[] args) {
		
        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;//Tomando el path del driver en el sistema
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");//Setear propiedad del .exe
        WebDriver driver = new ChromeDriver();//Inicializando el driver
        driver.get("https://demo.guru99.com/popup.php");//Iniciar Chrome en la URL especificada
        driver.manage().window().maximize(); //Maximizar ventana
        
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement btnAdvanced = driver.findElement(By.id("details-button"));
        btnAdvanced.click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement lnkProceed = driver.findElement(By.id("proceed-link"));
        lnkProceed.click();
        
             
        //Obtener e imprimir el ID de la ventana/ Tab original
        String originalTab = driver.getWindowHandle();
        System.out.println(originalTab);
		
		//Click en el link que abre otra ventana
        WebElement clickHere = driver.findElement(By.xpath("//*[contains(@href, 'popup.php')]"));
        clickHere.click();
        
        Set<String> ventanasAbiertas = driver.getWindowHandles();
        
        System.out.println(ventanasAbiertas);
        
        for (String tabNueva : driver.getWindowHandles()) {
        	if(!originalTab.contentEquals(tabNueva)) {
        		driver.switchTo().window(tabNueva);
        		break;
        	}
        }
        
        // Escribir el mail en la nueva ventana
        WebElement emailTxt = driver.findElement(By.name("emailid"));
        emailTxt.sendKeys("test@test.com");
        
        //regresar a la ventana original
        driver.switchTo().window(originalTab);

	}

}
