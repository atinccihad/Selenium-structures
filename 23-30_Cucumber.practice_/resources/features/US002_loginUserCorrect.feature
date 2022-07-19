Feature: Login_user_correct
@login
  Scenario: TC04_Login_User_With_Correct_email_and_password
            (Dogru e-posta ve sifre ile kullanici oturum acma)

    When kullanici tarayiciyi baslatir
    Then kullanici anasayfaya gider
    Then ana sayfanin gorunur oldugunu test eder
    Then kullanici signup-login butonuna tiklar
    Then kullanicinin Login to your account yazisinin gorunur oldugunu test eder
    Then kullanici dogru email ve sifreyi girer
        |email|password|
        |practicebatch44@gmail.com| 123456|
    Then kullanici login butonuna tiklar
    Then kullanici oturum actigini test eder(Logged in as username)
    Then kullanici logout butonuna basar

