package com.weborders.tests;

import com.weborders.pages.LoginPage;
import com.weborders.pages.OrderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends TestBase{

    @Test(description = "create random order")
    public void createOrder() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        OrderPage orderPage = new OrderPage();

        loginPage.login();
        loginPage.clickonOrder();

        orderPage.selectProduct("ScreenSaver");
        orderPage.enterQuantity("12");
        orderPage.enterDiscount("10");
        orderPage.clicktoCalculate();

        Assert.assertEquals(orderPage.getTotal(), "216", "total is not matching!");

        //When user enter addres info

        orderPage.enterCustomerName("Test user");
        orderPage.enterStreet("5th Ave");
        orderPage.entercity("New York");
        orderPage.enterState("New York");
        orderPage.enterZip("10011");

        orderPage.selectCard("Visa");
        orderPage.enterCardNumber("1123121");
        orderPage.expirationDate("04/");

        orderPage.clickOnProcessButton();
        orderPage.clickonViewAllOrders();
        Thread.sleep(4000);

    }



}
