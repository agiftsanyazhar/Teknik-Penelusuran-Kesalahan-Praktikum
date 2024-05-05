/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg152011513020aaprak7b1;

/**
 *
 * @author eto
 */
public class DistDiskrit {
    private int xx;
    // generate uniform kontinu (0,1)
    public double uni01(){
        return Math.random();
      }
    // generate uniform diskrit (a,b) u/ a<b
    public int uniformDiskrit(int a, int b){
        if(a>=b){
            System.out.println("Anda Salah menginput nilai a dan b" +
                    " --> nilai a < b !");
            return 0;
        }
        double u=uni01();
        int ud=(int)Math.floor((double)a+(double)(b-a+1)*u);
        return (ud);
    }
    public int binomialAlg1(int n, double p) {
        int x = 0;
        int i = 1;
        double u;
        do{
            u = uni01();
            if( u < p)  x = x + 1;
            i = i + 1;
            }while(i<=n);
        return x;
    }
    public int binomialAlg2(int n, double p) {
        double f=Math.pow(1-p,n), F=f;
        int x=0;
        double u=uni01(); // tergantung nama fungsinya
        while(u>F)
            {
            x=x+1;
            f=f*p*(n-x+1)/((1-p)*x);
            F=F+f;
        }
    return (x);
    }
    // didtribusi Poisson alg 1
    public int distPoisAlg1(double lambda){
        int x=0;
        boolean terus=true;
        double w=0;
        double y;
        DistKontinu dk1=new DistKontinu();
        while(terus)
            {
            y=dk1.distExp(1/lambda);
            w=w+y;
            if(w<1) x=x+1; else terus=false;
	  }
         return x;
    }
     // didtribusi Poisson alg 2
    public int distPois2(double lambda){
        int x=0;
        double f,F,u;
        f=Math.exp(-lambda);
        F=f;
        u=uni01(); 
        while(u>F)
            {x=x+1;
            f=f*(lambda/x);
            F=F+f;
            }
        return(x);
        }
    // didtribusi empirik
    public int distEmpirik(int x[],double fx[]){
        //int x[]={0,3,6,8}; // diketahui di soal
        //float fx[]={.2,.5,.2,.1}; // diketahui di soal        
        int n=x.length;
        double Fx[]=new double[n];
        for(int j=0;j<n;j++)
            {   	// menghitung Fx[j]
             if(j==0) Fx[j]=fx[0]; else Fx[j]=fx[j]+Fx[j-1];
            }
        double u=uni01();
        int i=0;
        while(u>Fx[i]){
            i+=1;
        }
        return x[i];
        }
// mrthod pendukung dist binomial alg 3
    public double min(double x, double y){
        if(x<y) return x; else return y;
    }
    public double max(double x, double y){
        if(x>y) return x; else return y;
    }
// distribusi binomial Alg 3
    public int binomialAlg3(int n, double p) {
        DistKontinu DK=new DistKontinu();
        double z=DK.distNormal01Alg2();
	double x=n*p+z*Math.sqrt(n*p*(1-p));
        if(x>n*p) x=min(Math.floor(x+0.5),n);
            else x=max(Math.floor(x-0.5),0);
        return (int)x;
        }


}
