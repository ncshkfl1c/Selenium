package dlvn;

import driver.DriverFactory;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RightClick {
    public static void main(String[] arg) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Open Target
            driver.get("https://the-internet.herokuapp.com/context_menu");

            By rightClickPlace = By.id("hot-spot");
            // Right Click action
            Actions action = new Actions(driver);
            WebElement rightClickElement = driver.findElement(rightClickPlace);
            action.contextClick(rightClickElement).perform();
            //ContexClick = RightClick

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            System.out.println(alert.getText());
            alert.accept();

            driver.navigate().refresh();
            // DebugOnly
            Thread.sleep(2000);

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
        // Write reponse in file Javacript
    };
}
