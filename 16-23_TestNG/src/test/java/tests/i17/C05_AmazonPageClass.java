package tests.i17;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C05_AmazonPageClass {

    @Test
    public void test01(){
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get("https://www.amazon.com");
        amazonPage.amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);
        System.out.println("Nutella arama sonucu: "+amazonPage.aramaSonucElementi.getText());
        Driver.quitDriver();
    }

}
