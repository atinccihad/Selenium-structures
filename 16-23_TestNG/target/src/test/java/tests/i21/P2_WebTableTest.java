package tests.i21;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.EnWikipedia;
import utilities.ConfigReader;
import utilities.Driver;

public class P2_WebTableTest {

    EnWikipedia enWikipedia;

    @Test
    public void tableTest() {
        enWikipedia = new EnWikipedia();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // go to URL : https://en.wikipedia.org/wiki/Dell
        Driver.getDriver().get(ConfigReader.getProperty("enWikipediaOrgWikiDell"));
        // go to table which name is 'List of companies acquried by Dell Inc.'
        js.executeScript("arguments[0].scrollIntoView(true);", enWikipedia.fourthRow);
        // print row 4 of the table on console
        System.out.println("4.satir: " + enWikipedia.fourthRow.getText() + "\n");
        // also print on console the 2nd and 3rd elements(middle 2 elements) in line 5
        System.out.println("Ikinci oge: " + enWikipedia.secondElementFourthRow.getText() + "\n");
        System.out.println("Ucuncu oge: " + enWikipedia.thirdElementFourthRow.getText());
        // (2nd and 3rd elements : November 2, Cloud integration leader)
        Driver.closeDriver();
    }
}
