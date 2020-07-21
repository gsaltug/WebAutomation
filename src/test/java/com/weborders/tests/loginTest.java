package com.weborders.tests;

import com.weborders.pages.LoginPage;
import com.weborders.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginTest extends TestBase{

    @Test
public void loginTest(){
        LoginPage loginPage = new LoginPage();

        loginPage.login();

        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders", "Page title is wrong!");

}
}
