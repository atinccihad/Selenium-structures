package i16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C01_getScreenShotWE extends TestBaseBeforeAfter {

    @Test
    public void test() throws IOException {
        // amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        // nutella aratalim, arama sonucunun resmini alalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        // arama sonucunun resmini alalim
        WebElement aramaSonucu = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu = aramaSonucu.getScreenshotAs(OutputType.FILE);
        // Sadece Webelement'in resmini alacaksak TakeScreenShot class'ini kullanmama gerek yok
        // Locate ettigimiz webelementi direk gecici bir file'a atip FileUtils ile kopyalayip yolunu(path) belirtiriz
        FileUtils.copyFile(nutellaAramaSonucu, new File("target/ekranGoruntusuWE/WebESS"+tarih+".jpeg"));

    }
}
