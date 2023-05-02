package tests1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class EbayTest {
    // Locators
    @FindBy(id = "gh-ac")
    private WebElement searchField;
    @FindBy(id = "gh-btn")
    private WebElement searchButton;
    @FindBy(css = "a.s-item__link")
    private WebElement firstResult;
    @FindBy(css = ".s-item__price")
    private WebElement priceLabel;

    private final WebDriver driver;

    public EbayTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForItem(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchButton.click();
    }

    public void openFirstResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.elementToBeClickable(firstResult));
        firstResult.click();
    }

    public String getItemPrice() {
        return priceLabel.getText();
    }
}









