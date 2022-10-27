package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebappsecurityPage {

    public ZeroWebappsecurityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInButton2;

    @FindBy(xpath = "//strong[text()=\"Online Banking\"]")
    public WebElement onlineBankingButton;

    @FindBy(xpath = "//span[@id='pay_bills_link']")
    public WebElement payBillsButton;

    @FindBy(xpath = "(//li[@class=\"ui-state-default ui-corner-top\"])[2]")
    public WebElement purchaseForeignCurrency;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement currencyDropdownElementi;

    @FindBy(xpath = "//option[text()=\"Eurozone (euro)\"]")
    public WebElement dropdownEurozoneElementi;

}
