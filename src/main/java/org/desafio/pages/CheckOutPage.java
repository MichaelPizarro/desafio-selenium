package org.desafio.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends Driver{
    public CheckOutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id = "first-name")
    private WebElement name;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(css = "input.btn_primary ")
    private WebElement continueButton;

    public OverviewPage doTheCheckout(){
        getWait().until(ExpectedConditions.visibilityOf(name)).sendKeys("Michael");
        getWait().until(ExpectedConditions.visibilityOf(lastName)).sendKeys("Pizarro");
        getWait().until(ExpectedConditions.visibilityOf(postalCode)).sendKeys("23400");

        getWait().until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        return new OverviewPage(getDriver());

    }
}
