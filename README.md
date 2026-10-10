# Bank ABC

Program simulasi perbankan sederhana berbasis konsol (CLI) yang dibuat dengan Java. Program ini mendemonstrasikan konsep OOP seperti **inheritance**, **method overriding**, **method overloading**, **array of object**, serta penggunaan **static variable**.

## Fitur

- **Deposit** – menambah saldo rekening utama
- **Withdraw** – menarik saldo (dengan validasi saldo cukup dan jumlah valid)
- **Show History** – menampilkan riwayat transaksi beserta total transaksi
- **Tambah Akun** – menambah akun baru ke daftar akun (tidak boleh nama kembar, ada batas kapasitas)
- **Lihat Akun** – menampilkan semua akun yang tersimpan
- **Hapus Akun** – menghapus akun berdasarkan nama (tidak case-sensitive)
- **Exit** – keluar dari program

## Struktur File

```
.
├── ArrayOfAoount.java   # Account, SavingsAccount, GiroAccount, ArrayOfAccount
├── BankDemo.java        # Bank dan class utama BankDemo (main)
└── README.md
```

## Struktur Class

| Class | File | Deskripsi |
|---|---|---|
| `Account` | ArrayOfAoount.java | Akun dasar: `nama` dan `saldo` |
| `SavingsAccount` | ArrayOfAoount.java | Turunan `Account`, menambah atribut `bunga` (%) |
| `GiroAccount` | ArrayOfAoount.java | Turunan `Account`, menambah atribut `biayaAdmin` |
| `ArrayOfAccount` | ArrayOfAoount.java | Pengelola array `Account` (tambah, cari, hapus, tampil) |
| `Bank` | BankDemo.java | Rekening utama: saldo, deposit, withdraw, riwayat transaksi |
| `BankDemo` | BankDemo.java | Class utama berisi menu interaktif |

### Hierarki Inheritance

```
Account
├── SavingsAccount  (+ bunga)
└── GiroAccount     (+ biayaAdmin)
```

### Method pada `ArrayOfAccount`

| Method | Keterangan |
|---|---|
| `tambah(String nama, double saldo)` | Overload: membuat `Account` baru lalu menambahkannya |
| `tambah(Account a)` | Menambah objek akun; gagal jika kapasitas penuh atau nama sudah ada |
| `cari(String nama)` | Mengembalikan indeks akun, atau `-1` jika tidak ditemukan |
| `hapus(String nama)` | Menghapus akun dan menggeser elemen setelahnya |
| `tampil()` | Menampilkan seluruh akun (polymorphism lewat `info()`) |

## Cara Menjalankan

Pastikan **JDK** sudah terpasang, lalu jalankan dari folder yang berisi kedua file:

```bash
javac ArrayOfAoount.java BankDemo.java
java BankDemo
```

## Contoh Tampilan

```
Welcome to Bank ABC

Current balance: Rp100000
1. Deposit
2. Withdraw
3. Show History
4. Tambah Akun
5. Lihat Akun
6. Hapus Akun
7. Exit
Enter your choice: 5
Account List:
1. Agus - Rp50000
2. Manuk - Rp75000 [Tabungan, bunga 5.0%]
3. Budi - Rp100000 [Giro, admin Rp2500]
```

## Data Awal

Saat program dijalankan, kapasitas daftar akun adalah 10 dan sudah terisi:

| Nama | Tipe | Saldo | Keterangan |
|---|---|---|---|
| Agus | Account | Rp50.000 | – |
| Manuk | SavingsAccount | Rp75.000 | bunga 5% |
| Budi | GiroAccount | Rp100.000 | admin Rp2.500 |

Saldo awal rekening utama (`Bank`) adalah **Rp100.000**.

## Catatan & Keterbatasan

- Riwayat transaksi (`historyArray`) hanya berkapasitas **10**. Transaksi ke-11 akan memicu `ArrayIndexOutOfBoundsException`.
- Variabel `history` bersifat `static`, sehingga dibagi oleh semua objek `Bank`.
- Input non-angka pada menu akan menyebabkan `InputMismatchException`.
- Nama akun dibaca dengan `scanner.next()`, sehingga tidak boleh mengandung spasi.
- Field `amount` dan `accounts` (`ArrayList`) di class `Bank` belum digunakan; manajemen akun dilakukan oleh `ArrayOfAccount`.
- Data tidak disimpan permanen dan hilang saat program ditutup.
