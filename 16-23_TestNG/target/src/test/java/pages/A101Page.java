package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Scanner;

public class A101Page {
    public A101Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")
    public WebElement cerezKullanimiKabulEtButton;

    @FindBy(xpath = "(//div[@onclick=\"persona_PopupClose();\"])[1]")
    public WebElement cikmadanGozAtExit;

   // @FindBy(xpath = "//div[@class=\"personaclick-search-overlay\"]")
   // public WebElement tumSayfaAramaKutusuOncesi;

    @FindBy(xpath = "//input[@name=\"search_text\"]")
     public WebElement a101SearchBox;

    @FindBy(xpath = "(//em[@class=\"input-icon icon-search\"])[2]")
    public WebElement a101SearchButton;







}
