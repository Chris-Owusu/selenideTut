import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;

public class FileForm {


    @Test
    public void fillForm() {
        Configuration.browserSize = "1443x1080";
        open("https://practice-automation.com/");


        assertTrue(WebDriverRunner.url().contains("practice-automation.com/"));

        $(By.xpath("//a[normalize-space()='Form Fields']")).click();
//        $(title()).shouldHave(exactText("Form Fields | Practice Automation"));
        assertTrue(WebDriverRunner.url().contains("form-fields/"));

        $("#name").val("Vick");
        $("label[for='drink1']").click();
        $("label[for='drink4']").click();
        $("#name").val("Vick");
        $("label[for='color2']").click();

        $("#siblings").selectOption("Yes");
        $("#email").val("vicky@gmail.com");
        $("#message").val("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                "molestiae");
        $("#submit-btn").click();
    }
}
