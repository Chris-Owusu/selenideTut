package org.week3;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PopUpPage {

    public SelenideElement popUpBtn() {
        return $(By.xpath("//a[normalize-space()='Popups']"));
    }

    // Alert
    public SelenideElement alertPopupBtn() {
        return $(byText("Alert Popup"));
    }

    // Confirm Popup
    public SelenideElement confirmPopupBtn() {
        return $("button[id='alert'] b");
    }

    // Prompt Popup
    public SelenideElement promptPopupBtn() {
        return $("#prompt");
    }

    public SelenideElement promptPopupAssertion() {
        return $(By.id("promptResult"))
                .shouldHave(text("Nice to meet you, good!"));
    }

}
