package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_ReusableRunner {

    @Test
    public void test01(){
        // Ulkeler excel'indeki Sayfa1'de
        // 11.index deki satirin 2.index deki hucresinin Azerbaycan oldugunu test edin.

        String path="src/test/java/resources/ulkeler.xlsx";
        String expectedData="Azerbaycan";
        String actualData=ReusableMethods.hucreGetir(path,"Sayfa1",11,2).toString();

        Assert.assertEquals(actualData,expectedData);
    }
}
