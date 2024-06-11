package org.week3;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IframeTest extends BaseTest {

    IframePage iframePage = new IframePage();

    @BeforeMethod
    public void iframePage() {
        iframePage.iframesBtn().click();
        assertTrue(WebDriverRunner.url().contains("iframes/"));
    }

    @Test(priority = 1)
    public void iframeTest() {
        iframePage.switchToFirstFrame();
        iframePage.loginBtnVisible();
        iframePage.closePopUp().click();
        iframePage.clickSearchBtn().click();
        iframePage.makeSearch("Space");
        iframePage.assertSearchResult();
        iframePage.switchToDefaultContent();
    }

    @Test(priority = 2)
    public void secondFrame() {
        iframePage.switchToSecondFrame();
        iframePage.clickDocumentationBtn().click();
        iframePage.assertDocsText();
        iframePage.switchToDefaultContent();
        iframePage.assertAboutLink();
    }
}
