package Tests;
import Tests.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginErrorValidationTest extends BaseTest {

    @Test
    public void Login() {

        loginPage.login("mahmoud@ayoub.com", "P@ssw0rd00");
        String errorMessage = loginPage.getErrorMessage();

        Assert.assertTrue(errorMessage.contains("Incorrect"));
    }
}
