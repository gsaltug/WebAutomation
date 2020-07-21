package com.weborders.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage {
//Product Information

    @FindBy(name = "ctl00$MainContent$fmwOrder$ddlProduct")
    private WebElement productDropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    private WebElement pricePerUnit;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    private WebElement discount;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    private WebElement total;

    @FindBy(css = "[value='Calculate']")
    private WebElement calculateButton;

    //Address Information
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement customerName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement street;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement city;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement state;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement zip;

    //Payment Information
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement expirationDate;

    @FindBy(xpath = "//input[@value='Visa']")
    private WebElement visaCard;
    //Select product dropdown

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardNumberr;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processButton;

    public void selectProduct(String productName) {
        Select select = new Select(productDropdown);
        select.selectByVisibleText(productName);
    }

    //Enter quantity

    public void enterQuantity(String quantityValue) {
        //this solution delete and enter the text
        quantity.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), quantityValue);

    }

    public void pricePerUnit(String priceperUnit) {
        //this solution delete and enter the text, delete old value and enter value in one action
        pricePerUnit.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), priceperUnit);
    }

    public void enterDiscount(String enterDiscount) {
        discount.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), enterDiscount);
    }

    public void clicktoCalculate() {
        calculateButton.click();
    }

    public void enterCustomerName(String customername) {
        customerName.sendKeys(customername);
    }

    public void enterStreet(String streetvalue) {
        street.sendKeys(streetvalue);
    }

    public void entercity(String cityvalue) {
        city.sendKeys(cityvalue);
    }

    public void enterState(String statevalue) {
        state.sendKeys(statevalue);
    }

    public void enterZip(String zipvalue) {
        zip.sendKeys(zipvalue);
    }

    public void selectCard(String cardName) {
        //for radio button
       // String xpath = String.format("//label[text()='%s']/preceding-sibling::input", cardName);
        String xpath = "//label[text()='" + cardName+ "']/preceding-sibling::input";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
    }

    public void enterCardNumber(String cardNumberValue) {
        cardNumberr.sendKeys(cardNumberValue);
    }

    public void expirationDate(String expirationDateValue) {
        expirationDate.sendKeys(expirationDateValue);
    }

    public void clickOnProcessButton() {
        processButton.click();
    }

    public String getTotal(){
        return total.getAttribute("value");
    }
}
