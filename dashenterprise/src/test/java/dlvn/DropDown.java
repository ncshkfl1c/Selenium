package dlvn;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
    public static void main(String[] arg) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Open Target
            driver.get("https://the-internet.herokuapp.com/dropdown");

            // Find Dropdown Element
            WebElement dropdown = driver.findElement(By.id("dropdown"));

            // Select instance
            Select select = new Select(dropdown);

            select.selectByVisibleText("Option 1");

            select.selectByValue("2");

            select.selectByIndex(0);

            // DebugOnly
            Thread.sleep(20000);

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
        // ForEach webelement in java
    };
}
