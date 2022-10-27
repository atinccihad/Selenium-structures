package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TutorialninjaPage {

    public TutorialninjaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//li)[26]")
    public WebElement phonesPda;

    @FindBy(xpath = "//input[@name=\"search\"]")
    public WebElement tutorialSearchBox;

    @FindBy(xpath = "//h4")
    public List<WebElement> phoneMarkalari;

    @FindBy(xpath = "//div[@class=\"product-thumb\"]")
    public List<WebElement> telefonlar;

    @FindBy(xpath = "//button[@id=\"button-cart\"]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//img[@alt=\"HTC Touch HD\"]")
    public WebElement ilkTelefon;

    @FindBy(xpath = "//div[@id=\"cart\"]")
    public WebElement sepetButton;

    @FindBy(xpath = "//td[@class=\"text-left\"]")
    public List<WebElement> sepettekiUrunler;


}
