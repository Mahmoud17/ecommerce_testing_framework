package Tests;

import PageObjects.*;
import Tests.TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MakeOrderValidTest extends BaseTest {
    final String productName = "ZARA COAT 3";
    @Test
    public void MakeAnOrder() {


        ProductsPage productsPage = loginPage.login("mahmoud@ayoub.com", "P@ssw0rd");

        Sleep(1000);

        List<WebElement> products = productsPage.getProducts();
        WebElement product = productsPage.getProductByName(products, productName);

        productsPage.addToCart(product);

        CartPage cartPage = productsPage.GoToCart();
        CheckoutPage checkoutPage = cartPage.GoToCheckout();

        checkoutPage.EnterLocation("british");
        FinalPage finalPage = checkoutPage.CompleteOrder();


        String message = finalPage.getMessage();
        Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
    }

    @Test(dependsOnMethods = "MakeAnOrder")
    public void CheckInHistory() {
        HistoryPage historyPage = loginPage.goToOrderHistory();
        Assert.assertTrue(historyPage.checkProductInHistory(productName));
    }

    public static void Sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
