package org.example.service.impl;

import org.example.entity.Musteri;
import org.example.repository.MusteriRepository;
import org.example.service.IMusteriService;

import java.util.List;

public class MusteriService implements IMusteriService {

    // Bir alt katman ile iletişime geçmek için referans üretilir.
    MusteriRepository musteriRepository;

    // referans üretme işlemi constructor ile yapılır
    public MusteriService() {
        musteriRepository = new MusteriRepository();

    }
    @Override
    public void musteriEkle(String ad, String soyad) {
        musteriRepository.saveMusteri(ad, soyad);

    }

    @Override
    public Musteri idYeGoreMusteriGetir(long id) {
        return musteriRepository.idYeGoreMusteriGetir(id);
    }

    @Override
    public List<Musteri> tumMusterileriGetir() {
        return musteriRepository.tumMusterileriGetir();
    }
}
