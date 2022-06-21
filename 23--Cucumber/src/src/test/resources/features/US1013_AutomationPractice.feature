Feature: US1013 Invalid email testi

  @Automation
  Scenario: TC18 Invalid email ile giris yapilamaz

    Given kullanici "AutomationPracticeUrl" sayfasina gider
    And user sign in linkine tiklar
    And email kutusuna @isareti olmayan email adres yazar ve enter'a tiklar
    Then error mesajinin "Invalid email address" oldugunu dogrulayin
    