package i14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_readExcel {
    @Test
    public void readExcelTest01() throws IOException {
        /*
        - Belirtilen satirNo ve sutunNo degerlerini parametre olarak alip
         o cell'deki datayi konsola yazdirin
        - Sonucun konsolda yazanla ayni oldugunu dogrulayin.
         */
        int satir = 12;
        int sutun = 2;

        // - Belirtilen satirNo ve sutunNo degerlerini parametre olarak alip o cell'deki datayi konsola yazdirin
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData = workbook
                .getSheet("Sayfa1")
                // index 0'dan basladigi icin bizden istedigi dataya ulasabilmek icin girilen degerlerin 1 eksigini aliriz.
                .getRow(satir - 1)
                .getCell(sutun - 1)
                .toString();
        System.out.println("actualData = " + actualData);

        // - Sonucun konsolda yazanla ayni oldugunu dogrulayin.
        String expectedData = "Baku";
        Assert.assertEquals(expectedData,actualData);

    }
}
