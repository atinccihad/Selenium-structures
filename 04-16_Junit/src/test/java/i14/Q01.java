package i14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Q01 {

    @Test
    public void excelTesti() throws IOException {
        /*
        input olarak verilen satirNo, sutunNo degerlerini parameter olarak alip
        o cell'deki data'yi bana String olarak donduren bir method olusturun
         */
        int satirNo = 4;
        int sutunNo = 4;

        // donen String'in "Cezayir"  oldugunu test edin
        String expectedData = "Arnavutluk";
        String actualData = banaDataGetir(satirNo - 2, sutunNo - 2);

        Assert.assertEquals(expectedData, actualData);
    }

    private String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData = "";
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData = workbook
                .getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();

        return istenenData;
    }
}
