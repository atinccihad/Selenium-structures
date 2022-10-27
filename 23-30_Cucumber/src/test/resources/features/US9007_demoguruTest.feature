Feature: demo adresine gidip sutun basligi ile liste alma

  Scenario: TC9007 kullanici sutun basligi ile liste alabilmeli

    Given kullanici "demoGuruUrl" anasayfaya gider
    And   "Company" sutunundaki tum degerleri yazdirir
  #sutun ismini yazdiginda sutunundaki degerleri getirir
    Then kullanici sayfayi kapatir