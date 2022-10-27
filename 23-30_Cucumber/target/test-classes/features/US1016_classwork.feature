Feature: US1016 class work
  Scenario: TC16 alerts and explicitly wait

    Given kullanici "demoqaUrl" anasayfasina gider
    When kullanici Alerts buttonuna tiklar
    And kullanici On button click, alert will appear after bes seconds karsisindaki click me  butonuna basar
    And kullanici Allertin gorunur olmasini bekler
    And kullanici Allert uzerindeki yazinin This alert appeared after bes seconds oldugunu test eder
    And kullanici ok diyerek alerti kapatir