/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg152011513020aaprak5b1;

//Bug     : Kurangnya penggunaan import. Befungsi untuk memasukkan suatu method 
//          atau perintah agar method atau perintah tersebut dapat berfungsi
//Solusi  : Menambahkan import
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Agiftsany Azhar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
*    Create Object
*/
        BacaFile bData=new BacaFile();
        OlahFile oFile=new OlahFile();
  /*
 *  Baca file .txt berukuran besar
 *  File file = new File("nama file.txt");
 *  File file = new File("docq\\teks coba.txt"); // jika file berada di folder docq
 *  object.readDoc(file);
 */
    
        File file = new File("D:\\Kuliah\\Semester 4\\Teknik Penelusuran Kesalahan Praktikum\\Tugas\\Java\\152011513020AAPrak5B1\\src\\pkg152011513020aaprak5b1\\teks coba 3.txt");
        String hasil=bData.readDoc(file);

/*
 *  Baca file .txt berukuran besar
 *  object.readFile("nama file.txt");
 */
//        Bug     : Pneggunaan variabel yang sama dan kurangnya tanda kurung
//        Solusi  : Mengganti nama variabel dengan nama yang berbeda dan menambahkan tanda kurung
//        String hasil=bData. readFile (("D:\\Kuliah\\Semester 4\\Teknik Penelusuran Kesalahan Praktikum\\Tugas\\Java\\152011513020AAPrak5B1\\src\\pkg152011513020aaprak5b1\\teks coba 3.txt"));
        String hasil1=bData. readFile (("D:\\Kuliah\\Semester 4\\Teknik Penelusuran Kesalahan Praktikum\\Tugas\\Java\\152011513020AAPrak5B1\\src\\pkg152011513020aaprak5b1\\teks coba 3.txt"));

/*
*    fungsi ini untuk meng-konversi dokumen (yang dibaca oleh readFile(…) atau readDoc(…) )
*    outputnya berupa ArrayList yang berisi kalimat  {kalimat-1, kalimat-2, …, kalimat-n}
*/

        ArrayList hasOlah = oFile.pecahDocJadiKalimat(hasil);

/*
*    untuk menampilkan ArrayList
*/

    	oFile.tampilArrayList(hasOlah);


/*
*    untuk membersihkan token dari ArrayList yang dihasilkan oleh fungsi pecahDocJadiKalimat(…)
*    di dalam fungsi ini akan me-call fungsi  hilangTokenKalimat(…)
*/

        ArrayList hasBersih =oFile.bersihDocDariToken(hasOlah);
    	

/*
*    untuk menghilangkan token di suatu kalimat
*/
//        Bug     : Token masih terlihat ketika rpoject dijalankan dan 
//                  penggunaan tanda kurung yang berlebih
//        Solusi  : Menuliskan method baru agar token tidak muncul dan menghapus tanda kurung yang berlebih
        oFile.hilangTokenKalimat(hasil);
        System.out.print("\n\n=====================================================");
        System.out.print("\nHasil Kalimat Setelah Dihilangkan Tokennya");
        System.out.print("\n=====================================================\n");
        oFile.tampilArrayList(hasBersih);

    }
    
}
