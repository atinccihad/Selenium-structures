package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
//C05_FileUpload
public class C05_FileUpload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/upload  adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // chooseFile butonuna basalim
        // Yuklemek istediginiz dosyayi secelim
        // 1- File secme butonunu locate edelim
         WebElement filesecButonu=driver.findElement(By.xpath("//input[@id='file-upload']"));

        // 2- Yukleyecegimiz dosyanin dinamik path'ini hazirlayalim
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\logo.png";

        // 3- sendKeys() ile dinamik path'i dosya sec butonuna yollayalim
        filesecButonu.sendKeys(dosyaYolu);

        // Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        // "File Uploaded!" text inin goruntulendigini test edelim.
        Thread.sleep(7000);
        WebElement sonucYazsisElementi=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(sonucYazsisElementi.isDisplayed(),"SonucYazisiGorunmuyor!!");
    }

}
