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

import java.time.Duration;

public class TC001 {

    WebDriver driver;

    @Before
    public void setUp() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testCase1() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Ana sayfanın başarıyla görünür olduğu doğrulandi");
        } else {
            System.out.println("Ana sayfanın başarıyla görünür olduğunu doğrulanamadi!!");
        }

        //4. Click on 'Signup / Login' button
        driver.findElement(By.linkText("Signup / Login")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignUp = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        if (newUserSignUp.isDisplayed()) {
            System.out.println("New User Signup!  texti gorunuyor");
        } else {
            System.out.println("New User Signup!  texti gorunmuyor!!");
        }

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ddddd" + Keys.TAB);
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("dddd@ddd.com" + Keys.TAB);

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[text()='Signup']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccounInformation = driver.findElement(By.xpath("(//b)[1]"));
        if (enterAccounInformation.isDisplayed()) {
            System.out.println("ENTER ACCOUNT INFORMATION  text is diplayed");
        } else {
            System.out.println("ENTER ACCOUNT INFORMATION  text not diplayed");
        }

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@id='id_gender1']")).submit();
        driver.findElement(By.xpath("(//input[@type='password'])")).sendKeys("1234" + Keys.TAB);
        driver.findElement(By.xpath("(//div[@class='selector'])[1]")).sendKeys("12" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='selector'])[2]")).sendKeys("March" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='selector'])[3]")).sendKeys("1988" + Keys.ENTER);

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).sendKeys(Keys.TAB);

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("ali" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("can" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("sss" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("sss" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("sss" + Keys.TAB);
        driver.findElement(By.xpath("//select[@id='country']")).sendKeys("C" + Keys.ENTER);
        driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("35");
        driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("35");
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("35");
        driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("35");
        driver.findElement(By.xpath("(//button[@data-qa='create-account'])")).click();

        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        //16. Verify that 'Logged in as username' is visible
        WebElement loggedAsUsername = driver.findElement(By.xpath("//b[text()='kljd']"));
        Assert.assertTrue(loggedAsUsername.isDisplayed());

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    }

}
