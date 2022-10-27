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

public class TC013 {
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

        // 4. Click 'View Product' for any product on home page
        // 4. Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'ye tıklayın
        WebElement rs1000 = driver.findElement(By.xpath("(//h2[text()='Rs. 1000'])[3]"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(rs1000).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        driver.findElement(By.xpath("//a[@href='/product_details/7']")).click();

        // 5. Verify product detail is opened
        WebElement detail = driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue("detail is not displayed!", detail.isDisplayed());

        // 6. Increase quantity to 4
        // 6. Miktarı 4'e yükseltin
        WebElement quantityBox = driver.findElement(By.xpath("//input[@id='quantity']"));
        quantityBox.click();
        quantityBox.sendKeys(Keys.BACK_SPACE);
        quantityBox.sendKeys(Keys.NUMPAD4);

        // 7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();

        // 8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

        // 9. Verify that product is displayed in cart page with exact quantity
        // 9. Sepet sayfasında ürünün tam miktarı ile görüntülendiğini doğrulayın
        WebElement urunMiktari = driver.findElement(By.xpath("//button[@class='disabled']"));
        int actualUrunMiktari = Integer.parseInt(urunMiktari.getText());
        int expectedUrunMiktari = Integer.parseInt(quantityBox.getText());

        Assert.assertEquals(expectedUrunMiktari, actualUrunMiktari);


    }

}
