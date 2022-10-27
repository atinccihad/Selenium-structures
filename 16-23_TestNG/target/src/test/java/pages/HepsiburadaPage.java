package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HepsiburadaPage {

    public HepsiburadaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@autocomplete='off']")
    public WebElement hepsiburadaSearchBox;

    @FindBy(xpath = "//div[@class=\"searchResultSummaryBar-CbyZhv5896ASVcYBLKmx\"]")
    public WebElement hepsiburadaAramaSonucYazisi;

    @FindBy(xpath = "(//div//ul//li//span[@class='sf-MenuItems-UHHCg2qrE5_YBqDV_7AC'])[1]")
    public WebElement elektronics;

    @FindBy(xpath = "((//div//ul//li//div[@class='sf-MenuItems-LuiGWKGCzrRUM4_iLEgn'])[1]//div//ul//a)[1]")
    public WebElement bilgisayarTablet;

    @FindBy(xpath = "(//div[@class='sf-ChildMenuItems-OMxRJDk0466HYQpTli0P'])[1]//ul//li//ul//li//a//span")
    // 66 tane kucuk link
    public List<WebElement> kucukAltBasliklar;

    // Bilgisayar/Tablet altindaki  Alt basliklarda dahil kucuk linklerle beraber
    @FindBy(xpath = "((//div//ul//li//div[@class='sf-MenuItems-LuiGWKGCzrRUM4_iLEgn'])[1]//div//ul//div)[1]//ul//li//a")
    // 80 basliklar da dahil
    public List<WebElement> bilgisayarTableAlt;


}
