package tests.crossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

import java.util.List;

public class C01_Dropdown extends TestBaseCross {

    @Test
    public void dropdownTesti() throws InterruptedException {
        // Dropdown'da var olan seceneklerden birini secmek icin
        // 1. adim Dropdown webelementini locate edip bir degiskene atiyoruz
        driver.get("https://www.amazon.com");
        WebElement dropdownElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2. adim : Select class'indan bir obje olusturalim
        // ve parametre olarak locate ettigimiz Webelementi yazalim

        Select select = new Select(dropdownElementi);

        // 3. adim select objesini kullanarak, Select class'inda var olan 3 secim method'undan
        // istedigimizi kullanarak dropdown'da var olan option'lardan birini secebiliriz
        // secim yapmamiza yardim eden bu 3 method void dir dolayisiyla bize bişey dondurmezler

        select.selectByIndex(3);

        // eger sectigimiz option degerini yazdirmak istersek
        System.out.println(select.getFirstSelectedOption().getText()); // Baby

        Thread.sleep(3000);

        select.selectByVisibleText("Deals");

        Thread.sleep(3000);

        select.selectByValue("search-alias=arts-crafts-intl-ship");

        List<WebElement> optionList = select.getOptions();

        for (WebElement each : optionList) {
            System.out.println(each.getText());
        }

    }

}
