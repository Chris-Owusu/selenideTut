package org.week3;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CalendarTest extends BaseTest {

    CalendarPage calendarPage = new CalendarPage();

    @Test
    public void calendarTest() {
        calendarPage.calendarBtn().click();
        assertTrue(WebDriverRunner.url().contains("calendars/"));
        calendarPage.headlineAssertion();
        calendarPage.enterDate("2024-06-06");
        calendarPage.calendarSubmitBtn().click();
        calendarPage.calendarSuccessMss();
        calendarPage.assertDateIsCorrect();
        calendarPage.goBack();
        assertTrue(WebDriverRunner.url().contains("https://practice-automation.com/calendars/"));
    }
}
