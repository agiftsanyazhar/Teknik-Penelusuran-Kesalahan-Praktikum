/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg152011513020aaprak7b1;

import pkg152011513020aaprak7b1.DistKontinu;


/**
 *
 * @author gca
 */
public class Antrian2 {
    int nCust, nUlang;
    //private double T1 [];
    DistKontinu DK=new DistKontinu();

    public Antrian2(int nCust1, int nUlang1)
    {
        nCust=nCust1;
        nUlang=nUlang1;
      //  T1=new double[nCust];
    }
   // a1 dan b1 -- parameter distribusi uniform kontinu\
   // tet -- parameter distribusi exponensial
    public double hitungRataW(int a1, int b1, double tet){
        double S2,W,S,T,TN=0 ;
        int i=0;
        for(int j=0;j<nUlang;j++){
            S2=0;
            W=0;
            while(i < nCust) {
		S=DK.distExp(tet);
		T= DK.unifKontinu(a1, b1);
       		if(W < T) W=S;   else  W=W+S-T ;
		S2=S2+W;
		i=i+1;
                }
	//T1[j]=S2;
            TN=TN+S2;
        }

        double rataWS=TN/nUlang;
        return rataWS;
    }
}
