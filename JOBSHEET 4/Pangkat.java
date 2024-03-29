import java.util.Scanner;

public class Pangkat {
    public int nilai, pangkat;

    // add konstruktor
    public Pangkat(int nil, int pgkt) {
        nilai = nil;
        pangkat = pgkt;
    }

    public int pangkatBF(int a, int n) {
        int hasil = 1;
        for (int i = 0; i < n; i++) {
            hasil = hasil * a;
        }
        return hasil;
    }
    public int pangkatDC(int a, int n) {
        if (n == 0) {
            return 1;
        } else {
            if (n % 2 == 1) { // bilangan ganjil
                return (pangkatDC(a, n/2) * pangkatDC(a, n/2) * a);
            } else { // bilangan genap
                return (pangkatDC(a, n/2) * pangkatDC(a, n/2));
            }
        }
    }
}

class MainPangkat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================================");
        System.out.print("Masukkan jumlah elemen yang ingin dihitung : ");
        int elemen = sc.nextInt();
        
        Pangkat[] png = new Pangkat[elemen];
        
        for (int i = 0; i < elemen; i++) {
            png[i] = new Pangkat(i, i);
            System.out.print("Masukkan nilai yang akan dipangkatkan ke-" + (i + 1) + " : ");
            png[i].nilai = sc.nextInt();
            System.out.print("Masukkan nilai pemangkat ke-" + (i + 1) + " : ");
            png[i].pangkat = sc.nextInt();
        }

        System.out.println("====================================================");
        System.out.println("1. Brute Force\n2. Divide and Conquer");
        System.out.println("====================================================");
        System.out.print("Pilih metode yang anda inginkan : ");
        int metode = sc.nextInt();
        switch (metode) {
            case 1:
            System.out.println("=====================================================");
            System.out.println("Hasil pangkat dengan Brute Force");
            for (int i = 0; i < elemen; i++) {
                System.out.println("Nilai " + png[i].nilai + " pangkat " + png[i].pangkat + " adalah : " + png[i].pangkatBF(png[i].nilai, png[i].pangkat));
            }
                break;
            case 2:
            System.out.println("=====================================================");
            System.out.println("Hasil pangkat dengan Divide and Conquer");
            for (int i = 0; i < elemen; i++) {
                System.out.println("Nilai " + png[i].nilai + " pangkat " + png[i].pangkat + " adalah : " + png[i].pangkatDC(png[i].nilai, png[i].pangkat));
            }
                break;
        }
        System.out.println("=====================================================");
    }
}