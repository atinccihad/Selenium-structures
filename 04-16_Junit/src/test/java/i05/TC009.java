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

public class TC009 {
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
        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("home page is not visible!", expectedUrl, actualUrl);

        // 4. Click on 'Products' button
        driver.findElement(By.xpath(" //a[text()=' Products']")).click();

        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsText = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProductsText.isDisplayed());

        // 6. Enter product name in search input and click search button
        String productName = "POLO";
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search_product']"));
        searchBox.sendKeys(productName);
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();

        // 7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement tshirt = driver.findElement(By.xpath("//img[@alt='ecommerce website products']"));
        Assert.assertTrue("tshirt elementi not displayed!", tshirt.isDisplayed());

        // 8. Verify all the products related to search are visible
        // 8. Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement brands = driver.findElement(By.xpath("//div[@class='brands-name']"));
        Assert.assertTrue("urunler gorunmuyor!", brands.isDisplayed());

    }
}
