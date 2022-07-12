package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoQaPage {
    public DemoQaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css="[id=\"enableAfter\"]")
    public WebElement willEnable5SecondElement;
}
