Feature: US9002 assertion
 @ninja
  Scenario: kullanici http://tutorialsninja.com/demo/index.php?route=common/home sayfasına gidiniz

 Given tutorialsninjaUrl sayfasına gidiniz
 Then Phones & PDAs'a tıklayınız
 Then Telefonların markalarını alınız
 When Tüm öğeleri sepete ekleyiniz
 Then Sepete tıklayınız
 When Sepetteki isimleri alınız
 And  Sepetteki ve sayfadaki ürünlerin doğru olduğunu karşılaştırınız