@db
Feature: US1001 Kullanici Database'e baglanip bilgileri okuyabilir

  Scenario: TC01 Kullanici Database'e baglanip istedigi bilgileri okuyabilmeli

    Given kullanici HMC veri tabanina baglanir
    # Database'e baglanacagiz
    And kullanici "tHOTELROOM" tablosundaki "Price" verilerini alir
    # Query calistiracagiz SELECT price FROM tHOTELROOM
    And kullanici "Price" sutunundaki verileri okur
    # 3. adimda database sorgusu sonunda bize dondurulen bilgiyi nasil kullanabilecegimizi gorecegiz