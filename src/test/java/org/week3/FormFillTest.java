package org.week3;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FormFillTest extends BaseTest {

    FormFilePage formFilePage = new FormFilePage();
    @Test
    public void formFillTest() {
        formFilePage.formFillBtn().click();
        assertTrue(WebDriverRunner.url().contains("form-fields/"));
        formFilePage.formFillNameField("Vick");
        formFilePage.drinkOne().click();
        formFilePage.drinkFour().click();
        formFilePage.siblings().selectOption("Yes");
        formFilePage.formFillEmailField("vick@aol.com");
        formFilePage.formFillMssField("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,");
        formFilePage.formFillSubmitBtn().click();
    }
}
