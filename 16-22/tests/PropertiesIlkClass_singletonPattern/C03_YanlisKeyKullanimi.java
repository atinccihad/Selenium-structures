package tests.day17;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.lang.annotation.Target;

public class C03_YanlisKeyKullanimi {

    @Test
    public void test01(){

        // Driver.getDriver().get(ConfigReader.getProperty("HMCurl"));

        // eger key olarak girdigimiz String configuration.properties dosyasinda yoksa
        // Ornegin:  HMCUrl yerine HMCurl yazarsak
        // ConfigReader.getProperty()  o key'i bulamaz ve
        // nullPointerException verir..
    }
}
