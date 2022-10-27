@all
Feature: US1007 Scenario Outline Kullanimi

  Scenario Outline: TC1007 ConfigReader ile Scenario Outline kullanimi
    Given kullanici  "<arananUrl>" adresine gider
    Then kullanici 3 sn bekler
    When URL'nin "<arananKelime>" icerdigini test eder
    And kullanici sayfayi kapatir

    Examples:
      | arananUrl   | arananKelime |
      | amazonUrl   | amazon       |
      | facebookUrl | facebook     |
      | bestbuyUrl  | bestbuy      |
      | morhipoUrl  | morhipo      |