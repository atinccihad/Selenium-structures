package i15;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_getScreenShot extends TestBaseBeforeAfter {
    @Test
    public void screenShot() throws IOException {
        // https://www.amazon.com sayfasina gidip tum sayfa screenShot aliniz
        driver.get("https://www.bestbuy.com");
        /*
        Bir web sayfasinin resmini alabilmek icin TakesScreenShot class'indan obje olusturup
        gecici bir File class'indan bir degiskene TakesScreenShot'dan olusturdugum obje'den getScreenShotAs
        methodunu kullanarak gecici bir file olustururuz
         */

        TakesScreenshot tks = (TakesScreenshot) driver;
        File tumSayfaResim = tks.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResim,new File("target/screenShot/allPage"+tarih+".jpeg"));

    }
}
