package org.example.service;

import org.example.entity.Musteri;

import java.util.List;

public interface IMusteriService {

    void musteriEkle(String ad, String soyad);
    Musteri idYeGoreMusteriGetir(long id);
    List<Musteri> tumMusterileriGetir();
}
