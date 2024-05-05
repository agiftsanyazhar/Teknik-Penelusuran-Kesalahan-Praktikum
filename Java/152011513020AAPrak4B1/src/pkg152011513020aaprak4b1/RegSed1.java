/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg152011513020aaprak4b1;

import soal.Vektor;



/**
 *
 * @author admin
 */
public class RegSed1 extends Vektor{
    
    //Vektor v;
    
    public RegSed1(double []v1){
        super(v1);
    }
   
    public double hitungRataRata(Vektor v1){
        return v1.hitungMean(v1);
    }
    /*
    v1 -- x
    v2 -- y
    */
//         bug      : Vektor v3=v1.kali2ElemenVektor(v1, v22);
//         alasan   : Karena rumus Sxy yang dikalikan adalah v11 dan v22
//         solusi   : v1 diparameter harusnya v11
//    public double hitungNilaiSxy(Vektor v1, Vektor v2){
//         double sxy;
//         double rataV1=v1.hitungMean(v1);
//         double rataV2=v1.hitungMean(v2);
//         Vektor v11=v1.kurangVektorKonst(v1, rataV1);
//         Vektor v22=v1.kurangVektorKonst(v2, rataV2);
//         sxy=v1.jlhVektor(v3);         
//         return sxy;
//    }
    
    public double hitungNilaiSxy(Vektor v1, Vektor v2){
         double sxy;
         double rataV1=v1.hitungMean(v1);
         double rataV2=v1.hitungMean(v2);
         Vektor v11=v1.kurangVektorKonst(v1, rataV1);
         Vektor v22=v1.kurangVektorKonst(v2, rataV2);
         Vektor v3=v1.kali2ElemenVektor(v11, v22);
         sxy=v1.jlhVektor(v3);         
         return sxy;
    }
    
    public double hitungNilaiSxx(Vektor x){
         double sxx;
         double rataX=x.hitungMean(x);
         Vektor x11=x.kurangVektorKonst(x, rataX);
         Vektor x11kuadrat = x11.kuadratVektor(x11);
         sxx=x11.jlhVektor(x11kuadrat);
         return sxx;
    }
    /*
    beta0_topi = rata2(y) - beta1_topi * rata2(x)
    */
//    bug     : double b1 = hitungBeta1Topi(y,x);
//    alasan  : salah karena y,x
//    solusi  : solusi diganti x,y
//    public double hitungBeta0Topi(Vektor x, Vektor y){
//        double b1=hitungBeta1Topi(y,x);
//        double b0 = y.hitungMean(y) - b1 * x.hitungMean(x);
//        System.out.println("b0 : "+b0);
//        return b0;
//    } 
    
    public double hitungBeta0Topi(Vektor x, Vektor y){
        double b1=hitungBeta1Topi(x,y);
        double b0 = y.hitungMean(y) - b1 * x.hitungMean(x);
        System.out.println("b0 : "+b0);
        return b0;
    } 
    
    public double hitungBeta1Topi(Vektor x, Vektor y){
        double sxy = hitungNilaiSxy(x,y);
        double sxx = hitungNilaiSxx(x);
        double b1 = sxy/sxx;
        System.out.println("b1 : "+b1);
        return b1;
    }
    /*
      yTopi = beta0_topi + x * beta1_topi
    */
    public Vektor hitungYTopi(Vektor x, Vektor y){        
        Vektor yTopi = new Vektor(x.getUkuran()) ;
        double b0 = hitungBeta0Topi(x,y);
        double b1 = hitungBeta1Topi(x,y);
        for(int i=0;i<x.getUkuran();i++){
            yTopi.gantiNilai(i, b0 + b1*x.getNilai(i));
        }
        return yTopi;
    }
    
}
