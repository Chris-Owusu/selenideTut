package org.week3;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CalendarTest extends BaseTest {

    CalendarPage calendarPage = new CalendarPage();

    @Test
    @Parameters("date")
    public void calendarTest(String date) {
        calendarPage.calendarBtn().click();
        assertTrue(WebDriverRunner.url().contains("calendars/"));
        calendarPage.headlineAssertion();
        calendarPage.enterDate(date);
        calendarPage.calendarSubmitBtn().click();
        calendarPage.calendarSuccessMss();
        calendarPage.assertDateIsCorrect();
        calendarPage.goBack();
        assertTrue(WebDriverRunner.url().contains("https://practice-automation.com/calendars/"));
    }
}
