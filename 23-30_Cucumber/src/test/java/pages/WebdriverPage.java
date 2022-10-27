package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebdriverPage {

    public WebdriverPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//h1[text()='LOGIN PORTAL']")
    public WebElement loginportal;

    @FindBy(xpath = "//input[@id=\"text\"]")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement passwordBox;

    @FindBy(xpath = "//a[@id=\"login-portal\"]")
    public WebElement loginButton;

}
