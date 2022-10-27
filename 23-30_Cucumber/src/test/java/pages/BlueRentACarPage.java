package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentACarPage {

    public BlueRentACarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li//a[@role=\"button\"]")
    public WebElement breLoginButton;

    @FindBy(xpath = "//input[@id='formBasicEmail']")
    public WebElement breEmailBox;

    @FindBy(xpath = "//input[@id='formBasicPassword']")
    public WebElement brePasswordBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement getBreLoginButton2;


}
