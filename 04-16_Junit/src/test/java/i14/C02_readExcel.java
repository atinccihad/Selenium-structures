package i14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_readExcel {
    @Test
    public void test01() throws IOException {
        // - Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        // - FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); // olusturmus oldugumuz dosyayi sistemde isleme alir.

        // - Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // - WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); // workbook objesiyle fis objesi ile akisa aldigimiz dosyamizda bir excell dosyasi create ettik

        // - Sheet objesi olusturun workbook.getSheetAt(index)
        // - Row objesi olusturun sheet.getRow(index)
        // - Cell objesi olusturun row.getCell(index)
        String actualData = workbook
                .getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();
        System.out.println("actualData = " + actualData);
    }
}
