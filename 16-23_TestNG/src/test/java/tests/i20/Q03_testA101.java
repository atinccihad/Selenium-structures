package tests.i20;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import pages.A101Page;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Q03_testA101 {


    @Test
    public static void testA101() throws InterruptedException, IOException {

        // https://www.a101.com.tr/ adresine gidin
        A101Page a101Page = new A101Page();
        Driver.getDriver().get(ConfigReader.getProperty("A101Url"));

        // Sayfada cikan reklami kapat tusuna basiniz
        a101Page.cerezKullanimiKabulEtButton.click();

        // searchBox'a arayacaginiz metini girip searchButton'a basiniz
        a101Page.a101SearchBox.sendKeys("Elektronik");
        a101Page.a101SearchButton.click();

        // Girilen sayfanin gorulen kisminin screenshot'ını alin
        String dosyaYolu = "target/screenShot/a101.png";
                ReusableMethods.getScreenshot(dosyaYolu);
        TakesScreenshot tss = (TakesScreenshot) Driver.getDriver();
        Faker faker = new Faker();
        File sayfaSS = new File("target/screenShot/tumsayfa" + (faker.idNumber()) + ".png");
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim, sayfaSS);
        
        // Ilk urunu tiklayin
        Driver.getDriver().findElement(By.xpath("(//figure[@class=\"product-image \"])[1]")).click();

        // Girilen sayfanin gorulen kisminin screenshot'ını alin
        tss = (TakesScreenshot) Driver.getDriver();
        faker = new Faker();
        sayfaSS = new File("target/screenShot/tumsayfa" + (faker.idNumber()) + ".png");
        geciciResim = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim, sayfaSS);

        // Sayfayi kapatin
        Driver.getDriver().close();

    }


}
