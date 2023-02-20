package dlvn;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HandleCheckBox {
    public static void main(String[] arg) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Open Target
            driver.get("https://the-internet.herokuapp.com/checkboxes");

            // find List element => arr
            List<WebElement> checkboxElements = driver.findElements(By.cssSelector("input[type='checkbox']"));
            WebElement checkboxEle01 = checkboxElements.get(0);
            WebElement checkboxEle02 = checkboxElements.get(1);

            // Select Check Box
            checkboxEle01.click();
            checkboxEle02.click();

            // Choose select box not choose
            for (WebElement checkboxElement : checkboxElements) {
                if (!checkboxElement.isSelected()) {
                    checkboxElement.click();
                }
            }
            // DebugOnly
            Thread.sleep(20000);

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
        // ForEach element in java
    };
}
