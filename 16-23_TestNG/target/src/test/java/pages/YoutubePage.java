package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class YoutubePage {

    public YoutubePage(){
        // Bir page class'i actigimizda ilk yapmamiz gereken sey
        // parametresiz bir constructor olusturup bu constructor icinde
        // PageFactory ile driver'a ilk deger atamasi yapmak olmalidir
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='search']")
    public WebElement youtubeSearchBox;

    @FindBy(xpath = "(//yt-icon[@id='logo-icon'])[1]")
    public WebElement youtubeLogo;

    @FindBy(xpath = "(//yt-icon[@id=\"guide-icon\"])")
    public WebElement youtubeMenuButton;




}
