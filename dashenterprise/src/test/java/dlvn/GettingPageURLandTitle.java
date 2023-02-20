package dlvn;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class GettingPageURLandTitle {
    public static void main(String[] args) {
        // 1. Init WebDriver session
        WebDriver driver = DriverFactory.getChromeDriver();

        // 2, Open Target page || LoginPage
        driver.get("https://the-internet.herokuapp.com/login");

        By usernameSelector = By.id("username");
        By passwordSelector = By.id("password");
        By loginBtnSelector = By.cssSelector("[type=\"submit\"]");

        WebElement usernameElem = driver.findElement(usernameSelector);
        WebElement passwordElem = driver.findElement(passwordSelector);
        WebElement loginBtnElem = driver.findElement(loginBtnSelector);

        usernameElem.sendKeys("tomsmith");
        passwordElem.sendKeys("SuperSecretPassword!");
        loginBtnElem.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginBtnSelector));

        String pageTitleAfterLogin = driver.getTitle();
        String pageUrlAfterLogin = driver.getCurrentUrl();

        System.out.println("Page Title " + pageTitleAfterLogin);
        System.out.println("Page URL " + pageUrlAfterLogin);

        try {
            URL urlParser = new URL(pageUrlAfterLogin);
            System.out.println("Page's base URL: " + urlParser.getHost());
            System.out.println("Page URL path: " + urlParser.getPath());

        } catch (Exception e) {
            e.printStackTrace();
        };

        driver.quit();
    };

}
