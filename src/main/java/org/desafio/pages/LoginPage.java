package org.desafio.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends Driver{
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "login_credentials")
    private WebElement credentialUser;

    @FindBy(id = "login_password")
    private WebElement credentialPassword;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    public String usernamePasswordEmpty(){
        getWait().until(ExpectedConditions.visibilityOf(userName)).sendKeys("");
        getWait().until(ExpectedConditions.visibilityOf(password)).sendKeys("");
        getWait().until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        WebElement errorMessageVisible = getWait().until(ExpectedConditions.visibilityOf(errorMessage));
        String error = errorMessageVisible.getText();

        return error;
    }

    public String userValidPasswordNotValid(){
        getWait().until(ExpectedConditions.visibilityOf(userName)).sendKeys("standard_user");
        getWait().until(ExpectedConditions.visibilityOf(password)).sendKeys("123");
        getWait().until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        WebElement errorMessageVisible = getWait().until(ExpectedConditions.visibilityOf(errorMessage));
        String error = errorMessageVisible.getText();

        return error;
    }

    public InventoryPage userValidPasswordValid(){
        getWait().until(ExpectedConditions.visibilityOf(userName)).sendKeys("problem_user");
        getWait().until(ExpectedConditions.visibilityOf(password)).sendKeys("secret_sauce");
        getWait().until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        return new InventoryPage(getDriver());
    }

    public InventoryPage firstUser(String user){
        getWait().until(ExpectedConditions.visibilityOf(userName)).sendKeys(user);
        getWait().until(ExpectedConditions.visibilityOf(password)).sendKeys("secret_sauce");
        getWait().until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        return new InventoryPage(getDriver());
    }

    public InventoryPage buyTest(){
        getWait().until(ExpectedConditions.visibilityOf(userName)).sendKeys("standard_user");
        getWait().until(ExpectedConditions.visibilityOf(password)).sendKeys("secret_sauce");
        getWait().until(ExpectedConditions.elementToBeClickable(loginButton)).click();

        return new InventoryPage(getDriver());
    }
}
