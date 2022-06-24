package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HMCPage {
    public HMCPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='/Account/Logon']")
    public WebElement mainPageLoginLinki;

    @FindBy(id="UserName")
    public WebElement usernameTextBox;

    @FindBy(id="Password")
    public WebElement passwordTextBox;

    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;

    @FindBy(xpath="//li[text()='Username or password is incorrect, please correct them and try again']")
    public WebElement girisYapilamadiYaziElementi;

    @FindBy(xpath = "//input[@id='DTE_Field_extn']")
    public WebElement extensionBox;

}
