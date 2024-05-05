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
public class Antrian1 {
    int Tmax, N,K,i;
    double TN, TT, Ta, Ts, Big, teta;
    DistKontinu DK=new DistKontinu();
    
    public Antrian1(double teta1, int Tmax1)
    {
        N = 0;  // # customer yang sedang dalam
	TN = 0;
	K = 0;
	i = 0;
	TT = 0;
        Tmax=Tmax1;
        teta=teta1;
	Ta = DK.distExp(teta1);  //Time of arrival
	Big=Tmax1*Tmax1;
	Ts = Big;  // Ts : service time
    }

    // a1 dan b1 -- parameter distribusi uniform kontinu\
    public double hitungRataWS(int a1, int b1){
        while (TT < Tmax)
       		if(Ta < Ts) {
			TN = TN + (Ta - TT) * N;
			TT = Ta;
			N = N + 1;
			K = K + 1;
			Ta = TT + DK.distExp(teta) ;
			if(N == 1)  Ts = TT + DK.unifKontinu(a1, b1);
                       }
                else  {
                	TN = TN + (Ts - TT) * N;
			TT = Ts;
			N = N - 1;
			i = i + 1;
			if(N > 0)  Ts = TT + DK.unifKontinu(a1, b1);
                         else Ts=Big;
                        }
        double rataWS=TN/K;
        return rataWS;
    }
}
