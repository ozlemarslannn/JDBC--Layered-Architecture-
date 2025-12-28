package org.example.controller;

import org.example.entity.Musteri;
import org.example.service.IMusteriService;
import org.example.service.impl.MusteriService;

import java.util.List;

public class MusteriController {
    // Alt katmanın interfacesi olduğu için iletişime interface üzerinden geçilir.
    private IMusteriService musteriService;

    // nesne üretme işlemi controller içinde yapılır.
    // interface new ile üretilemeyeceği için implement sınıfın nesnesi üretilir.
    public MusteriController() {
        musteriService= new MusteriService();
    }

    public void musteriEkle(String ad, String soyad){
        musteriService.musteriEkle(ad, soyad);
    }

    public Musteri idYeGoreMusteriGetir(long id){
        return musteriService.idYeGoreMusteriGetir(id);
    }

    public List<Musteri> tumMusterileriGetir(){
        return musteriService.tumMusterileriGetir();
    }
}
