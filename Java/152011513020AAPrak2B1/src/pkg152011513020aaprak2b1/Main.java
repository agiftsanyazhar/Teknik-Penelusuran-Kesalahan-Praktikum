package pkg152011513020aaprak2b1;

public class Main {

    public static void main(String[] args) {
        testAPK1();
        testAPK2();
    }
    
    /**
    * skenario uji untuk kebenaran function pk1()
    * dengan berbagai nilai parameter a,b dan c
    */
    public static void testAPK1(){
        System.out.print("====================== \n");
        System.out.print("====== testAPK1 ====== \n");
        System.out.print("====================== \n");
        System.out.print("\n\n ====== test 1 ====== \n");
        pk1(1,1,2);
        System.out.print("\n\n ====== test 2 ====== \n");
        pk1(1,-1,2);
        System.out.print("\n\n ====== test 3 ====== \n");
        pk1(1,4,4);
        System.out.print("\n\n ====== test 4 ====== \n");
        pk1(4,-16,16);
        System.out.print("\n\n ====== test 5 ====== \n");
        pk1(1,121,7);
        System.out.print("\n\n ====== test 6 ====== \n");
        pk1(-12,21,3);
    }
    
    public static void testAPK2(){
        System.out.print("\n\n\n ====================== \n");
        System.out.print("====== testAPK2 ====== \n");
        System.out.print("====================== \n");
        System.out.print("\n\n ====== test 1 ====== \n");
        pk1(2,5,-3);
        System.out.print("\n\n ====== test 2 ====== \n");
        pk1(5,6,1);
        System.out.print("\n\n ====== test 3 ====== \n");
        pk1(2,5,1);
        System.out.print("\n\n ====== test 4 ====== \n");
        pk1(-14,11,21);
        System.out.print("\n\n ====== test 5 ====== \n");
        pk1(7,-10,-4);
        System.out.print("\n\n ====== test 6 ====== \n");
        pk1(5,-29,39);
    }
    
    /**
    *
    * menghitung akar persamaan kuadrat a*x^2 + b*x + c = 0
    * selanjutnya menampilkan hasilnya ke layar monitor
    * @param a adalah koefisien untuk x^2
    * @param b adalah koefisien untu x
    * @param c adalah konstanta
    */
//    public static void pk1(int a, int b, int c){
//    Bugnya adalah menggunakan tipe data int sehingga menghasilkan bilangan bulat.
//    Bilangan yang seharusnya adalah bilangan ril
//    Solusinya adalah dengan mengganti tipe data int menjadi double agar tidak terjadi pembulatan dan 
//    dapat menampilkan angka desimal dengan presisi
    public static void pk1(double a, double b, double c){
//        double d;
//        double x1,x2;
//        Mengganti tipe data int menjadi double agar tidak terjadi pembulatan dan 
//        dapat menampilkan angka desimal dengan presisi
        double d;
        double x1,x2;
        // menghitung nilai descriminant
        d = b*b - 4*a*c;
        if( d>0 ){
//            x1 = (-b + (int) Math.sqrt(d))/(2*a);
//            x2 = (-b - (int) Math.sqrt(d))/(2*a);
//            Mengganti tipe data int menjadi double agar tidak terjadi pembulatan dan 
//            dapat menampilkan angka desimal dengan presisi
            x1 = (-b + (double) Math.sqrt(d))/(2*a);
            x2 = (-b - (double) Math.sqrt(d))/(2*a);
            System.out.println("nilai akar berbeda");
            System.out.println("x1 = "+x1+" ====== x2 = "+x2);
        }
        else if(d==0){
//            x1 = (-b + (double) Math.sqrt(d))/(2*a);
//            Mengganti tipe data int menjadi double agar tidak terjadi pembulatan dan 
//            dapat menampilkan angka desimal dengan presisi
            x1 = (-b + (double) Math.sqrt(d))/(2*a);
            System.out.println("nilai akar kembar ");
            System.out.println("x1 = x2 = "+x1);
        }
        else {
            System.out.println("nilai akar imajiner");
        }
    }
}