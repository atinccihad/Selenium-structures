package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ConcortHotelPage {


    public ConcortHotelPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public String concortHotelUrl = "https://qa-environment.concorthotel.com/";

    @FindBy(xpath = "//button[@id=\"details-button\"]")
    public WebElement advancedButton;

    @FindBy(xpath = "//a[text()='Proceed to qa-environment.concorthotel.com (unsafe)']")
    public WebElement proceedtoqaButton;

    @FindBy(xpath = "//a[@href=\"/Account/Logon\"]")
    public WebElement concortHotelLoginButton;


    @FindBy(xpath = "//input[@class='form-control required']")
    public WebElement concortUsernameBox;

    @FindBy(xpath = "//input[@class='form-control required password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id=\"btnSubmit\"]")
    public WebElement loginButton2;

    @FindBy(xpath = "//select[@id=\"IDHotel\"]")
    public WebElement selectHotel;



    @FindBy(xpath = "(//span[@class=\"title\"])[3]")
    public WebElement hotelManagementButton;

    @FindBy(xpath = "//a[@href=\"/admin/HotelRoomAdmin\"]")
    public WebElement hotelRoomsButton;

    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addHotelRoomButton;

    @FindBy(xpath = "//input[@id=\"Code\"]")
    public WebElement codeBox;

    @FindBy(xpath = "//input[@id=\"Name\"]")
    public WebElement nameBox;

    @FindBy(xpath = "//input[@id=\"Location\"]")
    public WebElement locationBox;

    @FindBy(xpath = "//textarea[@dir=\"ltr\"]")
    public WebElement textBox;

    @FindBy(xpath = "//input[@id=\"Price\"]")
    public WebElement priceBox;

    @FindBy(xpath = "(//a[@class=\"label label-success\"])[1]")
    public WebElement priceButton;

    @FindBy(xpath = "(//select[@class=\"form-control input-lg required\"])[2]")
    public WebElement roomType;

    @FindBy(xpath = "//*[@id=\"MaxAdultCount\"]")
    public WebElement maxAdultCount;

    @FindBy(xpath = "//input[@id='MaxChildCount']")
    public WebElement maxChildrenCount;

    @FindBy(xpath = "//div[@id='uniform-IsAvailable']")
    public WebElement approved;

    @FindBy(xpath = "//*[@id=\"btnSubmit\"]")
    public WebElement saveButton;





}
