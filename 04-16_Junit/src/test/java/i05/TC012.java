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
import java.util.ArrayList;
import java.util.List;

public class TC012 {
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
    public void testCase1() throws InterruptedException {
        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("home page is not visible!", expectedUrl, actualUrl);

        // 4. Click 'Products' button
        driver.findElement(By.xpath(" //a[text()=' Products']")).click();

        // 5. Hover over first product and click 'Add to cart'
        // 5. İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        List<WebElement> sepettekiUrunlerListesi = new ArrayList<>();

        WebElement addToCardFirstElement = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));
        sepettekiUrunlerListesi.add(addToCardFirstElement);

        Actions actions = new Actions(driver);
        actions.scrollToElement(addToCardFirstElement).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.moveToElement(addToCardFirstElement).perform();
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[2]")).click();
        Thread.sleep(3000);

        // 6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        // 7. Hover over second product and click 'Add to cart'
        // 7. İkinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        WebElement secondElement = driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[4]"));
        secondElement.click();
        sepettekiUrunlerListesi.add(secondElement);

        // 8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

        // 9. Verify both products are added to Cart
        // 9. Her iki ürünün de Sepete eklendiğini doğrulayın
        int expectedSize = 2;
        int actualSize = sepettekiUrunlerListesi.size();

        Assert.assertEquals("Sepette 2 urun yok!", expectedSize, actualSize);

        // 10. Verify their prices, quantity and total price
        // 10. Fiyatlarını, miktarını ve toplam fiyatını doğrulayın
        WebElement urunmiktaribirinciUrun = driver.findElement(By.xpath("//button[text()='1']"));
        String ilkUrunMiktariStr = urunmiktaribirinciUrun.getText();
        int birinciUrunMiktari = Integer.parseInt(ilkUrunMiktariStr);

        WebElement totalBirinciurunFiyatiWebelement = driver.findElement(By.xpath("(//p[text()='Rs. 500'])[1]"));
        String birinciUrunFiyatiString = totalBirinciurunFiyatiWebelement.getText();
        String[] birinciUrunFiyatiArr = birinciUrunFiyatiString.split(" ");
        String birinciUrunFiyatiStr = birinciUrunFiyatiArr[1];
        int birinciUrunFiyati = Integer.parseInt(birinciUrunFiyatiStr);
        int birinciUrunTotal = birinciUrunMiktari * birinciUrunFiyati;

        WebElement urunmiktariIkinciUrun = driver.findElement(By.xpath("(//button[@class='disabled'])[2]"));
        String ikinciUrunMiktariStr = urunmiktariIkinciUrun.getText();
        int ikinciUrunMiktari = Integer.parseInt(ikinciUrunMiktariStr);

        WebElement totalIkinciurunFiyatiWebelement = driver.findElement(By.xpath("(//p[text()='Rs. 400'])[1]"));
        String ikinciUrunFiyatiString = totalIkinciurunFiyatiWebelement.getText();
        String[] ikinciUrunFiyatiArr = ikinciUrunFiyatiString.split(" ");
        String ikinciUrunFiyatiStr = ikinciUrunFiyatiArr[1];
        int ikinciUrunFiyati = Integer.parseInt(ikinciUrunFiyatiStr);
        int ikinciUrunTotal = ikinciUrunMiktari * ikinciUrunFiyati;

        System.out.println("birinciUrunMiktari = " + birinciUrunMiktari);
        System.out.println("birinciUrunFiyati = " + birinciUrunFiyati);
        System.out.println("ikinciUrunMiktari = " + ikinciUrunMiktari);
        System.out.println("ikinciUrunFiyati = " + ikinciUrunFiyati);

        Assert.assertTrue("Urun1 totalPrice testi FAILED!", birinciUrunTotal == 500);
        Assert.assertTrue("Urun2 totalPrice testi FAILED!", ikinciUrunTotal == 400);

    }
}
