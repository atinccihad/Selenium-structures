Feature:US9003 Background ile amazon testi

  Background: amazon sayfasina gidis
    Given kullanici amazon anasayfasina gider

  Scenario: TC01 kullanici amazonda kelime aratir
    Then  kullanici Nutella icin arama yapar
    And kullanici sonuclarin Nutella icerdigini test eder
   # And kullanici sayfayi kapatir


  Scenario: TC02 kullanici amazonda teapot aratir
    Then  kullanici Selenium icin arama yapar
    And kullanici sonuclarin Selenium icerdigini test eder
    # And kullanici sayfayi kapatir


  Scenario: TC03 kullanici amazonda flower aratir
    Then  kullanici iphone aramasi yapar
    And kullanici sonuclarin iphone icerdigini test eder
    And kullanici sayfayi kapatir