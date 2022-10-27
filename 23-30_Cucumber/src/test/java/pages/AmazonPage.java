package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    public AmazonPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement amazonSearchBox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucElementi;

    @FindBy(xpath = "(//img[@class='s-image'])[1]")
    public WebElement aramaSonucundakiIlkUrun;

    @FindBy(xpath = "//input[@id=\"nav-search-submit-button\"]")
    public WebElement amazonSearchButton;

    @FindBy(xpath = "//div[@class='nav-search-scope nav-sprite']")
    public WebElement allButtonAmazon;

    @FindBy(xpath = "//select//option")
    public List<WebElement> dropdownElementleriAmazon;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    public WebElement signinButton;

    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continiueButton;

    @FindBy(xpath = "//*[.='There was a problem']")
    public WebElement problemMessage;

    @FindBy(xpath = "//span[@class='a-expander-prompt']")
    public WebElement needHelp;

    @FindBy(xpath = "//a[@id='auth-fpp-link-bottom']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//h1")
    public WebElement passwordAssistanceText;

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    public WebElement createYourAccountButton;

    @FindBy(xpath = "//h1")
    public WebElement createAccountText;


}
