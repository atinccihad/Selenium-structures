package i11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

// Tests packagenin altina bir class oluşturalim : C05_FileDownload
public class C05_FileDownload extends TestBaseBeforeAfter {

    // Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    @Test
    public void isExist() {
        // Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\USER\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // Indirildigini konsolda gosterin
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void downloadTest() {
        // downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
        // https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
        // https://the-internet.herokuapp.com/download adresine gidelim.
        // test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();
    }

}
