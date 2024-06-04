import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class New {
    @Test
    public void testName() throws InterruptedException {

        open("https://practice-automation.com/slider/");

        SelenideElement slider = $("#slideMe");
        executeJavaScript("arguments[0].value = arguments[1];", slider, "0");

        String val = $("#slideMe").getAttribute("value");

        System.out.println(val);
//        Thread.sleep(50);
    }
}
