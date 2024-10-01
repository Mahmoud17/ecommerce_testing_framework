package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getItemNames() {
        List<WebElement> items =  driver.findElements(By.cssSelector("cartSection h3"));
        return items.stream().map(WebElement::getText).toList();
    }

    public CheckoutPage GoToCheckout() {
        driver.findElement(By.cssSelector(".totalRow button")).click();
        return new CheckoutPage(driver);
    }
}
