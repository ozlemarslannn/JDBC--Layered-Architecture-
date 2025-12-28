#  JDBC – Katmanlı Mimari

Bu proje, **Java JDBC** kullanılarak **PostgreSQL** veritabanı ile çalışan  
basit bir müşteri yönetim uygulamasıdır.

Proje, **katmanlı mimari** yapısına uygun olarak geliştirilmiştir.

---

## Katmanlı Mimari

- **Controller**: Kullanıcıdan gelen istekleri alır.
- **Service**: İş mantığını içerir.
- **Repository**: JDBC ile veritabanı işlemlerini yapar.
- **Util**: Veritabanı bağlantı işlemlerini içerir.

Bu yapı sayesinde kod daha **düzenli**, **okunabilir** ve **bakımı kolay** hale gelir.

---

##  Özellikler

- Müşteri ekleme  
- ID’ye göre müşteri getirme  
- Tüm müşterileri listeleme  

---

##  Çalıştırma Notu

Projeyi çalıştırabilmek için  
`util/DBConnection.java` dosyasında bulunan **10. satırdaki** JDBC bağlantı adresi,  
kendi **IP adresi**, **port** ve **veritabanı adı** bilgilerinize göre düzenlenmelidir.

### Örnek

```java
String url = "jdbc:postgresql://localhost:8888/veritabani_adi";

```
## Ekran Çıktısı
<img width="505" height="719" alt="image" src="https://github.com/user-attachments/assets/5722b4fe-00ba-42d8-ae0c-4168f7fc0300" />


<img width="502" height="557" alt="image" src="https://github.com/user-attachments/assets/83076384-8348-459f-944d-682b2534e7bb" />

