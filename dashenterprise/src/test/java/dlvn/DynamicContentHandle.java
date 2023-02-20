package dlvn;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicContentHandle {
    public static void main(String[] arg) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        By removeButtonSelector = By.cssSelector("#checkbox-example button");
        By checkBoxSelector = By.id("checkbox");
        By inputSelector = By.cssSelector("#input-example input");
        By enableInputBtnSelector = By.cssSelector("#input-example button");

        System.out.println("Is the checkbox displayed: " + driver.findElement(checkBoxSelector).isDisplayed());

        driver.findElement(removeButtonSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Chờ nó ko hiển thị
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBoxSelector));

        try{
            driver.findElement(checkBoxSelector);
        } catch (Exception e){
            System.out.println("The check Box wasLauchBrowser removed:");
        };

        //Handle the input form
        System.out.println("Is the input form enable: " + driver.findElement(inputSelector).isEnabled());
        driver.findElement(enableInputBtnSelector).click();
        wait.until(ExpectedConditions.textToBe(enableInputBtnSelector, "Disable"));
        System.out.println("Is the Input form enable: " + driver.findElement(inputSelector).isEnabled());

        driver.quit();
    };
}
