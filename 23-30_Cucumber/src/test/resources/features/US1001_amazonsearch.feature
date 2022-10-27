@All
Feature: Amazon Search

  @gp1
  Scenario: TC01 kullanici amazonda kelime aratir
    Given kullanici amazon anasayfasina gider
    Then  kullanici Nutella icin arama yapar
    And kullanici sonuclarin Nutella icerdigini test eder
   # And kullanici sayfayi kapatir

  @gp3
  Scenario: TC02 kullanici amazonda kelime aratir
    Given kullanici amazon anasayfasina gider
    Then  kullanici Selenium icin arama yapar
    And kullanici sonuclarin Selenium icerdigini test eder
    # And kullanici sayfayi kapatir

  @gp2
  Scenario: TC03 kullanici amazonda kelime aratir
    Given kullanici amazon anasayfasina gider
    Then  kullanici iphone aramasi yapar
    And kullanici sonuclarin iphone icerdigini test eder
    And kullanici sayfayi kapatir
