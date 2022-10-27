package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalCars {

    public BlueRentalCars() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@role='button'])[1]")
    public WebElement loginButton;

    @FindBy(id = "formBasicEmail")
    public WebElement emailBox;

    @FindBy(id = "formBasicPassword")
    public WebElement paswordBox;

    @FindBy(xpath = "//button[text()=\"John Walker\"]")
    public WebElement text;

    @FindBy(xpath = "//select[@name=\"car\"]")
    public WebElement carMarka;

    @FindBy(xpath = "//select[@class=\"mb-3 form-select form-select-lg\"]")
    public WebElement maseratiSecimi;

    @FindBy(xpath = "(//input[@placeholder=\"Select a place\"])[1]")
    public WebElement il;

    @FindBy(xpath = "(//input[@placeholder=\"Select a place\"])[2]")
    public WebElement ilce;

}
