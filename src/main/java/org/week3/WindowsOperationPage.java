package org.week3;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WindowsOperationPage {

    public SelenideElement winOpsBtn() {
        return $(By.xpath("//a[normalize-space()='Window Operations']"));
    }

    // New table
    public SelenideElement newTable() {
        return $("button[onclick='newTab()']");
    }

    // Replace Windows
    public SelenideElement replaceWin() {
        return $("button[onclick='newWindowSelf()']");
    }

    // New Windows
    public SelenideElement newWin() {
        return $("button[onclick='newWindow()']");
    }
}
