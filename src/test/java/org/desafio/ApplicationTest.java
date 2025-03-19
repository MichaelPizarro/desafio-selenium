package org.desafio;

import org.desafio.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckOutPage checkOutPage;
    private OverviewPage overviewPage;


    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        overviewPage = new OverviewPage(driver);
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();
    }

    @Test
    void usernamePasswordEmpty() {
        Assertions.assertEquals("Epic sadface: Username is required",loginPage.usernamePasswordEmpty());
    }

    @Test
    void userValidPasswordNotValid(){
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.userValidPasswordNotValid());
    }

    @Test
    void signInValid(){
        loginPage.userValidPasswordValid();
        Assertions.assertEquals("Products",inventoryPage.signInValid());
    }

    @ParameterizedTest
    @CsvSource({"standard_user","locked_out_user","problem_user","performance_glitch_user"})
    void firstUser(String user){
        loginPage.firstUser(user);
        Assertions.assertEquals("Products",inventoryPage.signInValid());
        Assertions.assertEquals("bot_column",inventoryPage.menuLogout());

    }

    @Test
    void addFirstProduct(){
        loginPage.buyTest();
        Assertions.assertEquals("Products",inventoryPage.signInValid());
        Assertions.assertEquals("btn_secondary btn_inventory",inventoryPage.addFirstProduct());

    }

    @Test
    void addTwoProducts(){
        loginPage.buyTest();
        inventoryPage.addTwoProducts();
    }

    @Test
    void deleteProduct(){
        loginPage.buyTest();
        inventoryPage.addTwoProducts();
        Assertions.assertEquals(1,cartPage.deleteProduct());
    }

    @Test
    void doThePurchase(){
        loginPage.buyTest();
        inventoryPage.addTwoProducts();
        cartPage.doThePurchase();
        checkOutPage.doTheCheckout();
        overviewPage.finishPurchase();
        inventoryPage.menuLogout();
    }

    @AfterEach
    void tearDown(){
        driver.quit();

    }
}
