package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GooglePage {

    public GooglePage(){
        // Bir page class'i actigimizda ilk yapmamiz gereken sey
        // parametresiz bir constructor olusturup bu constructor icinde
        // PageFactory ile driver'a ilk deger atamasi yapmak olmalidir
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "gLFyf gsfi")
    public WebElement googleSearchBox;

}
