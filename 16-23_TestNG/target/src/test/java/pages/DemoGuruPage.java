package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoGuruPage {

    public DemoGuruPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(), 'BANK')]")
    public WebElement bankButton;

    @FindBy(xpath = "//a[contains(text(), 'SALES')]")
    public WebElement salesButton;

    @FindBy(xpath = "(//a[contains(text(), ' 5000')])[1]")
    public WebElement first5000Button;

    @FindBy(xpath = "(//a[contains(text(), ' 5000')])[2]")
    public WebElement second5000Button;

    @FindBy(xpath = "(//td)[6]")
    public WebElement accountDebitSide;


    @FindBy(xpath = "(//td)[10]")
    public WebElement amountDebitSide;

    @FindBy(xpath = "(//div[@class=\"shoppingCart\"])[3]")
    public WebElement accountCreditSide;

    @FindBy(xpath = "(//div[@class=\"shoppingCart\"])[4]")
    public WebElement amountCreditSide;

    @FindBy(linkText = "Perfect!")
    public WebElement perfect;


}
