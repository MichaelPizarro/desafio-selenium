package org.desafio.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewPage extends Driver{
    public OverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(css = "a.btn_action ")
    private WebElement finishButton;

    public FinishPage finishPurchase(){
        getWait().until(ExpectedConditions.elementToBeClickable(finishButton)).click();
        return new FinishPage(getDriver());
    }

}
