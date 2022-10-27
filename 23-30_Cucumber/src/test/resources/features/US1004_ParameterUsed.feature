Feature: US1004 Parametre Kullanimi

  Scenario: TC01 Parametre kullanimi
    Given kullanici "hepsiburadaUrl" anasayfasina gider
    Then kullanici 3 sn bekler
    When Url'in "hepsi" icerdigini test edelim
    And kullanici sayfayi kapatir