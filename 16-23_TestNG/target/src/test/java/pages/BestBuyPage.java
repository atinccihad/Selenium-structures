package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BestBuyPage {

    public BestBuyPage(){
        // Bir page class'i actigimizda ilk yapmamiz gereken sey
        // parametresiz bir constructor olusturup bu constructor icinde
        // PageFactory ile driver'a ilk deger atamasi yapmak olmalidir
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String bestbuyUrl ="https://www.bestbuy.com/";

    @FindBy(xpath = "//button[text()='English']")
    public WebElement bestBuyEnglishButton;

    @FindBy(xpath = "(//img[@alt=\"United States\"])[1]")
    public WebElement bestBuyUnitedStatesButton;

    @FindBy(xpath = "//input[@id=\"gh-search-input\"]")
    public WebElement bestBuySearchBox;

    @FindBy(xpath = "//button[@id=\"survey_invite_no\"]")
    public WebElement bestBuyFeedbackButton;

    @FindBy(xpath = "(//span[@aria-hidden=\"true\"])[2]")
    public WebElement bestBuySearchButton;

    @FindBy(xpath = "(//a[@href=\"/site/laptop-computers/macbooks/pcmcat247400050001.c?id=pcmcat247400050001\"])[3]")
    public WebElement bestBuyAppleButton;

    @FindBy(xpath = "//div[@class='footer top-border wrapper']")
    public WebElement bestBuySayfaGecisMenusu;



}
