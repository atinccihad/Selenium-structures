Feature: US1014 Dinamik Elemanlar
  @Dinamik
  Scenario: TC19 Dinamik elementler tiklanabilmeli
    Given kullanici "DemoQaUrl" sayfasina gider
    Then Will enable 5 seconds butonunun enable olmasini bekler
    And Will enable 5 seconds butonunun enable oldugunu test eder