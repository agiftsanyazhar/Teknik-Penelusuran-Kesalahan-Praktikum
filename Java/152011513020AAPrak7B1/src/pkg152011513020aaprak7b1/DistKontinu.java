/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg152011513020aaprak7b1;


/**
 *
 * @author eto
 */
public class DistKontinu extends Vektor{
    DistDiskrit DDu=new DistDiskrit();
    // Distribusi Exponensial
    public double distExp(double teta){       
        return(-teta*Math.log(DDu.uni01()));
    }
    // Distribusi uniform kontinu
    public double unifKontinu(int a, int b)
        {//(double)
        double u=DDu.uni01();
        double x= a+ (b-a)*u;
        return x;
        }
    // Distribusi Normal(0,1) algoritma 1
    public Vektor distNormal01Alg1()
        {
        Vektor x=new Vektor(2);
        double u1=DDu.uni01();
        double u2=DDu.uni01();
        double r=Math.sqrt(-2*Math.log10(u1));
        double a=2*Math.PI*u2;
        x.elemen(r*Math.sin(a), 0) ;
        x.elemen(r*Math.cos(a), 1) ;
        return x;
        }
    // Distribusi Normal(mu,sigma) algoritma 1
    public Vektor distNormal1(double mu,double sigma)
        {
        Vektor x=new Vektor(2);
        Vektor y=distNormal01Alg1();
        x.elemen(mu-sigma*y.ambil(0), 0) ;
        x.elemen(mu-sigma*y.ambil(1), 1) ;
        return x;
        }
    // Distribusi Normal(0,1) algoritma 2
    public double distNormal01Alg2()
        {
        int i = 0;
        double u, x=0;
        do{
            u = DDu.uni01();
            x =  x + u;
            i = i + 1;
            }while( i < 12);
        x = x - 6;
        return x;
        }
    // Distribusi Normal(mu,sigma) algoritma 2
    public double distNormal2(double mu,double sigma)
        {
         return mu-sigma*distNormal01Alg2();
        }
 // Distribusi Gamma(a,1) algoritma 1 untuk 0<a<1 dan b=1
    public double distGammaAlg1(double a)
        {
        if(a<0) {
            System.out.println("Anda salah memasukkan nilai a (0<a<1)");
            return 0;
        }
        if(a>=1) {
            return distGammaAlg2(a);
        }
        else{
         double b=1,c,x=1,v,u;
         boolean balik=false;
         do{
            u=DDu.uni01();
            c=(Math.exp(1)+a)/Math.exp(1);
            double p=c*u;
            if(p<=1) {
                x=p/a;
                v=DDu.uni01();
                if(v>Math.exp(-x)) balik=true; else balik=false;
                }
               else{
                    x=-Math.log((c-p)/a);
                    if(x<0) balik=true;
                       else {
                           v=DDu.uni01();
                           if(v>x*a-1) balik=true; else balik=false;
                          }
                    }
            }while(balik);
         return x;
        }
        }
 // Distribusi Gamma(a,b) algoritma 1
    public double distGamma1(double a, double b)
        {      
         return b*distGammaAlg1(a);
        }
    // Distribusi Gamma(a,1) algoritma 1 untuk a>1 dan b=1
    public double distGammaAlg2(double a)
        {
        if(a==1) {
            System.out.println("Anda salah memasukkan nilai 0<a<1 atau a>1");
            return 0;
        }
        if(a<1) {
            return distGammaAlg1(a);
        }
        else {    
         double x=1,y,u;
         boolean puter=false;
         do{
            y=distExp(1);
            u=DDu.uni01();
            if(Math.log(u)>(a-1)*(1-y+Math.log(y))) puter=true;
                else {
                puter=false;
                x=a*y;
                }
         }while(puter);
         return x;
        }
        }
    // Distribusi Gamma(a,b) algoritma 2
    public double distGamma2(double a, double b)
        {
         return b*distGammaAlg2(a);
        }
//Jika  x1 berdistribusi Gamma(,1) dan x2 berdistribusi Gamma(,1)
//    maka y = x1 /(x1 + x2) berdistribusi Beta(,)
   // Distribusi Beta(a,b)
    public double distBeta(double a, double b)
        {
         double x1,x2,y;
         if(a>0 && a<1)  x1=distGamma1(a,1);
            else  x1=distGamma2(a,1);
         if(b>0 && b<1)  x2=distGamma1(b,1);
            else  x2=distGamma2(b,1);
         y=x1/(x1+x2);
         return y;
        }
    // Distribusi Triangular(a,b,c)
    double distTriangular(double a,double b,double c)
    {
      double u1,u2,S,T,x;
      if(a<b && b<c){
            S = b-a ; T = c-a;
            u1 = DDu.uni01();
            u2 = DDu.uni01();
            if (u1<=S/T)  { x = S*Math.sqrt(u2) + a;}
                else
		x = T - (T-S)*Math.sqrt(u2)+ a;
        } else {
              System.out.print("Anda salah memasukkan nilai a,b dan c (a<b<c)");
              return 0;
              }
      return x;
    }


}


//Algorithm GS due to Ahrens and Dieter (1974) for 0<a<1 and b=1
//1. Generate U from Uniform(0,1). Set c=(e+a)/e, where e=exp(1).
//2. Set P=cU. If P>1, go to step 4.
//3. (P≤1) Set X=P1/a. Generate V from Uniform(0,1). If V>exp(−x), go to step 1; otherwise finish.
//4. (P>1) Set X=−ln((c−P)/a). If X<0, go to step 1; otherwise go to step 5.
//5. Generate V from Uniform(0,1). If V>Xa−1, go to step 1; otherwise finish.


//Algorithm due to Fishman (1976) for a>1 and b=1
//1. Generate Y from Exponential (1).
//2. Generate U from Uniform(0,1).
//3. If lnU≤(a−1)(1−Y+lnY), X=aY; otherwise go to Step 1.
