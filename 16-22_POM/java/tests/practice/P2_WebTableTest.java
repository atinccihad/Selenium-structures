package tests.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.P2_WebTablePage;
import utilities.Driver;

public class P2_WebTableTest {
    // go to URL: https://en.wikipedia.org/wiki/Dell
    // go to table which name is "List of companies acquired by Dell Inc."
    // print row 4 of the table on console
    // also print on console the 2nd and 3rd elements (middle 2 elements) in line 5
    // ( 2nd and 3rd elements: November 2, Cloud integration leader)

    // url'ye gidin: https://en.wikipedia.org/wiki/Dell
    // "List of companies acquired by Dell Inc."  isimli tabloya gidin,
    // tablonun 4. satirini konsolda yazdirin
    // ayrica 5. satirdaki 2. ve 3. ogeleri(ortadaki 2 oge) konsola yazdirin
    // ( 2nd and 3rd ogeler: November 2 ,Cloud integration leader)


    @Test
    public void tableTest() {
        Driver.getDriver().get("https://en.wikipedia.org/wiki/Dell");
        P2_WebTablePage p2_webTablePage = new P2_WebTablePage();

        JavascriptExecutor jse=(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",p2_webTablePage.nameOfList);

        System.out.println("4.satir: "+p2_webTablePage.fourthRow.getText()+"\n");
        System.out.println("ikinci oge: "+p2_webTablePage.secondElement.getText()+"\n");
        System.out.println("ucuncu oge: "+p2_webTablePage.thirdElement.getText());

        Driver.closeDriver();
    }
}
