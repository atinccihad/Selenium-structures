package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

// 1- C01_tekrarTesti isimli bir class olusturun
public class C01_TekrarTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        // 3- cookies uyarisini kabul ederek kapatin
        // 4- Sayfa basliginin "Google" ifadesi icerdigini test edin
        String actualSayfaTitle= driver.getTitle();
        String arananKelime="Google";

        if (actualSayfaTitle.contains(arananKelime)){
            System.out.println("Title testi PASS");
        }else {
            System.out.println("Title testi FAILED");
        }
        // 5- Arama cubuguna "Nutella" yazip aratin
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // 6- Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisiElementi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisiElementi.getText()+"==> icinde");
        // 7- Sonuc sayisinin 10 milyondan fazla oldugunu test edin
        String sonucSayisiString=sonucSayisiElementi.getText();
        String sonucKelimeleri[]=sonucSayisiString.split(" ");
        //System.out.println(Arrays.toString(sonucKelimeleri));
        String sonucNutellaSayisi=sonucKelimeleri[1];//106.000.000
        sonucNutellaSayisi=sonucNutellaSayisi.replace(".","");
        int nutellaAramaSonucu=Integer.parseInt(sonucNutellaSayisi);
        System.out.println("Aramada bulunan Nutella sayisi==>  "+nutellaAramaSonucu);

        if (nutellaAramaSonucu>10000000){
            System.out.println("Nutella arama testi PASS");
        }else {
            System.out.println("Nutella arama testi FAILED");
        }
        // 8- Sayfayi kapatin
        driver.close();
    }
}
