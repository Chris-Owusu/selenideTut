package org.week3;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WindowsOperationTest extends BaseTest {
    WindowsOperationPage windowsOperationPage = new WindowsOperationPage();

    @Test
    public void windowsOperationTest() {
        assertEquals(url(), "https://practice-automation.com/");
        windowsOperationPage.winOpsBtn().click();
        assertTrue(url().contains("window-operations/"));

        // Get main window
        String mainWindow = WebDriverRunner.getWebDriver().getWindowHandle();

        windowsOperationPage.newTable().click();

        // switch to new window
        for (String windowHandle : WebDriverRunner.getWebDriver().getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                WebDriverRunner.getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }

        assertEquals(url(), "https://automatenow.io/");

        // switch back to main window
        WebDriverRunner.getWebDriver().switchTo().window(mainWindow);

        assertEquals(url(), "https://practice-automation.com/window-operations/");

        windowsOperationPage.replaceWin().click();

        assertEquals(url(), "https://automatenow.io/");

        Selenide.back();

        assertEquals(url(), "https://practice-automation.com/window-operations/");

        windowsOperationPage.newWin().click();

        // switch to new window
        for (String windowHandle : WebDriverRunner.getWebDriver().getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                WebDriverRunner.getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }

        assertEquals(url(), "https://automatenow.io/");

        WebDriverRunner.getWebDriver().switchTo().window(mainWindow);

        assertEquals(url(), "https://practice-automation.com/window-operations/");
    }
}
