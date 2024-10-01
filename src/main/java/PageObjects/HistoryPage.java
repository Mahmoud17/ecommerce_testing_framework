package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HistoryPage extends BasePage{

    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkProductInHistory(String productName) {
        List<WebElement> products = driver.findElements(By.cssSelector("tbody tr td:nth-of-type(2)"));
        return products.stream().anyMatch(product -> product.getText().contains(productName));
    }

}
