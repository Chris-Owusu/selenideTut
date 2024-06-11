package org.week3;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ModalsTest extends BaseTest {

    ModalsPage modalsPage = new ModalsPage();

    @BeforeMethod
    public void modalPage() {
        modalsPage.modalsBtn().click();
        assertTrue(WebDriverRunner.url().contains("modals/"));
    }

    @Test(priority = 1)
    public void simpleModalsTest() {
        modalsPage.simpleModalBtn().click();
        modalsPage.assertSimpleModal();
        modalsPage.assertSimpleModalText();
        modalsPage.assertSimpleModalCloseBtn().click();
    }

    @Test(priority = 2)
    public void formModalTest() {
        modalsPage.formModalBtn().click();
        modalsPage.assertFormModal();
        modalsPage.formModalNameField("Mark");
        modalsPage.formModalEmailField("mark.aol.com");
        modalsPage.formModalMssField("Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia");
        modalsPage.formModalNameFieldSubmitBtn().click();
    }
}
