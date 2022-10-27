package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TutorialsninjaPage {

    public TutorialsninjaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href=\"http://tutorialsninja.com/demo/index.php?route=product/category&path=24\"]")
    public WebElement phonesPdaButton;

    @FindBy(xpath = "//h4")
    public List<WebElement> brandOfPhones;

    @FindBy(xpath = "//span[@id=\"cart-total\"]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[@id=\"cart\"]")
    public WebElement clickBlackButton;

    @FindBy(xpath = "//td[@class=\"text-left\"]")
    public List<WebElement> sepetListesi;

    @FindBy(xpath = "//td[.='$583.19']")
    public WebElement totalPrice;


}
