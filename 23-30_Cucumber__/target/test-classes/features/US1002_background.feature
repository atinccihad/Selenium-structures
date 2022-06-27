@paralel2
Feature: US1002 Background ile amazon testi

  Background: amazon sayfasina gidis
    Given kullanici amazon sayfasina gider
    # ile yorum yazilir

  @wip
Scenario:  TC02_Amazon iPhone Search testi

    Given kullanici amazon sayfasina gider
    And iPhone icin arama yapar
    Then sonuclarin iPhone icerdigini test eder

    @wip
  Scenario:  TC02_Amazon tea pot Search testi
    Given kullanici amazon sayfasina gider
    And tea pot icin arama yapar
    Then sonuclarin tea pot icerdigini test eder

  @toplu
  Scenario: TC03_Amazon tea pot Search Testi
    And tea pot icin arama yapar
    Then sonuclarin tea pot icerdigini test eder

  Scenario:  TC04_Amazon flower Search testi
    Given kullanici amazon sayfasina gider
    And flower icin arama yapar
    Then sonuclarin flower icerdigini test eder