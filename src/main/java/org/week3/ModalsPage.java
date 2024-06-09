package org.week3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ModalsPage {

    public SelenideElement modalsBtn() {
        return $(By.xpath("//a[normalize-space()='Modals']"));
    }

    // Simple Modal
    public SelenideElement simpleModalBtn() {
        return $("#simpleModal");
    }

    public SelenideElement assertSimpleModal() {
        return $("#pum_popup_title_1318")
                .shouldHave(text("Simple Modal"));
    }

    public SelenideElement assertSimpleModalText() {
        return $("div[id='popmake-1318'] p")
                .shouldHave(text("Hi, I’m a simple modal."));
    }

    public SelenideElement assertSimpleModalCloseBtn() {
        return $(By.xpath("//div[@id='popmake-1318']//button[@aria-label='Close'][normalize-space()='×']"));
    }

    // Form Modal
    public SelenideElement formModalBtn() {
        return $("#formModal");
    }

    public SelenideElement assertFormModal() {
        return $("#pum_popup_title_674")
                .shouldHave(exactText("Modal Containing A Form"));
    }

    public SelenideElement formModalNameField(String name) {
        return $("#g1051-name").val(name);
    }

    public SelenideElement formModalEmailField(String email) {
        return $("#g1051-email").val(email);
    }

    public SelenideElement formModalMssField(String mss) {
        return $("#contact-form-comment-g1051-message").val(mss);
    }

    public SelenideElement formModalNameFieldSubmitBtn() {
        return $("button[class='pushbutton-wide']");
    }

}
