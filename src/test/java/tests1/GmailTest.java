package tests1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class GmailTest implements WebDriver {

    @FindBy(id = "identifierId")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement nextButton;

   @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwordInput;


    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/span")
    private WebElement nextButtonpwd;
    @FindBy(xpath = "//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a")
    private WebElement userProfileIcon;

    public GmailTest(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void login(String email, String password, GmailTest gmailTest) throws InterruptedException {
        emailInput.sendKeys(email);
        nextButton.click();

        WebDriverWait wait = new WebDriverWait(gmailTest, Duration.ofMillis(12000));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
       passwordInput.sendKeys(password);
       wait.until(ExpectedConditions.elementToBeClickable(nextButtonpwd));
       nextButtonpwd.click();
        wait.until(ExpectedConditions.visibilityOf(userProfileIcon));
    }

    @Override
    public void get(String url) {

    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return null;
    }

     public boolean isUserLoggedIn() {
        ;
        return userProfileIcon.isDisplayed();
    }
}
