package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)  // bu notasyon nedeniyle JUnit kullaniriz
@CucumberOptions(
        plugin={"html:target\\cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml" },
        //HTML rapor almak icin plugin eklememiz yeterlidir.. runner dan calistirirsak rapor verir

        // 1- bu notasyonun gorevi feature dosyalari ile stepdefinition dosyalarini birlestirmek
        features="src/test/resources/features",
        glue="stepdefinitions",
        // boylece package'lari birbirine bagliyoruz
        // bu iki paket altinda kactane class olursa olsun,
        // herhangi bir class'da yazilan her adim diger class'lardaki adimlarla uyusursa yeni adim olusturmaya gerek kalmaz

        tags="@login", // work in progress (@wip)
        // 2-  @ testNG'degi group gibi calisir
        // eger sadece 1 Feature veya 1 Scenario calistiracaksak, gidip feature dosyasindan calistirabiliriz
        // birden fazla Feature veya Scenario calistirmak istedigimizde
        // calistiracagimiz Feature veya Scenario 'lara ortak bir tag atamamiz ve bu tag'i
        // runner'da belirtmemiz gerekir
        // and dendiginde yazilan taglarin tamamini tasiyanlar calistirilir
        // or dendiginde yazilan taglardan herhangi birine yada daha fazlasina sahip olanlar calisir
        // butun test caseleri calistirmak icin hicbir tag belirtmeye gerek yoktur, tag i yorum haline getirmek yeterlidir..(21.satir)
        // belirli bir tag belirtilirse bir kisitlama soz konusu olur


        dryRun=true //tagname ekleyip bu sayfadan calistirinca false olmalidir..
        // 3- dryRun-> true oldugunda test caseleri calistirmayi denemeden sadece eksik olan stepleri bana verir
        // dryRun-> false oldugunda test caseleri calistirmayi dener eksik step bulursa onu rapor eder

)


public class Runner {

}
