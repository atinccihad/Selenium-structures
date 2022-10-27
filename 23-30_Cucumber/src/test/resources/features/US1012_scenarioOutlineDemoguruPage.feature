Feature: Demo adresine gidip sutun basligi ile liste alma
@demoguru
  Scenario Outline: TC9007 kullanici sutun basligi ile liste alabilmeli

    Given kullanici "demoGuruUrl" anasayfaya gider
And   "<Basliklar>" sutunundaki tum degerleri yazdirir
  Examples:
    | Basliklar  |
    | Company    |
    | Group      |
    | Prev Close |
    | Basliklar  |

  Scenario: Kullanici sayfayi kapatir
    Given kullanici sayfayi kapatir
