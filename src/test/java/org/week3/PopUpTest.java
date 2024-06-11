package org.week3;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PopUpTest extends BaseTest {
    PopUpPage popUpPage = new PopUpPage();

    @Test
    public void popUpTest() {
        popUpPage.popUpBtn().click();
        assertTrue(WebDriverRunner.url().contains("popups/"));

        // check if its using chrome driver
        assertTrue(WebDriverRunner.isChrome());

        // Alert
        popUpPage.alertPopupBtn().click();
        Alert alert = switchTo().alert();
        alert.accept();

        // Confirm Popup
        popUpPage.confirmPopupBtn().click();
        alert.accept();

        // Prompt Popup
        popUpPage.promptPopupBtn().click();
        alert.sendKeys("good");
        popUpPage.promptPopupAssertion();
    }

}
