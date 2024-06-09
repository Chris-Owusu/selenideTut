package org.week3;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TablesPage {

    public SelenideElement tablesBtn() {
        return $(By.xpath("//a[normalize-space()='Tables']"));
    }

    // Simple table
    public ElementsCollection figures() {
        ElementsCollection figures = $$("figure[class='wp-block-table'] table tr");

        for (SelenideElement figure : figures) {
            ElementsCollection cells = figure.$$(By.cssSelector("td"));

            for (SelenideElement cell : cells) {
                System.out.println("This is the table data: " + cell.text() + " ");
            }
            System.out.println("------------------------------------");
        }
        return figures;
    }

    public SelenideElement pagination() {
        return $("select[name='tablepress-1_length']");
    }

    public SelenideElement searchTable(String search) {
        return $(By.xpath("//input[@aria-controls=\"tablepress-1\"]")).val(search);
    }

    public ElementsCollection trow() {
        ElementsCollection trows = $$("#tablepress-1 tbody tr");

        for (SelenideElement trow : trows) {
            ElementsCollection tdatas = trow.$$(By.cssSelector("td"));

            for (SelenideElement tdata : tdatas) {
                System.out.println("This is the data for the second table: " + tdata.text());
            }
            System.out.println("---------------------------------");
        }
        return trows;
    }
}
