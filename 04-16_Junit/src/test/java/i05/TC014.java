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

public class TC014 {
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

        //4. Add products to cart
        //4. Sepete ürün ekle
        WebElement rs400 = driver.findElement(By.xpath("(//h2[text()='Rs. 400'])[1]"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(rs400).perform();
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
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();


        //5. Click 'Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

        //6. Verify that cart page is displayed
        WebElement cart = driver.findElement(By.xpath("//a[@href='/view_cart']"));
        Assert.assertTrue("Cart page is not displayed!", cart.isDisplayed());

        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();

        //9. Fill all details in Signup and create account
        //9. Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("tester" + Keys.TAB);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("tester@tester.qa" + Keys.TAB);
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("tester@tester.qa");


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).click();
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("tester");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).submit();

        // driver.findElement(By.xpath("//input[@type='password']")).sendKeys("tester");
        // driver.findElement(By.xpath("//select[@data-qa='days']")).sendKeys("12");
        // driver.findElement(By.xpath("//select[@data-qa='months']")).sendKeys("March");
        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//select[@data-qa='years']")).sendKeys("1988");
        // Thread.sleep(3000);
        // WebElement firstName =driver.findElement(By.xpath("//input[@data-qa='first_name']"));
        // actions.scrollToElement(firstName).perform();
        // firstName.sendKeys("tester"+Keys.TAB);
        // driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("tester"+Keys.TAB);
        // driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("tester"+Keys.TAB);
        // driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("testerStreet"+Keys.TAB);
        // driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("testerStreet2"+Keys.TAB);
        // WebElement createAccount = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        // actions.scrollToElement(createAccount).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // river.findElement(By.xpath("//select[@id='country']")).sendKeys("Singapore"+Keys.TAB);
        // hread.sleep(3000);
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("state"+Keys.TAB);
        // driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("city"+Keys.TAB);
        // driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("zipcode"+Keys.TAB);
        // driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("555555555"+Keys.TAB);
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // actions.sendKeys(Keys.ARROW_DOWN).perform();
        // createAccount.submit();
        // driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //11. Verify ' Logged in as username' at top
        //11. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//b[text()='tester']"));
        Assert.assertTrue("loggedInAsUsername not displayed!", loggedInAsUsername.isDisplayed());

        //12.Click 'Cart' button
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[1]")).click();

        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        //14. Verify Address Details and Review Your Order
        //14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        WebElement adresAyrintilari = driver.findElement(By.xpath("(//div[@class='container'])[2]"));
        Assert.assertTrue("adresAyrintilari is not displayed!", adresAyrintilari.isDisplayed());
        Thread.sleep(3000);

        //15. Enter description in comment text area and click 'Place Order'
        //15. Yorum metni alanına açıklama girin ve 'Sipariş Ver'i tıklayın
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("YorumMetni......");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("sendName" + Keys.TAB);
        driver.findElement(By.xpath("//input[@class='form-control card-number']")).sendKeys("11111111");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("571");
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("03");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("1988");

        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@class=\"form-control btn btn-primary submit-button\"]")).submit();

        //18. Verify success message 'Your order has been placed successfully!'
        WebElement congratulations = driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue("Congratulations is not displayed!", congratulations.isDisplayed());

        //19. Click 'Delete Account' button
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement deleteAccount = driver.findElement(By.xpath("//title[text()='Delete Account – Django REST framework']"));
        Assert.assertTrue("Account not deleted!", deleteAccount.isDisplayed());

    }
}
