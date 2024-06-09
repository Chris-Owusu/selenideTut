package org.week3;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SliderPage {

    SelenideElement slider = $("#slideMe");

    public SelenideElement sliderBtn() {
        return $(By.xpath("//a[normalize-space()='Sliders']"));
    }
    public SelenideElement moveSlider(int sliderValue) {
        return executeJavaScript("arguments[0].value = arguments[1];", slider, sliderValue);
    }
}
