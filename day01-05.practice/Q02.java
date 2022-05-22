package practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Q02 {
    public static void main(String[] args) {
        // ...Exercise2...
        // 1-driver olusturalim
        // 2-java class'imiza chromedriver.exe'yi tanitalim
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        // 3-driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();
        // 4-driver'a sayfanin yuklenmesini 10.000 milisaniye(10 saniye) boyunca beklemesini soyleyelim.
        //   Eger oncesinde sayfa yuklenirse, beklemeyi biraksin.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 5-"sahibinden.com" adresine gidelim
        driver.get("https://www.sahibinden.com");
        // 6- bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String shbndnTitle= driver.getTitle();
        String shbndnUrl=driver.getCurrentUrl();
        System.out.println("sahibindenUrl==> "+shbndnUrl+" sahibindenTitle==> "+shbndnTitle);
        // 7-title ve url'nin "Oto"kelimesinin icerip icermedigini kontrol edelim
        if (shbndnTitle.equals("Oto")){
            System.out.println("Oto yazisi title testi PASS");
        }else {
            System.out.println("Oto yazisi title testi FAIL");
        }
        if (shbndnUrl.equals("Oto")){
            System.out.println("Oto yazisi URL testi PASS");
        }else {
            System.out.println("Oto yazisi URL testi FAIL");
        }
        // 8-Ardindan "gittigidiyor.com" adresine gidelim
        driver.get("https://www.gittigidiyor.com");
        // 9-Bu adresin basligini alalim ve "Sitesi" kelimesini icerip icermedigini kontrol edelim
        /************************** ifElse 1 *******************************/
        boolean isTrue=driver.getTitle().contains("Sitesi");
        if (isTrue)
            System.out.println("test SUCCESS");
        else
            System.out.println("test FAIL");
        /************************** ifElse 2 *******************************/
        if (driver.getTitle().contains("Sitesi")){
            System.out.println("Sitesi yazisinin testi PASS");
        }else {
            System.out.println("Sitesi yazisinin testi FAIL");
        }
       /******************************ternary***********************************/
        String gittiGidiyorTitle=driver.getTitle();
        System.out.println(gittiGidiyorTitle.contains("Sitesi")?"PASS":"FAIL");
        // 10-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
        // 11-Sayfayi yenileyelim
        driver.navigate().refresh();
        // 12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();
        // 13-Son adim olarak butun sayfalarimizi kapatmis olalim
        driver.close();
    }
}
