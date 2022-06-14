@Editor
Feature: US1009 Scenario Outline ile editor database sayfasina kayit


  Scenario Outline: TC14 kullanici yeni kayit ekleyebilmeli


    When kullanici editor anasayfaya gider
    Then new butonuna basar
    And firstname olarak "<firstname>" yazar
    And lastname olarak "<lastname>" yazar
    And Position olarak "<position>" yazar
    And 1 saniye bekler
    And Office olarak "<office>" yazar
    And Extension olarak "<extension>" yazar
    And Start date olarak "<startDate>" yazar
    And 1 saniye bekler
    And Salary olarak "<salary>" yazar
    And Create tusuna basar
    And 1 saniye bekler
    When kullanici "<firstname>" ile arama yapar
    Then isim bolumunde "<firstname>" oldugunu dogrular



    Examples:
    |firstname|lastname|position|office|extension|startDate|salary|
    |mehmet   |bulutlu |amele   |amsterdam|amele |2020-01-01|200  |