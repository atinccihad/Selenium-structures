Feature: US9004 parameter ile stepdefinition olusturma

  Scenario: TC904_parametre kullanimi

  Scenario: TC904 kullanici amazonda kelime aratir
    Then  kullanici "iPhone" icin arama yapar
    And kullanici sonuclarin "iPhone" icerdigini test eder
    And kullanici sayfayi kapatir