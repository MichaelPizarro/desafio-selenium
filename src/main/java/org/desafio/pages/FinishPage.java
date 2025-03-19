package org.desafio.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FinishPage extends Driver{
    public FinishPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }


}
