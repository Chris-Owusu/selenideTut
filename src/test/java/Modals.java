import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
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

        SelenideElement simpleModal = $("#simpleModal");
        SelenideElement formModal = $("#formModal");

        // Simple modal
        simpleModal.click();
        $("#pum_popup_title_1318").shouldHave(text("Simple Modal"));
        $("div[id='popmake-1318'] p").shouldHave(text("Hi, I’m a simple modal."));
        $(By.xpath("//div[@id='popmake-1318']//button[@aria-label='Close'][normalize-space()='×']")).click();

        //Form Modal
        formModal.click();
        $("#pum_popup_title_674").shouldHave(exactText("Modal Containing A Form"));
        $("#g1051-name").val("Mark");
        $("#g1051-email").val("mark@aol.com");
        $("#contact-form-comment-g1051-message").val("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                "molestiae");
        $("button[class='pushbutton-wide']").click();
    }
}
