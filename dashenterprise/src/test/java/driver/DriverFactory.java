package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static final String DRIVER_PATH = "dashenterprise/src/test/java/sources/drivers/chromedriver.exe";

    private static final Duration IMPLICIT_WAIT = Duration.ofSeconds(15);

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);

        return driver;
    }
}

// export data reponse in javascript