package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MorhipoPage {

    public MorhipoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "pw-search-input")
    public WebElement morhipoSearchBox;

    @FindBy(xpath = "//div[@class=\"col-xxs-5 col-xs-4 col-sm-3 col-md-2 total_prod_count count-text text-center\"]")
    public WebElement morhipoToplamUrunSayisiElemnti;

    @FindBy(xpath = "//span[@class=\"search-btn pw-search-element\"]")
    public WebElement araButton;

}
