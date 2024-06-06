import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Iframes {


    @Test
    public void iframes() {
        open("https://practice-automation.com/");
        assertEquals(WebDriverRunner.url(), "https://practice-automation.com/");

        $(By.xpath("//a[normalize-space()='Iframes']")).click();
        assertTrue(WebDriverRunner.url().contains("iframes/"));

        SelenideElement firstFrame = $("#frame2");
        SelenideElement secondFrame = $("#frame1");

        // First frame
        switchTo().frame(firstFrame);
        $(By.xpath("//button[text()=\"Login\"]")).shouldBe(visible);
        $(By.xpath("//button[aria-label=\"Close Message\"]")).click();
        $(By.xpath("//a[@href=\"/search\"]")).click();
        $(By.xpath("//input[@placeholder=\"Search\"]")).val("Space");
        $(By.xpath("//span[text()=\"Passport to Space\"]")).should(exist);

        // Switch back to main content page
        switchTo().defaultContent();

        // Second frame
        switchTo().frame(secondFrame);
        $(By.xpath("//a[@href=\"/sponsor\"]")).click();
        $(By.xpath("//h1[text()=\"Sponsors\"]")).shouldBe(visible).shouldHave(exactText("Sponsors"));

        // Switch back to main content page
        switchTo().defaultContent();
    }
}
