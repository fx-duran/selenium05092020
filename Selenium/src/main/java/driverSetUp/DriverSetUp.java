package driverSetUp;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetUp {

	public static WebDriver setUpDriver () {

        System.out.println( "Curso Automatización 05.09.2020" );
        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "driver" + File.separator;//Tomando el path del driver en el sistema
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver.exe");//Setear propiedad del .exe
        WebDriver driver = new ChromeDriver();//Inicializando el driver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  

        return driver;
		
		
	}

}
