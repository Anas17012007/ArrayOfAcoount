class Bank {
    double balance;
    double amount;
    static int history;
    int[] historyArray = new int[10];
    java.util.ArrayList<String> accounts = new java.util.ArrayList<String>();

    public Bank(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            historyArray[history] = (int) amount;
            history++;
            System.out.println("Deposit: Rp" + (int) amount);
            System.out.println("Current balance: Rp" + (int) balance);
        } else {
            System.out.println("Deposit gagal, jumlah harus lebih dari 0");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Withdraw gagal, saldo tidak cukup");
        } else if (amount <= 0) {
            System.out.println("Withdraw gagal, jumlah tidak valid");
        } else {
            balance -= amount;
            historyArray[history] = -(int) amount;
            history++;
            System.out.println("Withdraw: Rp" + (int) amount);
            System.out.println("Current balance: Rp" + (int) balance);
        }
    }

    public void showHistory() {
        System.out.println("Transaction History:");
        for (int i = 0; i < history; i++) {
            System.out.println((i + 1) + ". Rp" + historyArray[i]);
        }
    }

    public void showAccounts() {
        System.out.println("Account List:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i));
        }
    }

    public int getHistory() {
        return history;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Bank rekening = new Bank(100000);
        ArrayOfAccount daftar = new ArrayOfAccount(10);
        daftar.tambah(new Account("Agus", 50000));
        daftar.tambah(new SavingsAccount("Manuk", 75000, 5));
        daftar.tambah(new GiroAccount("Budi", 100000, 2500));

        System.out.println("Welcome to Bank ABC");
        System.out.println();

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Current balance: Rp" + (int) rekening.getBalance());
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show History");
            System.out.println("4. Tambah Akun");
            System.out.println("5. Lihat Akun");
            System.out.println("6. Hapus Akun");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Enter deposit amount: Rp");
                    rekening.deposit(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: Rp");
                    rekening.withdraw(scanner.nextDouble());
                    break;
                case 3:
                    rekening.showHistory();
                    System.out.println("Total Transaksi: " + rekening.getHistory());
                    break;
                case 4:
                    System.out.print("Nama akun: ");
                    String nama = scanner.next();
                    System.out.print("Saldo awal: Rp");
                    double saldo = scanner.nextDouble();
                    daftar.tambah(nama, saldo);
                    break;
                case 5:
                    daftar.tampil();
                    break;
                case 6:
                    System.out.print("Nama akun yang dihapus: ");
                    daftar.hapus(scanner.next());
                    break;
                case 7:
                    System.out.println("Terima kasih telah menggunakan Bank ABC");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println();
        } while (pilihan != 7);

        scanner.close();
    }
}