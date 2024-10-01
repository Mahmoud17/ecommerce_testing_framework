package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalPage extends BasePage {

    public FinalPage(WebDriver driver) {
        super(driver);
    }
    public String getMessage() {
        return driver.findElement(By.cssSelector(".hero-primary")).getText();
    }
}
