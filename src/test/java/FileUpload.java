import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUpload {
    @Test
    public void fileUpload() {
        open("https://practice-automation.com/");
        assertEquals(WebDriverRunner.url(), "https://practice-automation.com/");

        $(By.xpath("//a[normalize-space()='File Upload']")).click();
        assertTrue(WebDriverRunner.url().contains("file-upload/"));

        //Upload file
        $("#file-upload").sendKeys("C://Users//ChristopherOwusuAhen//Downloads//meme18.png");

        $("#upload-btn").click();

        $(".wpcf7-response-output").shouldBe(visible).shouldHave(text("Thank you for your message. It has been sent."));
    }
}
