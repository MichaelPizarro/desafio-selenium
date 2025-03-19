package org.desafio.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends Driver{
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(css = "button.btn_secondary.cart_button")
    private WebElement cartButton;

    @FindBy(css = "button.btn_secondary.cart_button")
    private List<WebElement> cartButtonList;

    @FindBy(css = "a.btn_action")
    private WebElement checkButton;

    public int deleteProduct(){
        List<WebElement> cartButtonListVisible = getWait().until(ExpectedConditions.visibilityOfAllElements(cartButtonList));
        getWait().until(ExpectedConditions.elementToBeClickable(cartButtonListVisible.get(0))).click();

        return cartButtonListVisible.size();
    }

    public CheckOutPage doThePurchase(){
        getWait().until(ExpectedConditions.elementToBeClickable(checkButton)).click();
        return new CheckOutPage(getDriver());

    }
}
