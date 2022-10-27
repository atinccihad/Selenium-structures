package i13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.c;

// Bir class oluşturun : H02
public class H02 extends TestBaseBeforeAfter {
    // login( ) metodun oluşturun ve oturum açın.
    @Test
    public void login() {
        // https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//button[@id=\"details-button\"]")).click();
        driver.findElement(By.xpath("//a[text()='Proceed to qa-environment.concorthotel.com (unsafe)']")).click();

        // ○ Username : manager  ○ Password : Manager1!
        driver.findElement(By.xpath("//input[@name=\"UserName\"]")).sendKeys("manager" + Keys.TAB + "Manager1!");
        driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();

        // table( ) metodu oluşturun
        table();

        // printRows( ) metodu oluşturun //tr
        printRows();

        // printCells( ) metodu oluşturun //td
        printCells();

        // printColumns( ) metodu oluşturun
        printColumns();


        // Bir metod oluşturun : printData(int row, int column);
        printData(3, 5);


    }

    public void printData(int satir, int sutun) {
        // Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        // hücredeki(cell) veriyi yazdırmalıdır.
        WebElement arananVeri = driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println("Satır(row) ve sütun(column) numarası girilen veri = " + arananVeri.getText());
        System.out.println("=======================================");
    }


    public void printDataTest() {
        // Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
        // Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
        // yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
        int satir = 0;
        int sutun = 0;
        printData(satir, sutun);
    }

    private void printColumns() {
        // ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> column = driver.findElements(By.xpath("//tr[1]//td"));
        System.out.println("Toplam sutun sayisi = " + column.size());
        System.out.println("=======================================");
        // ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        List<WebElement> columnX = new ArrayList<>();
        for (int i = 3; i <= 12; i++) {
            WebElement eklenecek = driver.findElement(By.xpath("(//tr[@role='row'])[" + i + "]//td[" + (i - 2) + "]"));
            columnX.add(eklenecek);
        }
        System.out.println(columnX);

        // ○ 5.column daki elementleri konsolda yazdırın.
    }

    private void printCells() {
        // ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> hucreler = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("table body’sinde bulunan toplam hücre(cell) sayısı= " + hucreler.size());
        System.out.println("=======================================");
        // ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        hucreler.stream().forEach(t -> System.out.println(t.getText()));
        System.out.println("=======================================");
    }

    public void printRows() {
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlar = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi = " + satirlar.size());
        System.out.println("=======================================");
        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println("Satirlar: ");
        satirlar.stream().forEach(t -> System.out.println(t.getText()));
        System.out.println("=======================================");
        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4.satir elementleri: ");
        List<WebElement> we4 = driver.findElements(By.xpath("//tbody//tr[4]"));
        we4.stream().forEach(t -> System.out.println(t.getText()));
        System.out.println("=======================================");
    }

    public void table() {
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunSayisiList = driver.findElements(By.xpath("//thead//td"));
        System.out.println("sutunSayisi = " + sutunSayisiList.size());
        System.out.println("==================");
        // ○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        List<WebElement> tumBodyList = driver.findElements(By.xpath("//tr//td"));
        System.out.println("Tum body listesi:");
        for (WebElement each : tumBodyList) {
            System.out.println(each.getText());
        }
        System.out.println("==================");
        List<WebElement> tumBaslikList = driver.findElements(By.xpath("//th"));
        System.out.println("Tum baslik listesi:");
        tumBaslikList.stream().forEach(t -> System.out.println(t.getText()));

    }


}
