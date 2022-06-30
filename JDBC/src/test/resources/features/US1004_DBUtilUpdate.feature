Feature: US1004 Kullanici kayitlari update eder

  Scenario: TC04 Kullanici IDHotel degeri verilen Email'i Update edebilmeli
    Given kullanici DBUtil ile HMC veri tabanina baglanir
    Then tHotel tablosunda IDHotel degeri 1016 olan kaydin Email bilgisini "hoscakal@gmail.com" yapar
