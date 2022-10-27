package i01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_windowHandle {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        // driver tanimlama
        WebDriver driver = new ChromeDriver();
        // browser'i maximize yapalim
        driver.manage().window().maximize();
        // https://www.amazon.com  url'ine gidelim
        driver.get("https://www.amazon.com");
        // sayfanin windowHandle degerini getirin.
        System.out.println(driver.getWindowHandle()); // farkli pencereler arasinda window handle degeri kullanilir.


    }
}
