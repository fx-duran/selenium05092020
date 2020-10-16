package AutomationTraining.Selenium;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fluentWait {

	public static void main(String[] args) {
        System.out.println( "Curso Automatización 05.09.2020" );
        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;//Tomando el path del driver en el sistema
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");//Setear propiedad del .exe
        WebDriver driver = new ChromeDriver();//Inicializando el driver
        driver.get("https://opensource-demo.orangehrmlive.com/");//Iniciar Chrome en la URL especificada
        driver.manage().window().maximize();
        
        Wait<WebDriver> wait = new FluentWait<>(driver)
        		.withtimeout(Duration.ofSeconds());

	}

}
