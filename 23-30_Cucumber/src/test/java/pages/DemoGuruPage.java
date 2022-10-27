package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoGuruPage {
    public DemoGuruPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//thead//tr//th)[1]")
    public WebElement company;

    @FindBy(xpath = "(//thead//tr//th)[2]")
    public WebElement group;

    @FindBy(xpath = "(//thead//tr//th)[3]")
    public WebElement prevClose;

    @FindBy(xpath = "(//thead//tr//th)[1]")
    public WebElement currentPrice;

    @FindBy(xpath = "(//thead//tr//th)[1]")
    public WebElement change;

    @FindBy(xpath = "//table//tbody//tr")
    public WebElement satirlar;

    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> basliklarList;

    @FindBy(xpath = "//table[@class='dataTable']/tbody/tr")
    public List<WebElement> rowList;

    @FindBy(xpath = "//table[@class='dataTable']/tbody/tr/td")
    public List<WebElement> cell;

    public void istenenCell(int istenenCellNumber) {
        String dinamikXpath;
        int rowNumber = rowList.size();
        for (int i = 1; i <= rowNumber; i++) {
            dinamikXpath = "(//table[@class='dataTable']/tbody/tr[" + i + "]/td[" + istenenCellNumber + "])";
            WebElement istenenDeger = Driver.getDriver().findElement(By.xpath(dinamikXpath));
            System.out.println(istenenDeger.getText());
        }
    }


}
