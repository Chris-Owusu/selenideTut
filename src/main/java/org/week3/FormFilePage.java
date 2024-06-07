package org.week3;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;

public class FormFilePage {

    public SelenideElement formFillBtn() {
        return $(By.xpath("//a[normalize-space()='Form Fields']"));
    }

    public SelenideElement formFillNameField(String name) {
        return $("#name").val(name);
    }

    public SelenideElement drinkOne() {
        return $("label[for='drink1']");
    }

    public SelenideElement drinkFour() {
        return $("label[for='drink4']");
    }

    public SelenideElement siblings() {
        return $("#siblings");
    }

    public SelenideElement formFillEmailField(String email) {
        return $("#email").val(email);
    }

    public SelenideElement formFillMssField(String mss) {
        return $("#message").val(mss);
    }

    public SelenideElement formFillSubmitBtn() {
        return $("#submit-btn");
    }
}
