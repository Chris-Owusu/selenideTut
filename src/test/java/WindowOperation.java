import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WindowOperation {
    @Test
    public void windowsOperation() {
        open("https://practice-automation.com/");
        assertEquals(url(), "https://practice-automation.com/");

        $(By.xpath("//a[normalize-space()='Window Operations']")).click();
        assertTrue(url().contains("window-operations/"));

        // Get main window
        String mainWindow = WebDriverRunner.getWebDriver().getWindowHandle();

        // New Table
        $("button[onclick='newTab()']").click();

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


        // Replace Windows
        $("button[onclick='newWindowSelf()']").click();
        assertEquals(url(), "https://automatenow.io/");

        Selenide.back();

        assertEquals(url(), "https://practice-automation.com/window-operations/");


        // New Window
        $("button[onclick='newWindow()']").click();

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
