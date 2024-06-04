
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Popups {
    @Test
    public void popups() throws InterruptedException {
        open("https://practice-automation.com/");
        assertEquals(WebDriverRunner.url(), "https://practice-automation.com/");

        $(By.xpath("//a[normalize-space()='Popups']")).click();
        assertTrue(WebDriverRunner.url().contains("popups/"));

        // check if its using chrome driver
        assertTrue(WebDriverRunner.isChrome());


        // Alert
        $(byText("Alert Popup")).click();
        Alert alert = switchTo().alert();
        alert.accept();

        Thread.sleep(5000);

        // Confirm Popup
        $("button[id='alert'] b").click();
        alert.accept();
//        $(By.id("confirmResult")).shouldHave(text("OK it is!"));

        Thread.sleep(5000);

        // Prompt Popup
        $("#prompt").click();
        alert.sendKeys("good");
        alert.accept();
        $(By.id("promptResult")).shouldHave(text("Nice to meet you, good!"));
    }
}
