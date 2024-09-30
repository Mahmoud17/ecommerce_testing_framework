package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public  ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    List<WebElement> products;

    By productsSelector = By.cssSelector(".card");
    By addToCartButton = By.cssSelector(".card-body button:last-of-type");

    public List<WebElement> getProducts() {
        waitForElementToAppear(productsSelector);
        products = driver.findElements(By.cssSelector(".card"));
        return products;
    }

    public WebElement getProductByName(List<WebElement> products, String productName) {
        return products.stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText().contains(productName))
                .findFirst().orElse(null);
    }
    public void addToCart(WebElement product) {
        product.findElement(addToCartButton).click();
        waitForElementToAppear(By.cssSelector("#toast-container"));
        waitForElementToDisappear(driver.findElement(By.cssSelector(".ng-animating")));
    }

}
