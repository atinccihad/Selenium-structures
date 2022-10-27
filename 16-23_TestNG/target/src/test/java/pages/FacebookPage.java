package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@class='inputtext _55r1 _6luy']")
    public WebElement emailOrNumberBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@value=\"1\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text()=\"The email address you entered isn't connected to an account. \"]")
    public WebElement girisYapilamadiYaziElementi;

    @FindBy(xpath = "(//div[@class=\"mfclru0v alzwoclg i85zmo3j\"])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"mount_0_0_Ks\"]/div/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/label/input")
    public WebElement searchBox;

}
