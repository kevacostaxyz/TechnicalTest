package tests1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;



public class TestEbay {
    WebDriver driver;

    @BeforeTest
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ebay.com");
    }

    @Test
    public void testSearch() {
        EbayTest ebayTest = new EbayTest(driver);
        ebayTest.searchForItem("Electric Guitar");
        ebayTest.openFirstResult();
        String price = ebayTest.getItemPrice();
        Assert.assertTrue(price.contains("$"));
        System.out.println("Precio : " + price);
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}

