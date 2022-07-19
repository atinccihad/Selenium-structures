package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeleteAccountPage {

    public DeleteAccountPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Locators

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement loggedinText;

    @FindBy(xpath = "//*[text()=' Delete Account']")
    public WebElement deleteButton;


}
