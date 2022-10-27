package i05;

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
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TC008 {
    WebDriver driver;

    @Before
    public void setUp() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testCase1() {
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue("homePage not displayed!", homePage.isDisplayed());

        // 4. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        WebElement allProducts = driver.findElement(By.xpath("//h2[text()='All Products']"));
        Assert.assertTrue(allProducts.isDisplayed());

        // 6. Ürün listesi görünür
        WebElement urunListesi = driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']"));
        Assert.assertTrue(urunListesi.isDisplayed());

        // 7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        WebElement wiewProductButton = driver.findElement(By.xpath("(//a[text()='View Product'])[1]"));
        driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).sendKeys(Keys.PAGE_DOWN);
        wiewProductButton.click();

        // 8. Kullanıcı, ürün detay sayfasına yönlendirilir
        WebElement brands = driver.findElement(By.xpath("//h2[text()='Brands']"));
        Assert.assertTrue(brands.isDisplayed());

        // 9. Ayrıntıların görünür olduğunu doğrulayın: ürün adı, kategori, fiyat, bulunabilirlik, durum, marka
        WebElement urunAdi = driver.findElement(By.xpath("//h2[text()='Blue Top']"));
        WebElement category = driver.findElement(By.xpath("//h2[text()='Category']"));
        WebElement fiyat = driver.findElement(By.xpath("//span[text()='Rs. 500']"));
        WebElement bulunabilirlik = driver.findElement(By.xpath("//b[text()='Availability:']"));
        WebElement durum = driver.findElement(By.xpath("//b[text()='Condition:']"));
        WebElement marka = driver.findElement(By.xpath("//b[text()='Brand:']"));

        Assert.assertTrue("urun adi not displayed!", urunAdi.isDisplayed());
        Assert.assertTrue("category not displayed!", category.isDisplayed());
        Assert.assertTrue("fiyat not displayed!", fiyat.isDisplayed());
        Assert.assertTrue("bulunabilirlik not displayed!", bulunabilirlik.isDisplayed());
        Assert.assertTrue("durum not displayed!", durum.isDisplayed());
        Assert.assertTrue("marka not displayed!", marka.isDisplayed());

    }
}
