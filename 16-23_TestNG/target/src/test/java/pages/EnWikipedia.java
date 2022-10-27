package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EnWikipedia {

    public EnWikipedia() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]/table[4]/caption")
    public WebElement nameOfList;

    @FindBy(xpath = "(//tr)[22]")
    public WebElement fourthRow;

    @FindBy(xpath = "((//tr)[23]//td)[1]")
    public WebElement secondElementFourthRow;

    @FindBy(xpath = "((//tr)[23]//td)[2]")
    public WebElement thirdElementFourthRow;

}
