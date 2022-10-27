Feature: Parametre ile istenen sayfaya gitme

  Background: sayfayi kapatma
    Given kullanici amazon anasayfasina gider

  Scenario: TC905 Eski usul amazona gitme
    Then kullanici sayfayi kapatir

    Scenario: TC905 parametre ile istenen sayfaya gitme
      Given kullanici "amazonUrl" sayfasina gider
      Then kullanici sayfayi kapatir
