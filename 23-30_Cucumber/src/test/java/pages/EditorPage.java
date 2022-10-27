package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.WeakHashMap;

public class EditorPage {

   public EditorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "\"dt-button buttons-create\"")
    public WebElement editorNewButton;

   @FindBy(xpath = "//input[@id=\"DTE_Field_first_name\"]")
    public WebElement editorFirstnameBox;

   @FindBy(xpath = "//input[@id=\"DTE_Field_last_name\"]")
    public WebElement editorLastnameBox;



}
