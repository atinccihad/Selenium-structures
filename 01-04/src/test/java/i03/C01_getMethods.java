package i03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_getMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusunu locate ediniz
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // arama kutusunun tagName'inin input oldugunu test ediniz
        String expectedTagName = "input";
        String actualTagName = searchBox.getTagName();

        if (actualTagName.equals(expectedTagName)) {
            System.out.println("tagName testi PASS");
        } else {
            System.out.println("tagName testi PASS+\ntag name: " + actualTagName);
        }

        // arama kutusu'nun name attribute'nun field-keywords oldugunu test ediniz
        String expectedAttributeName = "field-keywords";
        String actualAttributeName = searchBox.getAttribute("name");

        if (actualAttributeName.equals(expectedAttributeName)) {
            System.out.println("attribute testi PASS");
        } else {
            System.out.println("attribute testi FAILED");
        }

        // arama kutusunun konumunu yazdiriniz
        System.out.println("arama kutusu konumu: "+searchBox.getLocation());

        // sayfayi kapatiniz
        driver.close();

    }
}
