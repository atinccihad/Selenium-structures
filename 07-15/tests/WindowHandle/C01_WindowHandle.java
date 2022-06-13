package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void handleWindows() throws InterruptedException {
       driver.get("https://www.amazon.com");
       String windowHandleDegeri1=driver.getWindowHandle();
        System.out.println("Ilk sayfanin windowHandle degeri==> "+driver.getWindowHandle());
        Thread.sleep(1000);

        driver.switchTo().newWindow(WindowType.WINDOW);// Yeni bir pencere acilir
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com");
        System.out.println("Ikinci sayfanin windowHandle degeri==> "+driver.getWindowHandle());
        String windowHandleDegeri2=driver.getWindowHandle();
        Thread.sleep(1000);

        Set<String> handleDegerleri=driver.getWindowHandles();
        System.out.println(handleDegerleri);
        Thread.sleep(1000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(1000);

        // amazon'un acik oldugu sayfaya gecin ve arama yapin
        driver.switchTo().window(windowHandleDegeri1);
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //bestbuy acik olan sayfaya gecin ve title'in Best Buy icerdigini test edin
        Thread.sleep(1000);
        driver.switchTo().window(windowHandleDegeri2);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        // facebook'un acik oldugu sayfaya gecin
        // ve URL'in https://www.facebook.com/ oldugunu test edin
        // eger acik olan pencerelerden bir tanesinin windowHandle degeri bilinmiyorsa
        // once tumhandle degerlerini bulup bir set'e koyariz
        handleDegerleri=driver.getWindowHandles();

        // bu soru icin su anda set'te 3 window handle degeri var 1. ve 2. sayfanin window handle degerlerini biliyoruz
        // setimizde olup ilk iki sayfa olmayan handle degeri 3. sayfanin handle degeri olacaktir
        String windowHandleDegeri3="";
        for (String each: handleDegerleri){
            if (!(each.equals(windowHandleDegeri1)||each.equals(windowHandleDegeri2))){
                 windowHandleDegeri3=each;
            }
        }
        System.out.println(windowHandleDegeri3);
        System.out.println(handleDegerleri);

        driver.switchTo().window(windowHandleDegeri3);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

        Thread.sleep(3000);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
