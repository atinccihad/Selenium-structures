package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TrendyolPage {

    public TrendyolPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id=\"onetrust-accept-btn-handler\"]")
    public WebElement sanaOzelBirDeneyimIcinCalisiyoruz;

    @FindBy(xpath = "//div[@class=\"modal-close\"]")
    public WebElement aradiginizHerSeyTrendyoldaExit;

    @FindBy(xpath = "//input[@data-testid=\"suggestion\"]")
    public WebElement searchBoxTrendyol;

    @FindBy(xpath = "//div[@class=\"srch-rslt-title\"]")
    public WebElement toplamUrunSayisiTrendyolWE;

    @FindBy(xpath = "//p[text()='Giriş Yap']")
    public WebElement girisYapButton;

    @FindBy(xpath = "//input[@id=\"login-email\"]")
    public WebElement emailBoxTrendyol;

    @FindBy(xpath = "//input[@id=\"login-password-input\"]")
    public WebElement passwordBoxTrendyol;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement submitButtonTrendyol;

    @FindBy(xpath = "(//li[@class=\"tab-link\"])[8]")
    public WebElement elektronikMenuTrendyol;

    @FindBy(xpath = "//a[text()='Bilgisayar & Tablet']")
    public WebElement bilgisayartabletMenuTrendyol;

    @FindBy(xpath = "(//div[@class=\"fltr-item-text ctgry\"])[1]")
    public WebElement bilgisayarKategoriTrendyol;

    @FindBy(xpath = "(//div[@class=\"chckbox\"])[5]")
    public WebElement checkboxApple;

    @FindBy(xpath = "(//div[@class='image-overlay-body'])[1]")
    public WebElement markaAppleIlkUrun;

    @FindBy(xpath = "//*[@style='position: relative;']")
    public WebElement zoom;

    @FindBy(xpath = "//div[@class=\"product-slide\"]")
    public List<WebElement> urunler;

    @FindBy(xpath = "//button[@class=\"add-to-basket\"]")
    public WebElement sepeteEkleButton;

    @FindBy(xpath = "//a[@class=\"link account-basket\"]")
    public WebElement sepetim;

    @FindBy(xpath = "//a[@href=\"/sepetim/odeme\"]")
    public WebElement sepetiOnaylaButton;

    @FindBy(xpath = "(//i[@class=\"i-radio-selected\"])[1]")
    public WebElement sestAdresiButton;

    @FindBy(xpath = "(//button[@class=\"ty-primary-btn ty-btn-large\"])[1]")
    public WebElement kaydetdevamEButton;


    @FindBy(xpath = "//input[@id=\"card-number\"]")
    public WebElement kartnumarasi;


    @FindBy(xpath = "(//button[text()='Ödeme Yap'])[1]")
    public WebElement odemeYapButton;

    @FindBy(xpath = "//div[@class=\"p-card-options-wrapper\"]")
    public WebElement odemeSecenekleri;

    @FindBy(xpath = "(//select[@id=\"card-date-month\"])[1]")
    public WebElement ay;


}
