Feature:Class Calismasi
  Scenario Outline:
    When kullanici "datatablesUrl" adresine gider
    Then  new butonuna basar
    And isim bolumune "<firstname>" girer
    And soyisim bolumune "<lastname>" girer
    And position bolumune"<position>" girer
    And ofis bolumune "<ofisbilgisi>" girer
    And extension bolumune "<extension>" girer
    And startdate bolumune"<Stardate>"  girer
    And salary bolumune "<Salary>" girer
    And Create tusuna basar
    When kullanici "<firstname>" ile arama yapar
    Then isim bolumunde "<firstname>" oldugunu dogrular
    Examples:
      | firstname | lastname | position | ofisbilgisi | extension | Stardate   | Salary |
      | ALi       | Veli     | Qa       | Google      | Senior    | 20.2.2022  | 15000  |
      | Ahmet     | Mehmet   | Qa       | Google      | Junior    | 10.1.2021  | 10500  |
      | Hasan     | Duman    | Dev      | Amazon      | Junior    | 11.12.2020 | 25000  |
      | Akin      | Alkan    | Dev      | Amazon      | Senior    | 12.5.2009  | 50000  |
      | Orhan     | Duman    | PO       | WallMart    | Senior    | 6.6.2006   | 30000  |
    #5 farkli kullanici bilgisi girer













