package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    //it is an abstract class because it is not a concrete class, just base for other classes
//expilict wait, will be used in every page calsses
    //since varianle is protected, it will not be visible to test classes
    protected static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 400);

    @FindBy(linkText = "View all orders")
    private WebElement viewAllOrders;

    @FindBy(linkText = "View all products")
    private WebElement viewAllProducts;

    @FindBy(linkText = "Order")
    private WebElement order;

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void clickonViewAllOrders(){
        wait.until(ExpectedConditions.elementToBeClickable(viewAllOrders));
        viewAllOrders.click();
    }

    public void clickonViewAllProducts(){
       wait.until(ExpectedConditions.elementToBeClickable(viewAllProducts));
        viewAllProducts.click();
    }


    public void clickonOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(order)).click();
    }



}
