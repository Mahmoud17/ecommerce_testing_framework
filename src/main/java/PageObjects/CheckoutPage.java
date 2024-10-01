package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void EnterLocation(String location) {
        driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys(location);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        List<WebElement> options = driver.findElements(By.cssSelector(".ta-results"));

        for (WebElement option : options) {
            if (option.getText().toLowerCase().contains(location)) {
                option.click();
                break;
            }
        }
    }

    public FinalPage CompleteOrder() {

        driver.findElement(By.cssSelector(".action__submit")).click();
        return new FinalPage(driver);
    }
}
