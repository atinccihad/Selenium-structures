package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DatatablesPage {
    public DatatablesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement loginYazisi;

    @FindBy(css = "input[id='formBasicEmail']")
    public WebElement emailTextBox;

    @FindBy(css = "input[id='formBasicPassword']")
    public WebElement passwordTextBox;

    @FindBy(xpath = " //button[@class='btn btn-primary']")
    public WebElement ikinciLoginYazisi;

    @FindBy(xpath = "//*[text()='John Walker']")
    public WebElement jhonWalkerYazisi;

    @FindBy(xpath = "//*[@class='dt-button buttons-create']")
    public WebElement newButton;

    @FindBy(css = "#DTE_Field_first_name")
    public WebElement firstname;

    @FindBy(xpath = "//*[@type='search']")
    public WebElement search;

    @FindBy(xpath = "//*[@class='sorting_1']")
    public WebElement isimVar;


}
