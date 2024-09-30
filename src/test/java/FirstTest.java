import CartPage.CartPage;
import CheckoutPage.CheckoutPage;
import LoginPage.LoginPage;
import ProductPage.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FirstTest {

    public static void main(String[] args) {
        String productName = "ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login("mahmoud@ayoub.com", "P@ssw0rd");

        Sleep(1000);

        ProductsPage productsPage = new ProductsPage(driver);
        List<WebElement> products = productsPage.getProducts();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement product = productsPage.getProductByName(products, productName);

        productsPage.addToCart(product);

        productsPage.GoToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.GoToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.EnterLocation("british");
        checkoutPage.CompleteOrder();


        String message = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
    }

    public static void Sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
