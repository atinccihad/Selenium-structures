package day02_driverMethods.C02_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Tekrar {
    // Normalde selenium'un kendi IDE'side var fakat biz daha kullanisli oldugu icin Intelij kullaniyoruz
    // Intelij'de yeni bir proje actigimizda oncelikle selenium kutuphanelerini proje'ye eklememiz gerekir
    // Biz en ilkel haliyle projemize kutuphaneleri jar dosyalari olarak yukledik
    // Bu ekledigimiz dosyalarla artik driver'in ayarlarini yapabiliriz

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        // setProperty methodu iki parametre ister
        // ilki kullanacagimiz browser'a ait driver
        // ikinci parametre ise selenium sitesinden iindirip projemize ekledigimiz choromeDriver'in path'i
        // windows kullanicilari sona .exe eklerken , apple kullananlar .exe eklememeli

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        Thread.sleep(5000);
        // Java'dan gelir ,icine yazilan milisaniye kadar kodlarin calismasini durdurur

        driver.close();
        // driver.close class'in sonuna yazilir .Cunku bu kod calisinca driver'imiz kapanir
        // Bu kod'dan sonra yeniden bir browser acmak istiyorsak driver'a yeni deger atamalitiz


    }


}
