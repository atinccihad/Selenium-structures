package i02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_manageMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(5000);
        driver.get("https://www.amazon.com");
        driver.close();
        /*
        wait konusunu daha genis olarak ele alacagiz
        bir sayfa acilirken, ilk basta sayfanin icerisinde bulunan elementlere gore bir
        yukleme suresine ihtiyac vardir veya bir webelementin kullanilabilmesi icin zaman ihtiyac olabilir.
        implicitlyWait bize sayfanin yuklenmesi ve sayfadaki elementlere ulasim icin beklenecek
        MAXIMUM sureyi belirleme olanagi tanir
         */


    }
}
