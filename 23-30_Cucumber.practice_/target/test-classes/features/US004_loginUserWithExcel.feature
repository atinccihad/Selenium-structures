Feature: Login_user_With_Excel

  Scenario: TC06_Login_User_With_Correct_email_and_password_with_Excel
  (Excel kullanarak dogru e-posta ve sifre ile kullanici oturum acma)

    When kullanici tarayiciyi baslatir
    Then kullanici anasayfaya gider
    Then ana sayfanin gorunur oldugunu test eder
    Then kullanici signup-login butonuna tiklar
    Then kullanicinin Login to your account yazisinin gorunur oldugunu test eder
    Then kullanici dogru email ve sifreyi excel ile girer
    Then kullanici login butonuna tiklar
    Then kullanici oturum actigini test eder(Logged in as username)
    Then kullanici logout butonuna basar


  Scenario: TC06_Login_User_With_Wrong_email_and_password_with_Excel
  (Excel kullanarak yanlis e-posta ve sifre ile kullanici oturum acma)

    When kullanici tarayiciyi baslatir
    Then kullanici anasayfaya gider
    Then ana sayfanin gorunur oldugunu test eder
    Then kullanici signup-login butonuna tiklar
    Then kullanicinin Login to your account yazisinin gorunur oldugunu test eder
    Then kullanici yanlis email ve sifreyi excel ile girer
    Then kullanici Your email or password is incorrect! yazisinin goruldugunu test eder

