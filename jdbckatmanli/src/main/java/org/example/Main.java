package org.example;

import org.example.controller.MusteriController;
import org.example.entity.Musteri;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MusteriController musteriController = new MusteriController();

        while (true) {

            System.out.println("\n===== MÜŞTERİ YÖNETİM SİSTEMİ =====");
            System.out.println("1 - Müşteri Ekle");
            System.out.println("2 - ID'ye Göre Müşteri Getir");
            System.out.println("3 - Tüm Müşterileri Listele");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine(); // buffer temizleme

            switch (secim) {

                case 1:
                    System.out.print("Müşteri adı: ");
                    String ad = scanner.nextLine();

                    System.out.print("Müşteri soyadı: ");
                    String soyad = scanner.nextLine();

                    musteriController.musteriEkle(ad, soyad);
                    break;

                case 2:
                    System.out.print("Müşteri ID: ");
                    long id = scanner.nextLong();

                    Musteri musteri = musteriController.idYeGoreMusteriGetir(id);

                    if (musteri != null) {
                        System.out.println(
                                "ID: " + musteri.getId() +
                                        ", Ad: " + musteri.getAd() +
                                        ", Soyad: " + musteri.getSoyad()
                        );
                    } else {
                        System.out.println(" Müşteri bulunamadı.");
                    }
                    break;

                case 3:
                    List<Musteri> musteriList = musteriController.tumMusterileriGetir();

                    if (musteriList.isEmpty()) {
                        System.out.println("⚠ Kayıtlı müşteri bulunmamaktadır.");
                    } else {
                        for (Musteri m : musteriList) {
                            System.out.println(
                                    "ID: " + m.getId() +
                                            ", Ad: " + m.getAd() +
                                            ", Soyad: " + m.getSoyad()
                            );
                        }
                    }
                    break;

                case 0:
                    System.out.println(" Programdan çıkılıyor...");
                    scanner.close();
                    return;

                default:
                    System.out.println("❗ Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }
}
