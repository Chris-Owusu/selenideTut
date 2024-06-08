package org.week3;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUploadTest extends BaseTest {

    FileUploadPage fileUploadPage = new FileUploadPage();

    @Test
    public void fileUploadTest() {
        assertEquals(WebDriverRunner.url(), "https://practice-automation.com/");
        fileUploadPage.fileUploadBtn().click();
        assertTrue(WebDriverRunner.url().contains("file-upload/"));
        fileUploadPage.uploadFile("C://Users//ChristopherOwusuAhen//Downloads//meme18.png");
        fileUploadPage.uploadBtn().click();
        fileUploadPage.uploadSuccessMss();
    }
}
