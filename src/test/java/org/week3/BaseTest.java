package org.week3;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        // Configure browser settings
        Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        // Open the base URL before each test
        open("https://practice-automation.com/");
        assertEquals(WebDriverRunner.url(), "https://practice-automation.com/");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    // To run the test on multiple browsers use this:  mvn test -D Selenide.browser={name of browser you want to use} -D test={name of test you want to run}
}

