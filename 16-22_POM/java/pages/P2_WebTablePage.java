package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class P2_WebTablePage {

    public  P2_WebTablePage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="//*[@id=\"mw-content-text\"]/div[1]/table[4]/caption")
    public WebElement nameOfList;

    @FindBy(xpath="//*[@id=\"mw-content-text\"]/div[1]/table[4]/tbody/tr[4]")
    public WebElement fourthRow;

    @FindBy(xpath="//*[@id=\"mw-content-text\"]/div[1]/table[4]/tbody/tr[5]/td[1]/span")
    public WebElement secondElement;

    @FindBy(xpath="//*[@id=\"mw-content-text\"]/div[1]/table[4]/tbody/tr[5]/td[2]")
    public WebElement thirdElement;









}
