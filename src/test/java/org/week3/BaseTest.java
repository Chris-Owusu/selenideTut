package org.week3;


import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        // Configure browser settings
        Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        // Open the base URL before each test
        open("https://practice-automation.com/");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
}

