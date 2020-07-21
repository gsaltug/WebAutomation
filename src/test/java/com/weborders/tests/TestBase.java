package com.weborders.tests;

import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void setUp(){

        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();



    }

    public void tearDown(){
        Driver.closeDriver();

    }
}
