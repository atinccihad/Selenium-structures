package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target\\cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@practiceForm", // iki tagi calistirmak isterseniz "@tagname1  or  @tagname2"

        dryRun = false
)

public class Runner {
    /*
    Runner class'i TestNG'deki XML mantigi ile calisir.
    Calistirmak istedigimiz senaryolara tag belirtilir ve
    belirttigimiz taglari calistirir. Yani XML deki gibi
    istedigimiz testleri calistirmak icin kullaniriz.
    Runner class body'si bostur ve runner class'ini
    ekleyecegimiz notasyonlar aktive eder.Bu class'ta
    kullanacagimiz iki adet notasyon vardir. Birincisi
    @RunWith(Cucumber.class) notasyonu Runner class'ina calisma
    ozelligi ekler. Bu notasyon oldugu icin cucumber
    frameworkumuzde JUnit kullanmayi tercih ederiz.
    @CucumberOptions notasyonu icinde
    features : Runner dosyasinin feature dosyasini
    nereden bulacagini tarif eder.
    glue : stepDefinitions yolunu belirtiriz.
    tags : Hangi tag'i calistirmak istiyorsak onu belli eder.
    dryRun: iki secenek vardir.
    dryRun = true; dersek testimizi calistirmadan eksik
    adimlari bize verir.
    dryRun = false; testlerimizi driver ile calistirir.
     */
}
