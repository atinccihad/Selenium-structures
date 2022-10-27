package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    public String amazonUrl="https://www.amazon.com/";

    @FindBy(id="twotabsearchtextbox")
    public WebElement amazonSearchBox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucElementi;

    @FindBy(xpath = "(//img[@class='s-image'])[1]")
    public WebElement aramaSonucundakiIlkUrun;

}
