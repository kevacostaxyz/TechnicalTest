package tests1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayTest {
    private final WebDriver driver;

    // Locators
    private final By searchField = By.id("gh-ac");
    private final By searchButton = By.id("gh-btn");
    private final By firstResult = By.cssSelector("ul.srp-results li.s-item:first-child");
    private final By priceLabel = By.cssSelector(".s-item__price");

    public EbayTest(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForItem(String searchTerm) {
        driver.findElement(searchField).sendKeys(searchTerm);
        driver.findElement(searchButton).click();
    }

    public void openFirstResult() {
        driver.findElement(firstResult).click();
    }

    public String getItemPrice() {
        return driver.findElement(priceLabel).getText();
    }

}
