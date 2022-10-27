@Background  @paralel1
Feature: US1002 Background Used

  Background: Ortak adimlar
    Given kullanici amazon anasayfasina gider

  Scenario: TC01 kullanici amazonda kelime aratir
    Then  kullanici Nutella icin arama yapar
    And kullanici sonuclarin Nutella icerdigini test eder


  Scenario: TC02 kullanici amazonda kelime aratir
    Then  kullanici Selenium icin arama yapar
    And kullanici sonuclarin Selenium icerdigini test eder


  Scenario: TC03 kullanici amazonda kelime aratir
    Then  kullanici iphone aramasi yapar
    And kullanici sonuclarin iphone icerdigini test eder
    And kullanici sayfayi kapatir
