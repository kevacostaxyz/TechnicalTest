package tests1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;



public class TestGmailLogin {
    WebDriver driver;

    @BeforeTest

    public void setup() {
        // Initialize the WebDriver object
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://mail.google.com");
    }

    @Test
    public void testLogin() throws InterruptedException {
        // Create an object of GmailTest class and pass the WebDriver object to its constructor
        GmailTest gmailTest = new GmailTest(driver);

        // Call the login method from GmailTest class
        gmailTest.login("techtestlamansys@gmail.com", "tech1334",gmailTest);

        // Verify if the user is logged in
        Assert.assertTrue(gmailTest.isUserLoggedIn());
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
