package org.week3;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TablesTest extends BaseTest {
    TablesPage tablesPage = new TablesPage();

    @Test
    public void tablesTest() {

        assertEquals(WebDriverRunner.url(), "https://practice-automation.com/");
        tablesPage.tablesBtn().click();
        assertTrue(WebDriverRunner.url().contains("tables/"));

        // Simple table
        tablesPage.figures();

        // Sortable table
        tablesPage.pagination().selectOption("50");
        assertEquals($("#tablepress-1_info").text(), "Showing 1 to 25 of 25 entries");
        tablesPage.searchTable("Egypt");
        assertEquals($("#tablepress-1_info").text(), "Showing 1 to 1 of 1 entries (filtered from 25 total entries)");
        tablesPage.trow();
    }
}
