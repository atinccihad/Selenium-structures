package i03;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class H01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. Tarayıcıyı başlatın -- Launch browser
        //2. 'http://automationexercise.com' url'sine gidin
        //  Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");
        //3. Ana sayfanın başarılı bir şekilde görünür olduğunu doğrulayın(Ana sayfanın başarıyla görüldüğünü doğrulayın)
        // Verify that home page is visible successfully
        WebElement homeTusu = driver.findElement(By.xpath("//a[text()=' Home']"));
        //homeTusu.click();
        if (homeTusu.isDisplayed()) {
            System.out.println("home page is visible successfully");
        } else {
            System.out.println("home page is not visible successfully");
        }
        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        //  Click on 'Signup / Login' button
        WebElement signInLoginButton = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signInLoginButton.click();
        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        // 5. Verify 'New User Signup!' is visible
        WebElement newUserSignUp = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        if (newUserSignUp.isDisplayed()) {
            System.out.println("new user sign up is visible");
        } else {
            System.out.println("new user sign up is visible");
        }
        //6. Adı ve e-posta adresini girin
        //6. Enter name and email address
        WebElement signUpNameAdress = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        signUpNameAdress.sendKeys("chd", Keys.ENTER);
        WebElement signUpEmailAdress = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        signUpEmailAdress.sendKeys("chdddddd@hotmail.com", Keys.ENTER);
        //7. 'Kaydol' düğmesini tıklayın
        //7. Click 'Signup' button
        WebElement signInButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        signInButton.submit();
        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccount = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        if (enterAccount.isDisplayed()) {
            System.out.println("ENTER ACCOUNT INFORMATION' is visible");
        } else {
            System.out.println("ENTER ACCOUNT INFORMATION' is not visible");
        }
        //9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234567", Keys.ENTER);
        driver.findElement(By.xpath("//input[@value='Mr']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).click();
        driver.findElement(By.xpath("//select[@name='days']")).click();
        driver.findElement(By.xpath("//option[@value='10']")).click();
        driver.findElement(By.xpath("//select[@name='months']")).sendKeys("August", Keys.ENTER);
        //driver.findElement(By.xpath("//option[@value='August']")).click();
        driver.findElement(By.xpath("//select[@name='years']")).click();
        driver.findElement(By.xpath("//option[@value='1991']")).click();
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("cihad" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("atinc" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("it" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("tc" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("tc" + Keys.ENTER);
        driver.findElement(By.xpath("//select[@data-qa='country']")).sendKeys("tc" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("555" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("555" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("555" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("5555555555" + Keys.ENTER);
        //13. 'Hesap Oluştur düğmesini' tıklayın
        //13. Click 'Create Account button'
        WebElement createButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        createButton.submit();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //14. 'HESAP OLUŞTURULDU!' görünür
        WebElement accountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        if (accountCreated.isDisplayed()) {
            System.out.println("'HESAP OLUŞTURULDU!' is displayed.");
        } else {
            System.out.println("'HESAP OLUŞTURULDU!' is not displayed.");
        }
        //15. Click 'Continue' button
        //15. 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //16. Verify that 'Logged in as username' is visible
        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement logged = driver.findElement(By.xpath("//b[text()='chd']"));
        if (logged.isDisplayed()) {
            System.out.println("isDisplayed");
        } else {
            System.out.println("notDisplayed!");
        }
        //17. Click 'Delete Account' button
        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@href=\"/delete_account\"]")).click();

        Thread.sleep(4000);
        driver.close();
    }
}
