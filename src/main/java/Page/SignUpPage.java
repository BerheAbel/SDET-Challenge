package Page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SignUpPage extends BasePage {

    public void signUp(String username, String password, String age) throws InterruptedException {
        MobileElement usernameInput = driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[1]");
        MobileElement passwordInput = driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[2]");
        MobileElement ageInput = driver.findElementByXPath("//android.widget.ScrollView/android.widget.EditText[3]");
        MobileElement signUpButton = driver.findElementByXPath("//android.widget.TextView[@text=\"Sign In\"]");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        ageInput.sendKeys(age);
        signUpButton.click();
        Thread.sleep(3000);
    }

    public void verifyWelcomeMessage(String expectedMessage) {
        MobileElement textViewElement = driver.findElement(By.className("android.widget.TextView"));
        Assert.assertEquals(textViewElement.getText(), expectedMessage);
    }

    public void verifyErrorMessage(String expectedMessage) {
        MobileElement errorMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + expectedMessage + "\"]"));
        Assert.assertEquals(errorMessage.getText(), expectedMessage);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

