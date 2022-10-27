package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HMCPage {

    public HMCPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement logInButton;

    @FindBy(xpath = "//input[@id=\"UserName\"]")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@id=\"Password\"]")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement logInButton2;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement logInOlmusKullaniciIsmi;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement girisYapilamadiYaziElementi;

    @FindBy(xpath = "//a[@id='menuHotels']")
    public WebElement hotelmanagementButton;

    @FindBy(xpath = "(//i[@class=\"icon-calendar\"])[4]")
    public WebElement roomreservationButton;

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addRoomReservationButton;

    @FindBy(xpath = "(//select[@class=\"form-control input-lg required\"])[1]")
    public WebElement selectUserDropdown;

    @FindBy(xpath = "(//select[@class='form-control input-lg required'])[2]")
    public WebElement hotelroomDropdown;

    @FindBy(xpath = "//input[@id=\"Price\"]")
    public WebElement priceBox;

    @FindBy(xpath = "(//input[@class=\"form-control required\"])[1]")
    public WebElement dateStart;

    @FindBy(xpath = "(//input[@class=\"form-control required\"])[2]")
    public WebElement dateEnd;

    @FindBy(xpath = "//input[@data-val-number=\"The field AdultAmount must be a number.\"]")
    public WebElement defaultAmount;

    @FindBy(xpath = "//input[@data-val-number=\"The field ChildrenAmount must be a number.\"]")
    public WebElement childrenAmount;

    @FindBy(xpath = "//input[@id='ContactNameSurname']")
    public WebElement contactNameSurname;

    @FindBy(xpath = "//input[@id='ContactPhone']")
    public WebElement contactPhone;

    @FindBy(xpath = "//input[@id='ContactEmail']")
    public WebElement contactemail;

    @FindBy(xpath = "//input[@id='Notes']")
    public WebElement notes;

    @FindBy(xpath = "//input[@id='Approved']")
    public WebElement approvedButton;

    @FindBy(xpath = "//input[@id='IsPaid']")
    public WebElement isPaidButton;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement successText;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement okButton;









}
