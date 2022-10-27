Feature:Class Calismasi

  Scenario Outline:
    When kullanici "dataUrl" adresine gider
    Then  new butonuna basar
    And isim bolumune "<firstname>" girer
    Then kullanici 1 sn bekler
    And soyisim bolumune "<lastname>" girer
    Then kullanici 1 sn bekler
    And position bolumune"<position>" girer
    Then kullanici 1 sn bekler
    And ofis bolumune "<ofisbilgisi>" girer
    Then kullanici 1 sn bekler
    And extension bolumune "<extension>" girer
    Then kullanici 1 sn bekler
    And startdate bolumune"<Stardate>"  girer
    Then kullanici 1 sn bekler
    And salary bolumune "<Salary>" girer
    And Create tusuna basar
    When kullanici "<firstname>" ile arama yapar
    Then isim bolumunde "<firstname>" oldugunu dogrular
    Examples:
      | firstname | lastname | position | ofisbilgisi | extension | Stardate   | Salary |
      | ALi       | Veli     | Qa       | Google      | Senior    | 2022-10-12 | 15000  |
      | Ahmet     | Mehmet   | Qa       | Google      | Junior    | 2022-10-12 | 10500  |
      | Hasan     | Duman    | Dev      | Amazon      | Junior    | 2022-10-12 | 25000  |
      | Akin      | Alkan    | Dev      | Amazon      | Senior    | 2022-10-12 | 50000  |
      | Orhan     | Duman    | PO       | WallMart    | Senior    | 2022-10-12 | 30000  |

    #5 farkli kullanici bilgisi girer