package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationPracticePage {

    public AutomationPracticePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//a[@href=\"/test_cases\"])[1]")
    public WebElement testCasesButton;

    @FindBy(xpath = "//b[text()='Test Cases']")
    public WebElement testCasesYazisi;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id=\"email_create\"]")
    public WebElement emailAdressBox;
    @FindBy(xpath = " //button[@id=\"SubmitCreate\"]")
    public WebElement createAnAccount;
    @FindBy(xpath = "//input[@id=\"id_gender1\"]")
    public WebElement mrButton;
    @FindBy (xpath = "(//*[text()='My account'])[1]")
    public WebElement myAccountText;


}
