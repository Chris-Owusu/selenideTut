import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Modals {
    @Test
    public void modals() {

        open("https://practice-automation.com/");
        assertEquals(WebDriverRunner.url(), "https://practice-automation.com/");

        $(By.xpath("//a[normalize-space()='Modals']")).click();
        assertTrue(WebDriverRunner.url().contains("modals/"));
    }
}
