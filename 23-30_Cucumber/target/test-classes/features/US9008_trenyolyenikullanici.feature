Feature: Trenyol alisveris tesiti
  Scenario:  Urunler sepete eklendikten sonra odeme sayfasina gidebilmeli

    Given kullanici "trendyolUrl" anasayfaya gider
    Then cerezleri kabul eder
    Then trendyol ana sayfasindaki giris yap butonuna tiklar
    Then eposta ve sifre boxlarini doldurur ve giris yapar
    And  ELEKTRONIK basligi altinda Bilgisayar & Tablet basligina tiklar
    And sol taraftaki ilgili kategoriler'den  "Bilgisayar" secer
    And  sol tarafta marka kategorisi altinda "Apple" i secer
    Then ilk urune tiklar
    Then kullanici urunu incelemek icin urun fotografi uzerine mouse'la gider
    And urun fotografinin altindaki urunun diger forograflarini inceler
    And urunu sepete ekler
    And Sepeti onaylar
    And test adresi radio butonunun secili oldugunu dogrular
    And kaydet ve devam et butonuna tiklar
    And odeme secekleri sayfasinda oldugunu dogrular
    And kart bilgilerini girer
    And Lutfen belirtilen lanlari kontrolediniz uyarisini dogrular
    And Siparis ozeti alaninin ekran resmini alir
    And Sayfayi kapatir
