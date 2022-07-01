@US01
Feature: Register_User_Functionality
  @register
  Scenario: TC01_register_page (kayit sayfasi)
    When kullanici tarayiciyi baslatir
    Then kullanici anasayfaya gider
    Then ana sayfanin gorunur oldugunu test eder
    Then kullanici signup-login butonuna tiklar
    And kullanici,New User Signup! in gorunur oldugunu test eder

@filldetails
  Scenario: TC02_signup_user (ilk kayit)
    When kullanici olarak isim ve maili girer
    Then signup butonuna tiklar
    Then acilan sayfada ENTER ACCOUNT INFORMATION yazisinn gorunur oldugunu test eder
    Then kullanici ayrintilari (birinci bolum) doldurur
    Then kullanici Sign up for our newsletter! checkbox ini secer
    Then kullanici Receive special offers from our partners! checkbox ini secer
    Then kullanici ayrintilari (ikinci bolum) doldurur
    Then kullanici Create Account butonuna tiklar
    Then kullanici hesabin olustugunu dogrular

@delete
  Scenario: TC03_delete_account (hesap silme)
    When kullanici Continue butonuna tiklar
    Then kullanici oturum actigini dogrulamasi gerekir(Logged in as username)
    Then kullanici Delete Account butonuna tiklar
    Then kullanici hesabin silindigini test eder

