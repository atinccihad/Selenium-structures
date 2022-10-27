package i15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class H01 extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() throws IOException {
        // 1.satirdaki 2.hucreye gidelim ve yazdiralim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println("==================================================");
        // 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String row1Cell2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("row1Cell2 = " + row1Cell2);
        System.out.println("==================================================");
        // 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualBaskent = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedBaskent = "Kabil";
        Assert.assertEquals(expectedBaskent, actualBaskent);
        // Satir sayisini bulalim
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum() + 1;
        System.out.println("satirSayisi= " + satirSayisi);
        System.out.println("==================================================");
        // Fiziki olarak kullanilan satir sayisini bulun
        int fizikiSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("fizikiSatirSayisi=" + fizikiSatirSayisi);
        System.out.println("==================================================");
        // Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Sheet sheet = workbook.getSheet("Sayfa1");
        int rowCount = sheet.getLastRowNum();

        Map<String, String> mapList = new LinkedHashMap<>();
        for (int i = 0; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            Cell keyCell = row.getCell(0);
            String key = keyCell.getStringCellValue();
            Cell valuCell = row.getCell(1);
            String value = valuCell.getStringCellValue();
            mapList.put(key, value);
        }

    }


}
