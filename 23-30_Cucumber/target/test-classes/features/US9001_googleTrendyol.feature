Feature:  google trendyol

  Scenario: TC9001 kullanici google'a gider

    Given Google'a gidiniz
   Then "trendyol" u aratiniz
   And trendyol linkini bulup siteye gidiniz
   And "makas" aratınız
   Then toplam ürün sayısıni alınız
   And yeni sekmede "morhipo" ya gidiniz
   Then makas aratınız
   And toplam ürün sayısını alınız
   And iki sitedeki toplam makas sayısını karşılastırınız
   And Önce ürün sayısı fazla olan siteyi kapatınız
   When Sonra diğer sayfayıda kapatınız