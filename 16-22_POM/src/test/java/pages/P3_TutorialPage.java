package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class P3_TutorialPage {
    public  P3_TutorialPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(linkText = "Phones & PDAs")
    public WebElement phonesPDAs;

    @FindBy(tagName = "h4")
    public List<WebElement> products;

    @FindBy(xpath = "//*[.='Add to Cart']")
    public List<WebElement> addAllCart;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[2]")
    public WebElement clickBlackButton;

    @FindBy(xpath = "//td[@class='text-left']")
    public List<WebElement> sepetList;

    @FindBy(xpath = "//td[.='$583.19']")
    public WebElement totalPrice;

}
