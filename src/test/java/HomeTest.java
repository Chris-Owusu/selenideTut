import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;

public class HomeTest {

    @Test
    public void sauceDemoWithSelenide() {

//        Configuration.browser = "firefox";
        Configuration.browserSize = "1443x984";

        //SetUp
        System.out.println("Text is starting....");

        // Visit Sauce demo page
        open("https://saucedemo.com/");
        assertEquals(WebDriverRunner.url(), "https://www.saucedemo.com/");

        // Login
        $(By.cssSelector("#user-name")).setValue("standard_user");
        $(By.id("password")).setValue("secret_sauce");
        $(By.xpath("//input[@id='login-button']")).click();

        assertEquals(WebDriverRunner.url().contains("inventory.html"), true);
        assertEquals(title(), "Swag Labs");

        // Select product
        $(By.id("add-to-cart-sauce-labs-backpack")).click();
        $(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        $(By.id("add-to-cart-sauce-labs-onesie")).click();

        // Shopping Cart Page
        $(By.cssSelector(".shopping_cart_link")).click();
        $(By.id("remove-sauce-labs-backpack")).click();
        $(By.id("checkout")).click();
        $(By.id("first-name")).setValue("Mark");
        $(By.id("last-name")).setValue("Bingo");
        $(By.id("postal-code")).setValue("123212");
        $(By.id("continue")).click();

        assertTrue(WebDriverRunner.url().contains("checkout-step-two.html"));

        ElementsCollection prices =  $$(By.cssSelector(".inventory_item_price"));

        double priceVal = 0.0;
        double sum = 0.0;
        for (SelenideElement price : prices) {
            String priceText = price.text().replace("$", "");
            priceVal = Double.parseDouble(priceText);
            System.out.println("Price: " + priceText);
            sum = sum + priceVal;

        }
       System.out.println("The sum is: " + sum);

        // Check if price matches
        double tax = 1.92;
        SelenideElement totalPrice = $(By.cssSelector(".summary_total_label"));
        double totalIntPrice = Double.parseDouble(totalPrice.text().replace("Total: $", ""));
        System.out.println("Total int price: " + totalIntPrice);

        assertEquals(sum + tax, totalIntPrice);

        $(By.id("finish")).click();

        // Post checkout assertions
        $(By.className("title")).shouldHave(text("Checkout: Complete!"));
        $(By.className("complete-header")).shouldHave(exactText("Thank you for your order!"));
        $(By.id("back-to-products")).shouldBe(visible);

        // TearDown
        System.out.println("Text is over.....");

    }

}
