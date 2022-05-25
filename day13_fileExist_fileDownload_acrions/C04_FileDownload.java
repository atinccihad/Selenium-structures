package tests.day13;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;


// 1. C04_FileDownload
public class C04_FileDownload extends TestBase {
    // 2. Iki tane method olusturun: isExist() ve downloadTest()
    // 3. downloadTest()  methodunun icinde asagidaki testi yapalim:
    //     - https://the-internet.herokuapp.com/download   adresine gidelim.
    //     - test.jpeg  dosyasini indirelim
    // 4. Ardindan isExist()  methodunda dosyanin basariyla indirilip indirilmedigini test edelim

    @Test
    public void isExistTesti(){
       String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\test.jpeg";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void downloadTesti() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[.='test.jpeg']")) .click();
        Thread.sleep(5000);
    }
}
