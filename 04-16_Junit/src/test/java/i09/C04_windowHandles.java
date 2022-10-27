package i09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// Tests package’inda yeni bir class olusturun: windowHandle
public class C04_windowHandles {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingAnewWindow = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        String expectedText = "Opening a new window";
        String actualText = openingAnewWindow.getText();
        Assert.assertEquals("expectedText, actualText'e esit degil!", expectedText, actualText);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals("Sayfa title The Internet'e esit degil!", expectedTitle, actualTitle);

        // Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        /*
        Bir web sitesine gittginizde yeni sayfa veya sekme ailirsa
        yeni acilan sekmenin handle degerini bulmak icin  driver.getWindowHandles()  methodunu bir ArrayList'e atip
        butun sayfalarin listesine ulasabiliem.Ilk actigim pencerenin indexi 0 ikinci'nin indexi 1'dir
        ikinci acilan pencere yada sekmede islem yapmak icin
        driver.switchTo().window(listAdi.get(1)) methodunu kullaniriz.
         */
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        /*
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";
        Assert.assertEquals("actualTitle2, expectedTitle2'ye esit degil!", actualTitle2, expectedTitle2);

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement textElementi = driver.findElement(By.xpath("//h3[text()='New Window']"));
        String actualText2 = textElementi.getText();
        String expectedText2 = "New Window";
        Assert.assertEquals("actualText2, expectedText2'ye esit degil!", actualText2, expectedText2);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.navigate().back();
        String actualTitle3 = driver.getTitle();
        String expectedTitle3 = "The Internet";
        Assert.assertNotEquals("Onceki pencerede sayfa basligi 'The Internet'!", expectedTitle3, actualTitle3);
    }
}
