/*
 * Project ArrayDebug3 yang merupakan implementasi List Static
 * Program Diploma III 
 * Prodi D3 Sistem Informasi
 * fakultas Vokasi - Universitas Airlangga
 * Dosen : Kartono, Eto Wuryanto, Faried, Barry, Arman
 */
package arrayproject;


/**
 *
 * @author kartonofaqih
 */
public class ArrayProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        /**
         * digunakan untuk menguji member function yang ada di class ArrayDebug3
         * silahkan dihapus tanpa komentar atau //
         * sesuai dengan member function yang akan diujikan
         */
        
        
        System.out.println("===== test_add =====");
        test_add();               // menguji function add()
        
		// penelusuran --> fasilitas netbeans
		// step-stepnya
		// bug : ...
		// solusinya : ...
		
		// bantuan -> membuat variabel atau function baru (optional)
		// bug : ...
		// solusinya : ...
		
		// sout(...) 
		// bug : ...
		// solusinya : ...
		
	System.out.println("\n===== test_delFront =====");
        test_delFront();          // menguji function delFront()
        
		// 
		//
		
		
	System.out.println("\n===== test_delRear =====");
        test_delRear();           // menguji function delRear()
        
        System.out.println("\n===== test_del =====");
        test_del();               // menguji function del()
        
        System.out.println("\n===== test_get =====");
        test_get();               // menguji function get(int position)
        
        System.out.println("\n===== test_get1 =====");
        test_get1();               // menguji function get(int position)
        
        System.out.println("\n===== test_getPosition =====");
        test_getPosition();       // menguji function getPosition(int item)
        
        System.out.println("\n===== test_getPosition1 =====");
        test_getPosition1();       // menguji function getPosition(int item)
        
        System.out.println("\n===== testInsert =====");
        testInsert();             // menguji function insert(int item)
        
        System.out.println("\n===== testInsert1 =====");
        testInsert1();             // menguji function insert(int item)
        
        
        // ---------------------------------
        // ------- SORTING --------
        // penelusuran --> fasilitas netbeans
        // step-stepnya
        // bug : Tidak ada parameter
        // solusinya : Menambahkan parameter agar kode berjalan lancar
        System.out.println("\n===== testClock =====");
        testClock(123);
        
        System.out.println("\n===== test_bubbleSort =====");
        test_bubbleSort();
        
        System.out.println("\n===== test_selectionSort =====");
        test_selectionSort();
        
        System.out.println("\n===== test_mergerSort =====");
        test_mergerSort();
        
        System.out.println("\n===== test_search =====");
        test_search();
        
        System.out.println("\n===== testClock =====");
        testClock(200);
        
    }
    
    public static void testClock(int n){
        long t1,t2,t3;
        int x=1;
        int y = 2;
        t1 = System.currentTimeMillis();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                for(int k=0;k<n;k++)
                    for(int l=0;l<n;l++)
                        for(int m=0;m<n;m++)
                            if(x<y);
        t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
    
    public static void test_search(){
        ArrayDebug3 r;
        r = new ArrayDebug3(5);
        for(int i=0;i<5;i++)
            r.add(2*i+3);
        r.print();   
        
        boolean result;
        result = r.sequentialSearch(7);
        System.out.println("nilai found = "+result);
        
        result = r.sequentialSearch(8);
        System.out.println("nilai found = "+result);
        
        result = r.binarySearch(7);
        System.out.println("nilai found = "+result);
        
        result = r.binarySearch(8);
        System.out.println("nilai found = "+result);
        
        
    }
    public static void test_mergerSort(){
        
        ArrayDebug3 r;
        r = new ArrayDebug3(10,100);
        r.print();
        r.mergerSort();
        r.print();
        
    }
    
    public static void test_selectionSort(){
        
        ArrayDebug3 r;
        r = new ArrayDebug3(10,100);
        r.print();
        r.selectionSort();
        r.print();
        
    }
    
    public static void test_bubbleSort(){
        
        ArrayDebug3 r;
        r = new ArrayDebug3(5,100);
        r.print();
        r.bubbleSort();
        r.print();
        
    }
    
    // penelusuran --> fasilitas netbeans
    // step-stepnya
    // bug : Kesalahan penulisan pada sout
    // solusinya : Mengganti angka 13 dengan angka 12 agar mnemapilkan hasil
    // yang sesuai dengan nilai arrayDebug3
    public static void test_getPosition(){
        ArrayDebug3 x;
        x = new ArrayDebug3(10);   // insialisasi arrayDebug3 dengan ukuran 5
        
        for(int i=0;i<10;i++)  
            x.add(2*i+1);       // menambahkan item 5x    
        x.print();
        
        int position;
        position = x.getPosition(13);   // data ditemukan
        System.out.println("posisi data dengn nilai 13 adalah = "+position);
        
        position = x.getPosition(12);   // data tidak ditemukan
        System.out.println("posisi data dengn nilai 13 adalah = "+position);
        
    }
    
    
    public static void test_getPosition1(){
        ArrayDebug3 x;
        x = new ArrayDebug3(10);   // insialisasi arrayDebug3 dengan ukuran 5
        
        for(int i=0;i<10;i++)  
            x.add(2*i+1);       // menambahkan item 5x    
        x.print();
        
        int position;
        position = x.getPosition1(13);   // data ditemukan
        System.out.println("posisi data dengn nilai 13 adalah = "+position);
        
        position = x.getPosition1(12);   // data tidak ditemukan
        System.out.println("posisi data dengn nilai 12 adalah = "+position);
        
    }
    
    
    public static void test_get(){
        ArrayDebug3 x;
        x = new ArrayDebug3(10);   // insialisasi arrayDebug3 dengan ukuran 5
        
        for(int i=0;i<10;i++)  
            x.add(2*i+1);       // menambahkan item 5x    
        x.print();
        
        int z;
        z = x.get(5);
        System.out.println("nilai data ke 5 adalah = "+z);
    }
    
    public static void test_get1(){
        ArrayDebug3 x;
        x = new ArrayDebug3(10);   // insialisasi arrayDebug3 dengan ukuran 5
        
        for(int i=0;i<10;i++)  
            x.add(2*i+1);       // menambahkan item 5x    
        x.print();
        
        int z;
        z = x.get1(5);
        System.out.println("nilai data ke 5 adalah = "+z);
    }
    
    
    public static void test_del(){
        ArrayDebug3 x;
        x = new ArrayDebug3(10);   // insialisasi arrayDebug3 dengan ukuran 5
        
        for(int i=0;i<10;i++)  
            x.add(i);       // menambahkan item 5x    
        x.print();
        
        x.del(4);           // menghapus di posisi tengah
        x.print();
        
        x.del(0);           // menghapus di posisi awal
        x.print();
        
        x.del(9);           // menghapus di posisi akhir
        x.print();
    }
    
    
    public static void test_delFront(){
        ArrayDebug3 x;
        x = new ArrayDebug3(5);   // insialisasi arrayDebug3 dengan ukuran 5
        
        for(int i=0;i<5;i++)  
            x.add(i);       // menambahkan item 5x    
        x.print();
        
        x.delFront();        // menghapus data terdepan
        x.delFront();        // diulang
        x.print();
    }
    
    
    
    public static void test_delRear(){
        ArrayDebug3 x;
        x = new ArrayDebug3(5);   // insialisasi arrayDebug3 dengan ukuran 5
        
        for(int i=0;i<5;i++)  
            x.add(i);       // menambahkan item 5x    
        x.print();
        
        x.delRear();        // menghapus data terakhir
        x.delRear();        // diulang
        x.print();
    }
    
    
    public static void test_add(){
        ArrayDebug3 x;
        x = new ArrayDebug3(5);   // insialisasi arrayDebug3 dengan ukuran 5
        
        for(int i=0;i<5;i++)  
            x.add(i);       // menambahkan item 5x    
        x.print();
        
        x.add(10);          // menambah item bila arrayDebug3 penuh
        x.print();          // tidak mengerjakan apapun
    }
    
    
    // penelusuran --> fasilitas netbeans
    // step-stepnya
    // bug : Kurangnya size pada arrayDebug3 sehingga add terakhir tidak terpenuhi
    // solusinya : Mengganti size arrayDebug3 dengan 6 agar semua data bisa dimuat
    public static void testInsert(){
        ArrayDebug3 x;
        x = new ArrayDebug3(5);
        x.insert(20);       // insert dalam keadaan arrayDebug3 kosong
        x.insert(40);       // insert di posisi belakang
        x.insert(10);       // insert di posisi depan
        x.insert(30);       // insert di posisi tengah
        x.insert(25);       // insert di posisi tengah
        x.print();
        
        x.insert(70);       // insert dalam keadaan arrayDebug3 penuh
        x.print();
        
        
    }
    
    public static void testInsert1(){
        ArrayDebug3 x;
        x = new ArrayDebug3(6);
        x.insert(20);       // insert dalam keadaan arrayDebug3 kosong
        x.insert(40);       // insert di posisi belakang
        x.insert(10);       // insert di posisi depan
        x.insert(30);       // insert di posisi tengah
        x.insert(25);       // insert di posisi tengah
        x.print();
        
        x.insert(70);       // insert dalam keadaan arrayDebug3 penuh
        x.print();
        
        
    }
    
}
