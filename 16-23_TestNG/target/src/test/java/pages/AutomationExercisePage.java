package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {

    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href=\"/products\"]")
    public WebElement productsButton;

    @FindBy(xpath = "//h2[@class=\"title text-center\"]")
    public WebElement allProducts;

    @FindBy(xpath = "//i[@class=\"fa fa-search\"]")
    public WebElement searchProductButton;

    @FindBy(xpath = "//input[@id=\"search_product\"]")
    public WebElement searchProductBox;

    @FindBy(xpath = "//div[@class=\"product-overlay\"]")
    public WebElement arananUrunProduct;

    @FindBy(xpath = "//a[@href=\"/login\"]")
    public WebElement signUpLoginButton;


    @FindBy(xpath = "//input[@data-qa=\"signup-name\"]")
    public WebElement newUserSignUpNameBox;

    @FindBy(xpath = "//input[@data-qa=\"signup-email\"]")
    public WebElement newUserSignUpMailBox;

    @FindBy(xpath = "//button[@data-qa=\"signup-button\"]")
    public WebElement newUserSignUpButton;

    @FindBy(xpath = "//input[@id=\"id_gender1\"]")
    public WebElement newUserMrRadioButton;

    @FindBy(id = "password")
    public WebElement newUserPasswordBox;

    @FindBy(xpath = "//select[@id=\"days\"]")
    public WebElement newUserDay;

    @FindBy(xpath = "//select[@id=\"months\"]")
    public WebElement newUserMonth;

    @FindBy(xpath = "//select[@id=\"years\"]")
    public WebElement newUserYear;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement newUserFirstName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement newUserLastName;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement newUserCompany;








}