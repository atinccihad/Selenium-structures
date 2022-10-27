package dbStepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {

    String url = "jdbc:sqlserver://184.168.194.58:1433;databaseName=hotelmycamp ; user=techproed;password=P2s@rt65";
    String username = "techproed";
    String password = "P2s@rt65";
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("kullanici HMC veri tabanina baglanir")
    public void kullanici_hmc_veri_tabanina_baglanir() throws SQLException {
        // database'e baglanti kuruyoruz
        connection = DriverManager.getConnection(url, username, password);
        statement = statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    }

    @Given("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String table, String field) throws SQLException {
        // Query calistiriyoruz
        // SELECT Price From tHOTELROOM
        String readQuery = "SELECT " + field + " From " + table;
        resultSet = statement.executeQuery(readQuery);

    }

    @Given("kullanici {string} sutunundaki verileri okur")
    public void kullanici_sutunundaki_verileri_okur(String field) throws SQLException {

        // resultSet bizim su ana kadar kullandigimiz set yapisinda degildir
        // resultSet iterator ile calisir

        // resultSet'teki bilgileri okumak istiyorsaniz
        // once iterator'u istediginiz yere gondermelisiniz

        resultSet.first(); // bu komut iterator'i ilk elemente goturur gitti ise tru gidemezse false doner

        // istenen konuma gidince artik elemnti yazdirabiliriz

        System.out.println(resultSet.getString(field));

        // ikinci oda fiyatini gormek istersek iterator'u yollamamiz lazim

        resultSet.next();
        System.out.println(resultSet.getString(field));

        System.out.println(resultSet.next()); // true

        System.out.println(resultSet.getString(field)); // result.next() nerede olursa olsun iterator'u bir sonrakine gecirir
        //atama olmamasi veya bir loop'un icinde olmasi iteratorun ilerlemesini etkilemez

        // tum price sutununu yazdirmak istersem
        System.out.println("======================");
        // resultSet ile calisirken iterator konumu kontrol etmek zorundayiz
        // Eger 1. elemana donmeden listeyi yazdirmaya devam edersem
        // kaldigi yerden devam edip 4. elemnt ve sonrasini yazdirir

        resultSet.absolute(1);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(field));
        }

        // price sutununda kaca data oldugunu bulalim
        // while loop ile resultSet.next()  false donunceye kadar gittik
        // dolayisiyla artik iterator sonda

        resultSet.last();
        System.out.println(resultSet.getRow());

        // suanda tum price bilgileri resultSet uzerinde
        // eger bu bilgilerle birden fazla test yapacaksak
        // bu bilgileri java ortamina almakta fayda var
        // ornegin bir List<Double> olusturup
        // tum price verilerini bu listeye ekleyebiliriz
        // boylece bir java objesi olan List sayesinde
        // price degerleri uzerinde istedigimiz testleri yapabiliriz

        resultSet.absolute(0);
        List<Double> priceList = new ArrayList<>();

        while (resultSet.next()) {
            priceList.add(resultSet.getDouble(field));
        }

        System.out.println(priceList);
    }

}
