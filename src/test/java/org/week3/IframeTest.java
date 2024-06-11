package org.week3;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IframeTest extends BaseTest {

    IframePage iframePage = new IframePage();


    @Test
    public void iframeTest() {
        iframePage.iframesBtn().click();
        assertTrue(WebDriverRunner.url().contains("iframes/"));
        iframePage.switchToFirstFrame();
        iframePage.loginBtnVisible();
        iframePage.closePopUp().click();
        iframePage.clickSearchBtn().click();
        iframePage.makeSearch("Space");
        iframePage.assertSearchResult();
        iframePage.switchToDefaultContent();
        iframePage.switchToSecondFrame();
        iframePage.clickDocumentationBtn().click();
        iframePage.assertDocsText();
        iframePage.switchToDefaultContent();
        iframePage.assertAboutLink();
    }
}
