Feature: US1007 Scenario Outline

  Scenario Outline: TC12 amazonda bir listedeki tum elementleri aratma

    Given kullanici amazon sayfasina gider
    Then "<aranacakEleman>" icin arama yapar
    And sonuclarin "<aranacakEleman>" icerdigini test eder





    Examples:
    |aranacakEleman|
    |Apple|
    |Java |
    |Samsung|
    |Armut  |
    |nutella|