class Account {
    String nama;
    double saldo;

    public Account(String nama, double saldo) {
        this.nama = nama;
        this.saldo = saldo;
    }

    public String info() {
        return nama + " - Rp" + (int) saldo;
    }
}

class SavingsAccount extends Account {
    double bunga;

    public SavingsAccount(String nama, double saldo, double bunga) {
        super(nama, saldo);
        this.bunga = bunga;
    }

    @Override
    public String info() {
        return super.info() + " [Tabungan, bunga " + bunga + "%]";
    }
}

class GiroAccount extends Account {
    double biayaAdmin;

    public GiroAccount(String nama, double saldo, double biayaAdmin) {
        super(nama, saldo);
        this.biayaAdmin = biayaAdmin;
    }

    @Override
    public String info() {
        return super.info() + " [Giro, admin Rp" + (int) biayaAdmin + "]";
    }
}

class ArrayOfAccount {
    Account[] data;
    int jumlah = 0;

    public ArrayOfAccount(int kapasitas) {
        data = new Account[kapasitas];
    }

    public void tambah(String nama, double saldo) {
        tambah(new Account(nama, saldo));
    }

    public void tambah(Account a) {
        if (jumlah >= data.length) {
            System.out.println("Tambah akun gagal, kapasitas penuh");
        } else if (cari(a.nama) != -1) {
            System.out.println("Tambah akun gagal, nama sudah ada");
        } else {
            data[jumlah] = a;
            jumlah++;
            System.out.println("Akun " + a.nama + " berhasil ditambahkan");
        }
    }

    public int cari(String nama) {
        for (int i = 0; i < jumlah; i++) {
            if (data[i].nama.equalsIgnoreCase(nama)) {
                return i;
            }
        }
        return -1;
    }

    public void hapus(String nama) {
        int idx = cari(nama);
        if (idx == -1) {
            System.out.println("Hapus gagal, akun tidak ditemukan");
            return;
        }
        for (int i = idx; i < jumlah - 1; i++) {
            data[i] = data[i + 1];
        }
        data[jumlah - 1] = null;
        jumlah--;
        System.out.println("Akun " + nama + " berhasil dihapus");
    }

    public void tampil() {
        System.out.println("Account List:");
        if (jumlah == 0) {
            System.out.println("(kosong)");
        }
        for (int i = 0; i < jumlah; i++) {
            System.out.println((i + 1) + ". " + data[i].info());
        }
    }
}