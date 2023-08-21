package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    // Locator @FindBy
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement txtDashboard;
    //div[@class='app_logo']

    // Custom Method
    public void login(String standardUser, String secretSauce){
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        btnLogin.click();
    }

    public String getTxtDashboard() {
        return txtDashboard.getText();
    }

    // Method return

}
