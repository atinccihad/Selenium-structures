package i07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_DropDown {
    /*
          ●https://www.amazon.com/ adresine gidin.
          -Test1
          Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
          olmadigini test edin
          -Test2
          1.Kategori menusunden Books secenegini secin
          2.Arama kutusuna Java yazin ve aratin
          3.Bulunan sonuc sayisini yazdirin
          4.Sonucun Java kelimesini icerdigini test edin
    */
    WebDriver driver;
    Select select;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test01() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        select = new Select(ddm);
        /*
        Dropdown menuye ulasmak icin Select class'indan bir obje olustururz ve locate ettigimiz
        dropdown webelementini Select class'ina tanimlariz ve getOption() method'unu kullanarak
        dropdown'u bir List'e atarak dropdown menu'nun butun elemanlarinin sayisina ulasabiliriz.
         */

        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());
        int expextedSayi = 45;
        int actualDds = ddmList.size();

        Assert.assertNotEquals(expextedSayi, actualDds);
    }

    @Test
    public void test02() throws InterruptedException {
        //1- Kategori menusunden "Books" secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        /*
        Eger dropdown menudeki option'a String olarak ulasmak istersek selectByVisibleText() method'u kullaniriz.
        Eger dropdown menunun index'i ile ulasmak istersek selectByIndex() method'u kullaniriz.
         */
        select.selectByIndex(5);
        //select.selectByVisibleText("Books");
        //select.selectByValue("search-alias=stripbooks-intl-ship");
        Thread.sleep(2000);

        /*
        Dropdown menude sectigimiz option'a ulasmak istersek select.getFirstSelectedOption() method'unu kullaniriz.
         */
        System.out.println(select.getFirstSelectedOption().getText());
        //2- Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);


        //3- Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());

        String[] sonucArr = sonucSayisi.getText().split(" ");
        System.out.println("sonuc sayisi -> " + sonucArr[3]);


        //4- Sonucun Java kelimesini icerdigini test edin
        String expected = "Java";
        String actualSonuc = sonucSayisi.getText();
        Assert.assertTrue(actualSonuc.contains(expected));

    }
}
