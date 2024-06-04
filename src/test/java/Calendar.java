import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;

public class Calendar {


    @Test
    public void calendar() {

        open("https://practice-automation.com/");
        assertEquals(WebDriverRunner.url(), "https://practice-automation.com/");

        $(By.xpath("//a[normalize-space()='Calendars']")).click();
        assertTrue(WebDriverRunner.url().contains("calendars/"));

        $("h1[itemprop='headline']").shouldHave(text("Calendars"));

        $("#g1065-selectorenteradate").val("2024-06-06");
        $("div[class='entry-content'] button[type='submit']").click();

        $("#contact-form-success-header")
                .shouldBe(visible)
                .shouldHave(text("Your message has been sent"));

        $(".field-value").shouldHave(text("2024-06-06"));

        $(By.xpath("//a[normalize-space()='Go back']")).click();
        assertTrue(WebDriverRunner.url().contains("https://practice-automation.com/calendars/"));
    }
}
