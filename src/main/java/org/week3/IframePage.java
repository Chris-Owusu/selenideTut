package org.week3;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class IframePage {

    public SelenideElement iframesBtn() {
        return $(By.xpath("//a[normalize-space()='Iframes']"));
    }

    SelenideElement firstFrame = $("#frame2");
    SelenideElement secondFrame = $("#frame1");

    // First frame
    public SelenideElement switchToFirstFrame() {
        return (SelenideElement) switchTo().frame(firstFrame);
    }

    public SelenideElement loginBtnVisible() {
        return $(By.xpath("//button[text()=\"Login\"]"));
    }

    public SelenideElement closePopUp() {
        return $(By.xpath("//button[aria-label=\"Close Message\"]"));
    }

    public SelenideElement clickSearchBtn() {
        return $(By.xpath("//a[@href=\"/search\"]"));
    }

    public SelenideElement makeSearch(String search) {
        return $(By.xpath("//input[@placeholder=\"Search\"]")).val(search);
    }

    public SelenideElement assertSearchResult() {
        return $(By.xpath("//span[text()=\"Passport to Space\"]"));
    }

    // Switch back to main content page
    public SelenideElement switchToDefaultContent() {
        return (SelenideElement) switchTo().defaultContent();
    }

    // Second frame
    public SelenideElement switchToSecondFrame() {
        return (SelenideElement) switchTo().frame(secondFrame);
    }

    public SelenideElement clickSponsorBtn() {
        return $(By.xpath("//a[@href=\"/sponsor\"]"));
    }

    public SelenideElement assertSponsorText() {
        return $(By.xpath("//h1[text()=\"Sponsors\"]"))
                .shouldBe(visible)
                .shouldHave(exactText("Sponsors"));
    }

}
