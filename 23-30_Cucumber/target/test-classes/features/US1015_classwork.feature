Feature: US1015 Kullanici giris testi
  Scenario: Kullanici sitede hesap olusturur


    Given kullanici "automationpracticeUrl" anasayfasina gider
    And kullanici 3 sn bekler
    And Kullanici sign in linkine tiklar
    And kullanici 3 sn bekler
    And Kullanici Create and account bölümüne email adresi girer
    And Create an Account butonuna basar
    And Kullanici kisisel bilgilerini ve iletisim bilgilerini girer  And user Register butonuna basar
    And Kullanici Register butonuna basar
    Then Kullanicin hesap olusturuldugunu dogrulayin
    And Sayfayi kapatir













