@Editor
Feature: US9006 Scenerio Outline ile editor sayfasina kayit

  Scenario :TC9006 yeni kayit ekleyebilmeli

    When kullanici  "https://editor.datatables.net" adresine gider
    Then new butonuna basar
    And firstname olarak "<firstname>" yazar
    And lastname olarak "<lastname>" yazar
    And position olarak "<position>" yazar
    And office olarak "<office>" yazar
    And extension olarak "<extension>" yazar
    And startDate olarak "<startDate>" yazar
    And salary olarak "<salary>" yazar
    And Create tusuna basar
    When kullanici "<firstname>" ile arama yapar
    When isim bolumunde "<firstname>" oldugunu dogrular


