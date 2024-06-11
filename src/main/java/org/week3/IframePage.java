package org.week3;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class IframePage {

    public SelenideElement iframesBtn() {
        return $(By.xpath("//a[normalize-space()='Iframes']"));
    }

    SelenideElement firstFrame = $("#frame2");
    SelenideElement secondFrame = $("#frame1");

    // First frame
    public void switchToFirstFrame() {
        switchTo().frame(firstFrame);
    }

    public SelenideElement loginBtnVisible() {
        return $(By.xpath("//button[text()=\"Login\"]"));
    }

    public SelenideElement closePopUp() {
        return $(By.xpath("//button[text()=\"OK\"]"));
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
    public void switchToDefaultContent() {
        switchTo().defaultContent();
    }

    // Second frame
    public void switchToSecondFrame() {
        switchTo().frame(secondFrame);
    }

    public SelenideElement clickDocumentationBtn() {
        return $(By.xpath("//span[text()=\"Documentation\"]"));
    }

    public SelenideElement assertDocsText() {
        return $(".td-content h1")
                .shouldBe(visible)
                .shouldHave(text("The Selenium Browser Automation Project"));
    }

    public SelenideElement assertAboutLink() {
        return $(By.xpath("//a[text()='About']"))
                .shouldBe(visible)
                .shouldHave(text("About"));
    }

}
