package org.example.repository;

import org.example.entity.Musteri;
import org.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusteriRepository {

    DBConnection dbConnection;
    // nesne üretme işlemi constructor içinde yapılır.
    public MusteriRepository(){
        dbConnection=new DBConnection();
    }

    public void saveMusteri(String ad, String soyad){
        // sql sorgusu yazılır.
        String sql="insert into musteri(ad,soyad) values(?,?)";

        // köprü oluşturulur.
        Connection connection=dbConnection.openConnection();

        // taşıyıcıya verilir.
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1,ad);
            p.setString(2,soyad);
            p.executeUpdate();
            System.out.println("Müşteri başarıyla kaydedildi.");
        } catch (SQLException e) {
            System.out.println("PreparedStatement oluşturulurken hata alındı: " + e.getMessage());
        }
        // açılan bağlantı kapatılır.
        finally {
            dbConnection.closeConnection(connection);
        }

    }

    public Musteri idYeGoreMusteriGetir(Long id){
        // sql sorgusu yazılır.
        String sql="select * from musteri where id=?";
        // köprü oluşturulur.
        Connection connection=dbConnection.openConnection();
        // boş bir müşteri nesnesi oluşturulur.
        Musteri musteri= new Musteri();
        try {
            // taşıyıcıya verilir.
            PreparedStatement p=connection.prepareStatement(sql);
            p.setLong(1,id);
            // executeQuery geriye result set döner.
            ResultSet resultSet=p.executeQuery();
            // databaseden gelen veriler result set içinde döner ve boş olan müşteri nesnesine set edilir.
            while(resultSet.next()){
                Long gelenId=resultSet.getLong("id");
                String gelenAd=resultSet.getString("ad");
                String gelenSoyad=resultSet.getString("soyad");
                musteri.setId(gelenId);
                musteri.setAd(gelenAd);
                musteri.setSoyad(gelenSoyad);
            }
        } catch (SQLException e) {
            System.out.println("preparedStatement oluşturulurken hata alındı: " + e.getMessage());
        }
        return musteri;
    }

    public List<Musteri> tumMusterileriGetir(){
        // ilk olarak sql sorgusu yazılır.
        String sql="select * from musteri";
        // köprü oluşturulur.
        Connection connection=dbConnection.openConnection();
        // taşıyıcıya verilir.
        // gelen verilerin saklanacağı liste oluşturulur.
        List<Musteri> musteriList= new ArrayList<>();
        try {
            PreparedStatement p=connection.prepareStatement(sql);
            ResultSet resultSet=p.executeQuery();
            // result set içindeki veriler gezilir.
            while(resultSet.next()){
                // Müşteri nesnesi oluşturulur ve set edilir.
                Musteri musteri=new Musteri();
                Long gelenId=resultSet.getLong("id");
                String gelenAd=resultSet.getString("ad");
                String gelenSoyad=resultSet.getString("soyad");

                musteri.setId(gelenId);
                musteri.setAd(gelenAd);
                musteri.setSoyad(gelenSoyad);
                // müşteri nesnesi listeye eklenir.
                musteriList.add(musteri);
            }
        } catch (SQLException e) {
            System.out.println("PreparedStatement oluşturulurken hata alındı: " + e.getMessage());
        }
        return musteriList;
    }
}
