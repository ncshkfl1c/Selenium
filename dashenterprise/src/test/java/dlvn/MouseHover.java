package dlvn;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseHover {
    public static void main(String[] arg) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Open Target
            driver.get("https://the-internet.herokuapp.com/hovers");
            By avatarSelector = By.cssSelector(".figure");
            By userNameSelector = By.cssSelector(".figcaption h5");
            By userNameHyperLink = By.cssSelector(".figcaption a");

            //final là biến nó không thay đổi
            final int USER_1_INDEX = 0;
            final int USER_2_INDEX = 1;
            final int USER_3_INDEX = 2;

            List<WebElement> userAvatarElems = driver.findElements(avatarSelector);
            List<WebElement> userNameElems = driver.findElements(userNameSelector);
            List<WebElement> userNameHyperLinkElems = driver.findElements(userNameHyperLink);

            Actions action = new Actions(driver);

            //USER 1
            action.moveToElement(userAvatarElems.get(USER_1_INDEX)).perform();
            System.out.println(userNameElems.get(USER_1_INDEX).getText());
            System.out.println(userNameHyperLinkElems.get(USER_1_INDEX).getAttribute("href"));

            //USER 2
            action.moveToElement(userAvatarElems.get(USER_2_INDEX)).perform();
            System.out.println(userNameElems.get(USER_2_INDEX).getText());
            System.out.println(userNameHyperLinkElems.get(USER_2_INDEX).getAttribute("href"));

            //USER 3
            action.moveToElement(userAvatarElems.get(USER_3_INDEX)).perform();
            System.out.println(userNameElems.get(USER_3_INDEX).getText());
            System.out.println(userNameHyperLinkElems.get(USER_3_INDEX).getAttribute("href"));

            // DebugOnly
            driver.navigate().refresh();

            Thread.sleep(2000);

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
    };
}
