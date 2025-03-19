package org.desafio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class InventoryPage extends Driver{
    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(className = "product_label")
    private WebElement productLabel;

    @FindBy(css = "div.bm-burger-button")
    private WebElement burgerButton;

    @FindBy(linkText = "Logout")
    private WebElement logoutButton;

    @FindBy(css = "img.bot_column")
    private WebElement img;

    @FindBy(css = "button.btn_primary.btn_inventory")
    private WebElement addButton;

    @FindBy(css = "button.btn_secondary.btn_inventory")
    private WebElement addButtonSecondary;

    @FindBy(css = "button.btn_primary.btn_inventory")
    private List<WebElement> addButtonList;

    @FindBy(css = "a.shopping_cart_link ")
    private WebElement cart;

    public String signInValid(){
        WebElement label = getWait().until(ExpectedConditions.visibilityOf(productLabel));
        String labelText = label.getText();
        return  labelText;
    }

    public String menuLogout(){
        getWait().until(ExpectedConditions.elementToBeClickable(burgerButton)).click();
        getWait().until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        WebElement imgVisible = getWait().until(ExpectedConditions.visibilityOf(img));

        return imgVisible.getDomAttribute("class");
    }

    public String addFirstProduct(){
        WebElement addButtonVisible = getWait().until(ExpectedConditions.elementToBeClickable(addButton));
        addButtonVisible.click();
        WebElement addButtonSecondaryVisible = getWait().until(ExpectedConditions.elementToBeClickable(addButtonSecondary));

        return addButtonSecondaryVisible.getDomAttribute("class");
    }

    public CartPage addTwoProducts(){
        List<WebElement> addButtonListVisible = getWait().until(ExpectedConditions.visibilityOfAllElements(addButtonList));

        getWait().until(ExpectedConditions.elementToBeClickable(addButtonListVisible.get(0))).click();
        getWait().until(ExpectedConditions.elementToBeClickable(addButtonListVisible.get(1))).click();

        getWait().until(ExpectedConditions.elementToBeClickable(cart)).click();

        return new CartPage(getDriver());
    }
}
