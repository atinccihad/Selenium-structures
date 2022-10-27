Feature: US1002 Parametre kullanimi

@parametre @paralel2
  Scenario: TC01 Kullanici amazonda parametreli arama yapar
    Given kullanici amazon anasayfasina gider
    Then kullanici "Nutella" icin arama yapar
    And  kullanici sonuclarin "Nutella" icerdigini test eder
    And kullanici sayfayi kapatir

  Scenario: TC02 Kullanici amazonda parametreli arama yapar
    Given kullanici amazon anasayfasina gider
    Then kullanici "selenium" icin arama yapar
    And  kullanici sonuclarin "selenium" icerdigini test eder
    And kullanici sayfayi kapatir

  Scenario: TC03 Kullanici amazonda parametreli arama yapar
    Given kullanici amazon anasayfasina gider
    Then kullanici "java" icin arama yapar
    And  kullanici sonuclarin "java" icerdigini test eder
    And kullanici sayfayi kapatir

  Scenario: TC04 Kullanici amazonda parametreli arama yapar
    Given kullanici amazon anasayfasina gider
    Then kullanici "SQL" icin arama yapar
    And  kullanici sonuclarin "SQL" icerdigini test eder
    And kullanici sayfayi kapatir