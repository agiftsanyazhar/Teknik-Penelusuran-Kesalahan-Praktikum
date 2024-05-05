/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package soal;

import java.util.Scanner;

/**
 *
 * @author Eto
 */
public class Vektor {
     // definisi variabel array x
     private double x[];
     // ukuran --> banyaknya elemen Vektor
     private int ukuran;
     // constructor
//     public Vektor(){ }

     public Vektor(int n)
        {
         x=new double[n];
         ukuran=n; // inisialisasi nilai ukuran
//         ukuran=x.length; // inisialisasi nilai ukuran (juga benar)
        }
     public Vektor(double []v1)
        {
         ukuran=v1.length;   
         x=v1;
        }
     public int getUkuran(){
        return ukuran;   
     }
     
     public double getNilai(int i)
        {
         return x[i];
        }
     public void gantiNilai(int i, double nil)
        {
         x[i]=nil;
        }
     // input data Vektor
     public void masukan(){
//          double a;
          Scanner input = new Scanner(System.in);
          System.out.println("Inputkan data : ");
          for(int i=0;i<ukuran;i++)
                {
                  System.out.print("data ke-"+(i+1)+" : ");
                  x[i] = input.nextDouble();
//                  x[i]=a;
                }
          }
    public void tampil(){
          System.out.print("(");
          for(int i=0;i<ukuran;i++)
             {
             if(i<(ukuran-1))
               System.out.print(x[i]+",");
                 else System.out.print(x[i]);
             }
          System.out.print(")");
          System.out.println("");
          }
    public void tampil(Vektor v1){
          System.out.print("(");
          for(int i=0;i<v1.ukuran;i++)
             {
             if(i<(v1.ukuran-1))
               System.out.print(v1.x[i]+",");
                 else System.out.print(v1.x[i]);
             }
          System.out.print(")");
          System.out.println("");
          }
     public Vektor add2Vektor(Vektor v1,Vektor v2)
     {
      Vektor v3=new Vektor(v1.ukuran);
      for(int i=0;i<v1.ukuran;i++)
          {
           v3.x[i]=v1.x[i]+v2.x[i];
          }
       return v3;
     }
     public Vektor substract2Vektor(Vektor v1,Vektor v2)
     {
      Vektor v3=new Vektor(v1.ukuran);
      for(int i=0;i<v1.ukuran;i++)
          {
           v3.x[i]=v1.x[i]-v2.x[i];
          }
       return v3;
     }
     public Vektor kaliVektorSkalar(Vektor v1,double k1)
     {
      Vektor v3=new Vektor(v1.ukuran);
      for(int i=0;i<v1.ukuran;i++)
          {
           v3.x[i]=v1.x[i]*k1;
          }
       return v3;
     }
     public Vektor bagiVektorSkalar(Vektor v1,double k2)
     {
      Vektor v3=new Vektor(v1.ukuran);
      for(int i=0;i<v1.ukuran;i++)
          {
           v3.x[i]=v1.x[i]/k2;
          }
       return v3;
     }
     public double dot2Vektor(Vektor v1,Vektor v2)
     {
      double nil=0;
      for(int i=0;i<v1.ukuran;i++)
          {
           nil+=v1.x[i]*v2.x[i];
          }
       return nil;
     }

     public double jlhVektor(Vektor v1)
     {
      double jlhV=0;
      for(int i=0;i<v1.ukuran;i++)
          {
           jlhV=jlhV+v1.x[i];
          }
       return jlhV;
     }
     public double hitungMean(Vektor v1)
     {
      double jlhV=0;
      for(int i=0;i<v1.ukuran;i++)
          {
           jlhV=jlhV+v1.x[i];
          }
       return jlhV/(v1.ukuran);
     }
     public Vektor kurangVektorKonst(Vektor v1,double k1)
     {
      Vektor v3=new Vektor(v1.ukuran);
      for(int i=0;i<v1.ukuran;i++)
          {
           v3.x[i]=v1.x[i]-k1;
          }
       return v3;
     }
     public Vektor kuadratVektor(Vektor v1)
     {
      Vektor k2v=new Vektor(v1.ukuran);
      for(int i=0;i<v1.ukuran;i++)
          {
           k2v.x[i]=v1.x[i]*v1.x[i];
          }
       return k2v;
     }

     public double hitungVarians(Vektor v1)
     {
        double nilMean=hitungMean(v1);
        Vektor v3=kurangVektorKonst(v1,nilMean);
        Vektor v4=kuadratVektor(v3) ;
        double nilVar=jlhVektor(v4)/(v4.ukuran-1);
        return nilVar;
     }

     
    public Vektor pangkat3Vektor(Vektor v1)
     {
      Vektor k3v=new Vektor(v1.ukuran);
      for(int i=0;i<v1.ukuran;i++)
          {
           k3v.x[i]=v1.x[i]*v1.x[i]*v1.x[i];
          }
       return k3v;
     }
    public double hitungE3(Vektor v1)
     {
        double E3;
        double nilRata2=hitungMean(v1);
        Vektor v3=kurangVektorKonst(v1,nilRata2);
        Vektor v4=pangkat3Vektor(v3);
        double jlhVektor3=jlhVektor(v4);
        E3= jlhVektor3/(v4.ukuran-1);
        return(E3);
     }
    public Vektor kali2ElemenVektor(Vektor v1,Vektor v2) {
        Vektor kl2v=new Vektor(v1.ukuran);
        for(int i=0;i<v1.ukuran;i++)
          {
           kl2v.x[i]=v1.x[i]*v2.x[i];
          }
       return kl2v;
     }

    public Vektor pangkat5Vektor(Vektor v1)
     {
        Vektor temp1=v1.pangkat3Vektor(v1);
        Vektor temp2=v1.kuadratVektor(v1);
        Vektor temp3=v1.kali2ElemenVektor(temp1,temp2);
        return temp3;
    }
    public double hitungE5(Vektor v1)
    {
        double E5;
        double nilRata2=hitungMean(v1);
        Vektor v3=kurangVektorKonst(v1,nilRata2);
        Vektor v4=pangkat5Vektor(v3);
        double jlhVektor3=jlhVektor(v4);
        E5= jlhVektor3/(v4.ukuran-1);
        return(E5);
   }
}
