package i13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

// Bir Class olusturun H03
public class H03 extends TestBaseBeforeAfter {

    @Test
    public void test01() {
        //1-“https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2- Headers da bulunan department isimlerini yazdirin
        List<WebElement> depNames = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][6]"));
        depNames.forEach(t -> System.out.println(t.getText()));
        System.out.println("*********************************************");
        //3- sutunun basligini yazdirin
        List<WebElement> headerNames = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        headerNames.forEach(t -> System.out.print(t.getText() + " "));
        System.out.println("*********************************************");
        //4- Tablodaki tum datalari yazdirin
        List<WebElement> tbodyNames = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        tbodyNames.forEach(t -> System.out.print(t.getText()));
        System.out.println("*********************************************");
        //5- Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> tbodyNamesCells = driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("Tablodaki Data Cell Sayisi : " + tbodyNamesCells.size());
        System.out.println("*********************************************");
        //6- Tablodaki satir sayisini yazdirin
        List<WebElement> tbodyRows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki Satir Sayisi : " + tbodyRows.size());
        System.out.println("*********************************************");
        //7- Tablodaki sutun sayisini yazdirin
        List<WebElement> Column = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println("Tablodaki Sutun Sayisi : " + Column.size());
        System.out.println("*********************************************");
        //8- Tablodaki 3.kolonu yazdirin
        List<WebElement> thirdRow = driver.findElements(By.xpath("//div[@class='rt-tr-group'][2]"));
        thirdRow.forEach(t -> System.out.println(t.getText()));
        System.out.println("*********************************************");
        //9- Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        List<WebElement> kierraSalary = driver.findElements(By.xpath("//div[@class='rt-td'][5]"));
        System.out.println(kierraSalary.get(2).getText());
        System.out.println("*********************************************");
        //10- Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
        pageMethod(2, 4);
    }

    private void pageMethod(int row, int column) {
        WebElement specificData = driver.findElement(By.xpath("(//div[@class='rt-td' or role='gridcell'][" + (column - 1) + "])[" + (row - 1) + "]"));
        System.out.println("Actual Data  : " + specificData.getText());
        System.out.println("*********************************************");

    }

}


