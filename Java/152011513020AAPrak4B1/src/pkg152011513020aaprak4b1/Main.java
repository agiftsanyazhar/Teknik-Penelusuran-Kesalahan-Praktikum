package pkg152011513020aaprak4b1;

import soal.Vektor;

public class Main {

    public static void main(String[] args) {
        Vektor a;
        a = new Vektor(10);
        
        a.masukan();
        a.tampil();
        System.out.println("Ukuran = "+a.getUkuran());
        
        
        Vektor b;
        b = new Vektor(10);
        
        b.masukan();
        b.tampil();
        System.out.println("Ukuran = "+b.getUkuran());
        
        double[] d = {1,2,3,4,5};
        
        RegSed1 c;
        c = new RegSed1(d);
        System.out.println("Nilai Sxy = "+c.hitungNilaiSxy(a, b));
        System.out.println(" ");
        
        System.out.println("Nilai Sxx = "+c.hitungNilaiSxx(b));
        System.out.println(" ");
        
        System.out.println("Nilai beta0 = "+c.hitungBeta0Topi(a, b));
        System.out.println(" ");
        System.out.println("Nilai beta1 = "+c.hitungBeta1Topi(a, b));
        System.out.println(" ");
        System.out.println("Nilai y = "+c.hitungYTopi(a, b));
        System.out.println(" ");

    }
    
}
