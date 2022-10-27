Feature: Amazon Search
  @gp7
  Scenario: TC01 kullanici amazonda kelime aratir
    Given kullanici amazon anasayfasina gider
    Then  kullanici Nutella icin arama yapar
    And kullanici sonuclarin Nutella icerdigini test eder

    @gp8
  Scenario: TC02 kullanici amazonda kelime aratir
    Given kullanici amazon anasayfasina gider
    Then  kullanici Selenium icin arama yapar
    And kullanici sonuclarin Selenium icerdigini test eder
    # And kullanici sayfayi kapatir
