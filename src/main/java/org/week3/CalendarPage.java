package org.week3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CalendarPage {

    public SelenideElement calendarBtn() {
        return $(By.xpath("//a[normalize-space()='Calendars']"));
    }

    public SelenideElement headlineAssertion() {
        return $("h1[itemprop='headline']").shouldHave(text("Calendars"));
    }

    public SelenideElement enterDate(String date) {
        return $("#g1065-selectorenteradate").val(date);
    }

    public SelenideElement calendarSubmitBtn() {
        return $("div[class='entry-content'] button[type='submit']");
    }

    public SelenideElement calendarSuccessMss() {
        return $("#contact-form-success-header")
                .shouldBe(visible)
                .shouldHave(text("Your message has been sent"));
    }

    public SelenideElement assertDateIsCorrect() {
        return $(".field-value").shouldHave(text("2024-06-06"));
    }

    public SelenideElement goBack() {
        return $(By.xpath("//a[normalize-space()='Go back']"));
    }
}
