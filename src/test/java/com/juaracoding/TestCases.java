package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class TestCases {
    private final WebDriver driver = new ChromeDriver();
    private LoginPage loginPage;
    private CartPage cartPage;

    @BeforeClass
    public void setUp() {

        String path = "C:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);

        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void testValidLogin() {
        loginPage.login("standard_user", "secret_sauce");
        // Perform assertions for successful login
    }

    @Test
    public void testInvalidLogin() {
        loginPage.login("invalid_user", "invalid_password");
        // Perform assertions for unsuccessful login
    }

    @Test
    public void testAddToCartAndCheckout() {
        loginPage.login("standard_user", "secret_sauce");
        cartPage.addToCart();
        cartPage.goToCart();
        cartPage.checkout();
        // Perform assertions for successful checkout
    }

    @Test
    public void testCheckoutWithoutItems() {
        loginPage.login("standard_user", "secret_sauce");
        cartPage.goToCart();
        cartPage.checkout();
        // Perform assertions for checkout without items
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

