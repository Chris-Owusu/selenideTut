package org.week3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FileUploadPage {

    public SelenideElement fileUploadBtn() {
        return $(By.xpath("//a[normalize-space()='File Upload']"));
    }

    public SelenideElement uploadFile(String filePath) {
        return $("#file-upload").val(filePath);
    }

    public SelenideElement uploadBtn() {
        return $("#upload-btn");
    }

    public SelenideElement uploadSuccessMss() {
        return $(".wpcf7-response-output")
                .shouldBe(visible)
                .shouldHave(text("Thank you for your message. It has been sent."));
    }
}
