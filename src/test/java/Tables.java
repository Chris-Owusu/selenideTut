import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.CollectionElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Scanner;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Tables {
    @Test
    public void tables() {
        open("https://practice-automation.com/");
        assertEquals(WebDriverRunner.url(), "https://practice-automation.com/");

        $(By.xpath("//a[normalize-space()='Tables']")).click();
        assertTrue(WebDriverRunner.url().contains("tables/"));

        // Simple table
        ElementsCollection figures = $$("figure[class='wp-block-table'] table tr");

        for (SelenideElement figure : figures) {
            ElementsCollection cells = figure.$$(By.cssSelector("td"));

            for (SelenideElement cell : cells) {
                System.out.println("This is the table data: " + cell.text() + " ");
            }
            System.out.println("------------------------------------");
        }


        // Sortable table
        $("select[name='tablepress-1_length']").selectOption("50");
        assertEquals($("#tablepress-1_info").text(), "Showing 1 to 25 of 25 entries");

        Scanner scanner = new Scanner(System.in);

        // Perform search
//        System.out.println("Please enter the search parameter: ");
//        String searchParam = scanner.next();
        $(By.xpath("//input[@aria-controls=\"tablepress-1\"]")).val("Egypt");
        assertEquals($("#tablepress-1_info").text(), "Showing 1 to 1 of 1 entries (filtered from 25 total entries)");

        ElementsCollection trows = $$("#tablepress-1 tbody tr");

        for (SelenideElement trow : trows) {
            ElementsCollection tdatas = trow.$$(By.cssSelector("td"));

            for (SelenideElement tdata : tdatas) {
                System.out.println("This is the data for the second table: " + tdata.text());
            }
            System.out.println("---------------------------------");
        }
    }
}
