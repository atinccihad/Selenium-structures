Feature: Login_user_correct with Scenario Outline

  Scenario Outline: TC05_Login_User_With_Correct_email_and_password_used_by_Scenario_Outline
                    (Scenario_Outline kullanarak dogru e-posta ve sifre ile kullanici oturum acma)

    When kullanici tarayiciyi baslatir
    Then kullanici anasayfaya gider
    Then ana sayfanin gorunur oldugunu test eder
    Then kullanici signup-login butonuna tiklar
    Then kullanicinin Login to your account yazisinin gorunur oldugunu test eder
    Then kullanici dogru email "<email_address>" ve sifreyi "<password>" girer
    Then kullanici login butonuna tiklar
    Then kullanici oturum actigini test eder(Logged in as username)
    Then kullanici logout butonuna basar

    Examples:
      |email_address  |password|
      |practicebatch44@gmail.com|123456|