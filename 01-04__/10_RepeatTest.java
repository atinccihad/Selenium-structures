package day03_WebelementLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2. Youtube web sayfasina gidin ve sayfa basliginin "youtube" olup olmadigini dogrulayin(verify)
        //    eger degilse dogru basligi(Actual Title) konsolda yazdirin.
        driver.navigate().to("https://www.youtube.com");
        String actualTitleYoutube= driver.getTitle();
        String expectedYoutubeTitle="youtube";

        if (actualTitleYoutube.equals(expectedYoutubeTitle)){
            System.out.println("Youtube title testi PASS");
        }else {
            System.out.println("Youtube title testi FAIL\nactual sayfa basligi: "+actualTitleYoutube);
        }
        // 3. Sayfa URL'sinin "youtube" icerip icermedigini(contains) dogrulayin,
        //    icermiyorsa dogru URL'yi yazdirin.
        String actualYoutubeUrl=driver.getCurrentUrl();
        String arananKelimeYoutubeUrl="youtube";
        if (actualYoutubeUrl.contains(arananKelimeYoutubeUrl)){
            System.out.println("Youtube URL testi PASS");
        }else {
            System.out.println("Youtube URL testi FAILED\nActual Youtube url: "+actualYoutubeUrl);
        }
        // 4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        // 5. Youtube sayfasina geri donun
        driver.navigate().back();
        // 6. Sayfayi yenileyin
        driver.navigate().refresh();
        // 7. Amazon sayfasina donun
        driver.navigate().forward();
        // 8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
        // 9. Ardindan sayfa basliginin "Amazon" icerip icermedigini(contains) dogrulayin,
        //    yoksa dogru basligi(Actual Title) yazdirin.
        String actualAmazonTitle=driver.getTitle();
        String amazonTitleArananKelime="Amazon";
        if (actualAmazonTitle.contains(amazonTitleArananKelime)){
            System.out.println("Amazon Title testi PASS");
        }else{
            System.out.println("Amazon Title testi FAILED\nActual amazon Title: "+actualAmazonTitle);
        }
        // 10. Sayfa URL'sinin https://www.amazon.com/ olup olmadigini dogrulayin
        //     degilse dogru URL'yi yazdirin.
        String expectedAmazonUrl="https://www.amazon.com/";
        String actualAmazonUrl=driver.getCurrentUrl();

        if (expectedAmazonUrl.equals(actualAmazonUrl)){
            System.out.println("Amazon URL testi PASS");
        }else {
            System.out.println("Amazon URL testi FAILED\nActual Amazon Url: "+actualAmazonUrl);
        }
        // 11. Sayfayi kapatin.
        driver.close();
    }
}
