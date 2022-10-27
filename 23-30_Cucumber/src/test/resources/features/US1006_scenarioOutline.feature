Feature: US1006 Kulanici amazonda istedigi kelimeleri aratir

  Scenario Outline:TC1006 Kullanici istedigi kelimeleri aratir

    Given kullanici amazon anasayfasina gider
    Then kullanici "<istenenKelime>" icin arama yapar
    And kullanici sonuclarin "<istenenKelimeKontrol>" icerdigini test eder
    And kullanici sayfayi kapatir

    Examples:
      | istenenKelime | istenenKelimeKontrol |
      | nutella       | nutella              |
      | selenium      | selenium             |
      | sql           | sql                  |

     #TestNG deki dataProvider kullanimindaki gibi Cucumberda da    Scenario Outline kullaniriz
     #Bu sekilde birden fazla kelimeyi tek seferde aratabiliriz
     #Feature dosyasinda yazdigimiz komutta eger "" (Tirnak) kullanirsak stepDefinition da parametreli
     #bir method olusturur.Ve artik stepDefiniton'i kullanmadan Feature dosyasinda ""(Tirnak)
     #icindeki string'idegistirerek istedigim kelimeyi aratabilirim .
     #Scenario Outline da ise yine ""(Tirnak) icinde birden fazla kelime aratacaksam  "<>" seklindeki kullanim
     # ile "<>" icine yazdigim  herhangi bir kelimeyi  Scenario Outline'in asagida olusturdugu Examples
     #altinda aratmak istedigim kelimeleri yazar ve sirasiyla aratabiliriz
















