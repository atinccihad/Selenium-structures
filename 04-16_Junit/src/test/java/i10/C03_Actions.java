package i10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() {
        // - Amazon sayfaasina gidelim
        driver.get("https://www.amazon.com");

        // - Account menusunden create a list linkine tiklayalim
        WebElement accountList = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        /*
        Bir web sitesinde, mouse ile acilan bir webelementine ulasmak istersek,
        actions.moveToElement() methodunu kullanmamiz gerekir,
        aksi takdirde html kodlari arasinda webelementi bulur fakat ulasamadigi icin exception verir...
         */
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();


    }
}
