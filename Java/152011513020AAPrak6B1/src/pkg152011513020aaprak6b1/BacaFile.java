/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg152011513020aaprak6b1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;

/**
 *
 * @author eto
 */
public class BacaFile {
    /*
 *  Baca file .txt berukuran besar
 *  File file = new File("nama file.txt");
 *  File file = new File("docq\\teks coba.txt"); // jika file berada 
				di folder docq
 *  object.readDoc(file);
 *
 */
    public String readDoc(File f) {
        String text = "";
        int read, N = 1024 * 1024;
        char[] buffer = new char[N];

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while(true) {
                 read = br.read(buffer, 0, N);
                 text += new String(buffer, 0, read);

                if(read < N) {
                    break;
                    }
            }
        } catch(Exception ex) {
                ex.printStackTrace();
            }

        return text;
        }
/*
 *  Baca file .txt berukuran besar
 *  object.readFile("nama file.txt");
 *
 */
    public String readFile(String filename)
    {
        String content = null;
        File file = new File(filename); //for ex foo.txt
        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                 }
        return content;
        }

     /*
     *  Membaca dan mengambil data di file .txt
     *  diambil baris pertama saja --> nilai banyaknya baris dan kolom
     *  kemudian disimpan di suatu vektor
     */
    public Vektor nilai_baris_kolom(String nama_file)
            throws FileNotFoundException, IOException
        {
        Vektor v_nilbarkol=new Vektor(2);
        FileReader file = new FileReader(nama_file);
        float bil;
        StreamTokenizer inputStream = new StreamTokenizer(file);
        int tokenType;
        tokenType = inputStream.nextToken();
        int baris;
        baris=(int)inputStream.nval;
        tokenType = inputStream.nextToken();
        int kolom;
        kolom=(int)inputStream.nval;
        Matriks mat_data=new Matriks(baris,kolom);
        file.close();
        v_nilbarkol.elemen(baris,0);
        v_nilbarkol.elemen(kolom,1);
       // System.out.println("v_nilbarkol : ");
       // v_nilbarkol.tampil();
        return v_nilbarkol;
        }
    /*
     *  Membaca dan mengambil data di file .txt
     *  yang berisi data bilangan
     *  kemudian disimpan di matriks data
     */
    public Matriks buatDataBil(String nama_file)
            throws FileNotFoundException, IOException
        {
        FileReader file = new FileReader(nama_file);
        float bil;
        StreamTokenizer inputStream = new StreamTokenizer(file);
        int tokenType;
        DecimalFormat accuracy = new DecimalFormat("0.00");
        tokenType = inputStream.nextToken();
        int baris;
        baris=(int)inputStream.nval;
        tokenType = inputStream.nextToken();
        int kolom;
        kolom=(int)inputStream.nval;
        Matriks mat_data=new Matriks(baris,kolom);
        inputStream.nextToken(); // baris berikutnya
        Vektor v1=new Vektor(baris*kolom);
        int i=0;
        while (tokenType != StreamTokenizer.TT_EOF)
            {
            bil=(float)inputStream.nval;
            v1.elemen(bil,i);
            i++;
            //inputStream.nextToken();
            bil=bil*2;
            tokenType = inputStream.nextToken(); // karakter berikutnya
            }
        int puter=0;
        for(int ii=0;ii<baris;ii++){
           for(int j=0;j<kolom;j++){
              mat_data.elemen(v1.ambil(puter), ii, j);
              puter++;
                }
            }
        System.out.println("mat_data : ");
        mat_data.tampil();
        return mat_data;
        }



}
