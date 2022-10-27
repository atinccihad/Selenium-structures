Feature: Parametre Kullanimi
  @gp1
  Scenario: TC01Parametre kullaniminda ConfigReader kullanimi
    Given kullanici "amazonUrl" anasayfasina gider
    When Url'in "amazon" icerdigini test edelim
    Then kullanici "Nutella" icin arama yapar
    Then kullanici 3 sn bekler
    And kullanici sayfayi kapatir
  @gp2
  Scenario: TC02Parametre kullaniminda ConfigReader kullanimi
    Given kullanici "bestbuyUrl" anasayfasina gider
    When Url'in "bestbuy" icerdigini test edelim
    Then kullanici 3 sn bekler
    And kullanici sayfayi kapatir
  @gp3
  Scenario: TC03Parametre kullaniminda ConfigReader kullanimi
    Given kullanici "HMCUrl" anasayfasina gider
    When Url'in "hotel" icerdigini test edelim
    Then kullanici 3 sn bekler
    And kullanici sayfayi kapatir
  @gp4
  Scenario: TC04Parametre kullaniminda ConfigReader kullanimi
    Given kullanici "blueRentAcarUrl" anasayfasina gider
    When Url'in "blue" icerdigini test edelim
    Then kullanici 3 sn bekler
    And kullanici sayfayi kapatir
  @gp5
  Scenario: TC01Parametre kullaniminda ConfigReader kullanimi
    Given kullanici "HMCUrl" anasayfasina gider
    When Url'in "hotel" icerdigini test edelim
    Then kullanici 3 sn bekler
    And kullanici sayfayi kapatir

