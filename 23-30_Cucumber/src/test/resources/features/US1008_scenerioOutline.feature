Feature: : US008 BRC

  @BRC
  Scenario Outline: : TC11 kullanici gecersiz bilgilerle giris yapar
    Given kullanici "brcUrl" anasayfasina gider
    Then Login yazisina tiklar
    And "<gecersizEmail>" username girer
    And "<gecersizPass>" password girer
    And brc Login butonuna basar
    Then brc sayfasina giris yapilamadigini kontrol eder
    And kullanici 3 sn bekler
    And  sayfayi kapatir

    Examples: :
  | gecersizEmail   | gecersizPass |
  |a@gmail.com      |    12346|
  |b@gmail.com      |    13246|
  |c@gmail.com      |    78974|
  |d@gmail.com      |    78564|
  |e@gmail.com      |    41454|