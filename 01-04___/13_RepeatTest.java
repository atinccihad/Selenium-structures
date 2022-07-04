package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_TekrarTesti {
    //2. Main method olusturun ve asagidaki gorevi tamamlayin.
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //   a. amazon web sayfasina gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //   b. Search(ara) "city bike" yazip aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike"+ Keys.ENTER);
        //aramaKutusu.submit();    istersek Keys.ENTER yerine bu satiri da yazabiliriz

        //   c. Amazon'da goruntulenen ilgili sonuclarin sayisini yazdirin.
        //WebElement sonucYazisiElementi =driver.findElement(By.className("sg-col-inner"));
        WebElement sonucYazisiElementi =driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));
        //Classname ile daha once bu elementi locate edemedigimiz halde
        //xpath ile class attribute'unu kullanarak locate edebildik
        System.out.println(sonucYazisiElementi.getText());

        //   d. Sonra karsiniza cikan ilk sonucun resmine tiklayin.
        /*
        WebElement ilkUrunResmi=driver.findElement(By.className("s-image"));
        ilkUrunResmi.click();
        */
        // sadece click yapmak gibi basit bir islemde kullanacagimiz elementler icin
        // variable olusturmadan direk locate edip ,istedigimiz islemi yapabiliriz
        driver.findElement(By.className("s-image")).click();



    }
}
