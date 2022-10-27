package i11_i09_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q04 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Navigate to: https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        // Enter the user name: standard_user
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys("standard_user");
        // Enter the password: secret_sauce
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys("secret_sauce");
        // Click on login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //    T1 : Choose price low to high
        WebElement dd = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(dd);
        select.selectByVisibleText("Price (low to high)");
        Thread.sleep(3000);
        String expected = "PRICE (LOW TO HIGH)";
        String actual = driver.findElement(By.className("active_option")).getText();

        Assert.assertEquals(expected, actual);
        Thread.sleep(3000);

    }

    @Test
    public void test02() {
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys("standard_user");
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement dd = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(dd);
        select.selectByVisibleText("Price (low to high)");

        //    T2 : Verify item prices are sorted from low to high with soft Assert
        List<WebElement> fiyatlar = driver.findElements(By.className("inventory_item_price"));
        ArrayList<Double> fiyatlarDouble = new ArrayList<>();
        // String fiyatStr=fiyat.getText().replaceAll("$","");
        for (WebElement fiyat : fiyatlar) {
            String fiyatStr = fiyat.getText().replaceAll("^\\D", "");
            fiyatlarDouble.add(Double.parseDouble(fiyatStr));
        }

        ArrayList<Double> kontrolList = new ArrayList<>(fiyatlarDouble);
        Collections.sort(kontrolList);

        Assert.assertEquals(kontrolList, fiyatlarDouble);
    }
}
