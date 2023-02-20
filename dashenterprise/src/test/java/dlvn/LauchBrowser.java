package dlvn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class LauchBrowser {
    public static void main(String[] args) {
        // 1. Init WebDriver session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // 2, Open Target page || LoginPage
            driver.get("https://dashboard.paveapi.com/login");

            // 3. Find Element

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            WebElement userNameElement = wait
                    .until(ExpectedConditions
                            .visibilityOf(driver.findElement(By.cssSelector("#username"))));

            WebElement passwordElement = driver.findElement(By.cssSelector("#password"));
            WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));

            // type someOne
            userNameElement.sendKeys("enterprise.qa");
            passwordElement.sendKeys("PAVE_enterprise@2022");

            submitBtn.click();

            String[] arr = { "u", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l" };

            for (String a : arr) {
                System.out.println("chữ" + a);
            }
            ;

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    };

}
