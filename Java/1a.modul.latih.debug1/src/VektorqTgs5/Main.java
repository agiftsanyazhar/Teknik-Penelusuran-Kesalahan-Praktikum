/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package VektorqTgs5;

import java.util.Scanner;

/**
 *
 * @author Eto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     //  /*
        Scanner in = new Scanner(System.in);
        System.out.println("Inputkan banyaknya data : ");
        int n = in.nextInt();
   // versi 1
      System.out.println("Versi 1 : ");
        Vektor v1=new Vektor(n);
        Vektor v2=new Vektor(n);
        System.out.println("inisialisasi : ");
        v1.tampil(v1);
        v1.tampil(v2);
        v1.masukan();
        v2.masukan();
        System.out.println("diganti nilainya : ");
        v1.tampil(v1);
        v1.tampil(v2);
        Vektor v3=v2.add2Vektor(v1, v2);
        System.out.print("hasil jumlahan : ");
        v1.tampil(v3);
        System.out.println("Vektor v1 : ");
        v2.tampil(v1);
        System.out.print("Varians dari v1 : "+v1.hitungVarians(v1)+"\n");
        System.out.print("E3 dari v1 : "+v1.hitungE3(v1)+"\n");
        System.out.print("E5 dari v1 : "+v1.hitungE5(v1)+"\n");
       // */
        
        
        double [] vekt = {1,2,3,4,5};
       
//        Vektor v1=new Vektor(vekt);
//        Variabel v1 sudah digunakan
        Vektor v=new Vektor(vekt);
         System.out.println("Vektor v : "+v.getNilai(2));
        v.tampil(v);
        
    }

}
