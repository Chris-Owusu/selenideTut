package org.week3;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WindowsOperationTest extends BaseTest {
    WindowsOperationPage windowsOperationPage = new WindowsOperationPage();

    @BeforeMethod
    public void winOpsPage() {
        windowsOperationPage.winOpsBtn().click();
        assertTrue(url().contains("window-operations/"));
    }

    @Test(priority = 1)
    public void windowsOperationTest() {
        // Get main window
        String mainWindow = WebDriverRunner.getWebDriver().getWindowHandle();

        // new tab
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
    }

    // switch to replace window
    @Test(priority = 2)
    public void replaceWin() {
        windowsOperationPage.replaceWin().click();

        assertEquals(url(), "https://automatenow.io/");

        Selenide.back();

        assertEquals(url(), "https://practice-automation.com/window-operations/");
    }

    // new window
    @Test(priority = 3)
    public void newWin() {
        // Get main window
        String mainWindow = WebDriverRunner.getWebDriver().getWindowHandle();


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
