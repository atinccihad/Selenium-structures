package i01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_navigateMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // fullscreen
        driver.manage().window().maximize();
        // go to url
        driver.navigate().to("https://www.amazon.com");
        /*
        driver.navigate().to(...   methodu sayfada ileri geri yapicaksak kullanilir.
        driver.get() methodu gibi bizi istedigimiz URL'e goturur.
         */
        driver.navigate().to("https://www.techproeducation.com");
        // tekrar amazon sayfasina donelim.
        Thread.sleep(3000);
        driver.navigate().back();
        // tekrar techproed sayfasina gidelim
        Thread.sleep(3000);
        driver.navigate().forward();
        // techproed sayfasini yenileyelim
        Thread.sleep(3000);
        driver.navigate().refresh();
        // son olarak sayfayi kapatiniz
        Thread.sleep(3000);
        driver.close();


    }
}
