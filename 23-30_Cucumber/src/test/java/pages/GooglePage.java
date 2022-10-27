package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GooglePage {

    public GooglePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@class=\"gLFyf gsfi\"]")
    public WebElement searchBox;

    @FindBy(xpath = "(//span[text()='https://www.trendyol.com/'])[1]")
    public WebElement trendyolLinki;

}
