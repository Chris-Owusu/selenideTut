package org.week3;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PopUpTest extends BaseTest {
    PopUpPage popUpPage = new PopUpPage();

    @BeforeMethod
    public void popupPage() {
        popUpPage.popUpBtn().click();
        assertTrue(WebDriverRunner.url().contains("popups/"));

        // check if its using chrome driver
        assertTrue(WebDriverRunner.isChrome());
    }

    // Alert
    @Test(priority = 1)
    public void alertPopupTest() {

        popUpPage.alertPopupBtn().click();
        Alert alert = switchTo().alert();
        alert.accept();
    }

    // Confirm Popup
    @Test(priority = 2)
    public void confirmPopupTest() {
        popUpPage.confirmPopupBtn().click();

        Alert alert = switchTo().alert();
        alert.accept();
    }

    // Prompt Popup
    @Test(priority = 3)
    public void promptPopupTest() {
        popUpPage.promptPopupBtn().click();

        Alert alert = switchTo().alert();
        alert.sendKeys("good");
        popUpPage.promptPopupAssertion();
    }

}
