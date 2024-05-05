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
import java.util.ArrayList;
//import java.lang.Character;
//import java.lang.String;
/**
 *
 * @author Eto
 */
public class OlahFile {
    String fileAsli, fileHasil, previousPrefix;
    ArrayList fileHasilPecah=new ArrayList();
    ArrayList fileTidak=new ArrayList();
//    int bykFile;
    public OlahFile(){}

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public OlahFile(String namaFile){
        File file = new File(namaFile);
        fileAsli=readDoc(file);
 
    //hilangkan ganti baris dan return di dokumen
        fileAsli=fileAsli.replace("\n"," ").replace("\r","").replace("\\s+"," ");
    }
/*
* Tahap preprocessing meliputi pemecahan isi dokumen :
*  Penghilangan singkatan gelar
*  tokenization --> penghilangan karakter dan angka
*  Penghilangan lah, kah,tah,pun dan kepunyaan
*  stopwords filtering --> penghilangan kata tidak penting
*  stemming --> penghilangan awalan dan akhiran
 *
*/
    /*
     * proses utama
     *
     */
    public void prosesUtama(){

        String has0=hilangSingkatanGelar(fileAsli);
        has0=has0.toLowerCase(); // ke huruf kecil semua
        String has1=hilangTokenAngkaDariDokumen(has0);
        String haStop=hilangStopword(has1);     
        fileHasilPecah=pecahDocJadiKata(haStop);
        String word;
        for(int i=0;i<fileHasilPecah.size();i++)
            {
             word=(String)fileHasilPecah.get(i);
             word=hilangPartikelKepunyaanKata(word);
             word=prosesStemming(word);
             fileHasilPecah.set(i,word);
            }               
        fileHasil=buatDocDariKata(fileHasilPecah);       
    }


    /*
     * mengambil nilai-nilai
     * file/dokumen Asli
     * file/dokumen Hasil proses pembersihan
     * file/dokumen kata per kata dari hasil proses pembersihan
     * 
     */
    public String getFileAsli(){
        return fileAsli;
    }
    public String getFileHasil(){
        return fileHasil;
    }
    public ArrayList getFileHasilPecah(){
        return fileHasilPecah;
    }
    /*
     * memecah document menjadi beberapa kalimat
     *
     */
    public ArrayList pecahDocJadiKalimat(String document){
        int sentenceIndex=0;
        int wordIndex=0;
        String sentence;
        ArrayList hasil=new ArrayList();
        for(int i=0;i<document.length();i++){
            if(document.charAt(i) == ' ')   wordIndex = i+1;
            else {
                if (document.charAt(i) == '?' || document.charAt(i) == '!' ||
                    (i == document.length() - 1)) {
                sentence = document.substring(sentenceIndex, i+1);
                hasil.add(sentence);
//                doPreprocessing(sentence);
                sentenceIndex = i+1;
                }
                else {
                    if(document.charAt(i) == '.' && document.charAt(i+1)==' '){
//                        String temp = document.substring(wordIndex, i+1);
//                        if(isAbbreviation(temp)) {
                        sentence = document.substring(sentenceIndex,i+1);
                        hasil.add(sentence);
//                        doPreprocessing(sentence)
                        sentenceIndex = i+1;
//                        }
                        }
                    }
                }
        }
        return hasil;
    }
 /*
     *  penghilangan singkatan gelar di suatu dokumen asli
     *
     */
    public String hilangSingkatanGelar(String dokumen){
        String fileCek=readFile("D:\\Kuliah\\Semester 4\\Teknik Penelusuran Kesalahan Praktikum\\Tugas\\Java\\docq\\singkatan gelar.txt");
        fileCek=fileCek.replace("\n","").replace("\r"," ");
        ArrayList cekList=pecahDocBersihJadiKata(fileCek);
        dokumen=" ".concat(dokumen);
        String cek;
        for(int i=0;i<cekList.size()-1;i++){
            cek=(String)cekList.get(i);
            cek = " ".concat(cek).concat(" ");
            dokumen=dokumen.replace(cek," ");
        }
        dokumen=dokumen.replaceAll("\\s+", " "); // hilangkan space yg banyak
   return dokumen;
    }
/*
 * menghilangkan token dan angka yang ada di dokumen
 *
 */
    public String hilangTokenAngkaDariDokumen(String dokumen){
//        System.out.println("kalimat awal : "+dokumen);
        char[] cekChar1 = {'!','@','#','$','%','^','&','*','(',')','_','+'
            ,'{','"','}',':','<','>','?',',','.','/',';','[',']','–'
            ,'\\','=','|','-','-','0','1','2','3','4','5','6','7','8','9','A'};
        String cek=new String(cekChar1);
        for(int i=0;i<cek.length();i++){
            String cq=(String)cek.substring(i, i+1);
            dokumen=dokumen.replace(cq," ");
//            System.out.println(cq+" dan "+dokumen);
        }
//    System.out.println();
        dokumen=dokumen.replaceAll("\\s+"," ");
   return dokumen;
    }
   /*
     *  penghilangan kata tdak penting di suatu dokumen
     *  yang isinya sdh dikonversike huruf kecil semua
     */
    public String hilangStopword(String dokumen){
        String fileCek=readFile("D:\\Kuliah\\Semester 4\\Teknik Penelusuran Kesalahan Praktikum\\Tugas\\Java\\docq\\stopword BI sort.txt");
        fileCek=fileCek.replace("\n","").replace("\r"," ");
        ArrayList cekList=pecahDocBersihJadiKata(fileCek);
        dokumen=" ".concat(dokumen);
        String cek;
        for(int i=0;i<cekList.size()-1;i++){
            cek=(String)cekList.get(i);
            cek = " ".concat(cek).concat(" ");
            dokumen=dokumen.replace(cek," ");
        }
        dokumen=dokumen.replaceAll("\\s+"," "); // hilangkan space yg banyak
        String ganti=dokumen.substring(0,10);
        String ganti2=dokumen.substring(1,10);
        dokumen=dokumen.replace(ganti,ganti2);
   return dokumen;
    }
    /*
 * dalam dokumen akan
 * dihilangkan partikel kata : "kah” or "lah” or "tah” or "pun”
 * kata kepunyaan : "nya” or "ku” or "mu”
 *
 */
    public String hilangPartikelKepunyaanKata(String kata){
      if(!(fileTidak.contains(kata))) {
// System.out.println("fileTidak.contains(kata) : "+kata);
        kata=kata.concat(" ");
        ArrayList<String> cek=new ArrayList<String>();
        cek.add("kah");
        cek.add("lah");
        cek.add("tah");
        cek.add("pun");
        cek.add("nya");
        cek.add("ku");
        cek.add("mu");
        String cq;
        for(int i=0;i<cek.size();i++){
            cq=(String)cek.get(i).concat(" ");
            kata = kata.replace(cq," ");
            }
        }
//    System.out.println();
//        kata=kata.replaceAll("\\s+"," ");
      kata=kata.replace(" ","");
   return kata;
    }
       /*
 * dalam dokumen akan
 * dihilangkan partikel kata : "kah” or "lah” or "tah” or "pun”
 * kata kepunyaan : "nya” or "ku” or "mu”
 *
 */
    public String hilangPartikelKepunyaanDokumen(String dokumen){
        dokumen=dokumen.concat(" ");
        ArrayList<String> cek=new ArrayList<String>();
        cek.add("kah");
        cek.add("lah");
        cek.add("tah");
        cek.add("pun");
        cek.add("nya");
        cek.add("ku");
        cek.add("mu");
        cek.add("di");
        String cq;
        for(int i=0;i<cek.size();i++){
            cq=(String)cek.get(i).concat(" ");
            dokumen = dokumen.replace(cq," ");
        }
//    System.out.println();
        dokumen=dokumen.replaceAll("\\s+"," ");
   return dokumen;
    }
  /*
 * proses stemming penghilangan awalan dan akhiran
 *
 */
    public String prosesStemming(String kata){
         int length;
         kata=kata.replace(" ","");
         length = kata.length();
         if(length>5){
            kata = hilangAwalanPertama(kata);
            if (length == kata.length()) {
//    System.out.println("panjang sama "+kata);
                kata = hilangAwalanKedua(kata);
                kata = hilangAkhiran(kata);
                }
            else {
//    System.out.println("panjang tidak sama "+kata);
                length = kata.length();
                kata = hilangAkhiran(kata);
                if(length != kata.length())
                    kata = hilangAwalanKedua(kata);
                }
        }
        kata=kata.replace("\n","").replace("\r"," ");
        return kata;
    }
 /*
 * dalam dokumen akan
 * dihilangkan awalan pertama kata  dari suatu
 *
 */
   public String hilangAwalanPertama(String word){
    if(!(fileTidak.contains(word))) {
    String check;
//    String previousPrefix;
//    System.out.println("di hilangAwalanPertama : "+word);
    char temp, temp2;
//    if(word.length()>5){
    check = word.substring(0, 3);
    if(check.equals("ter")) {
        word = word.substring(3, word.length());
        previousPrefix = check;
        }
    else { // ke-1
        check = word.substring(0, 4);
        if (check.equals("meng") || check.equals("peng")) {
//  System.out.println("peng di hilangAwalanPertama : "+word);
            temp = word.charAt(4);
            temp2 = word.charAt(5);
            if(temp=='e' && temp2!='d'){
                word ="k".concat(word.substring(4, word.length()));
                previousPrefix = check;
            }
            else if(isVowel(temp) || temp == 'g' || temp == 'h') {
                    word = word.substring(4, word.length());
                    previousPrefix = check;
                    }
        }
        else { // ke-2
            if (check.equals("meny") || check.equals("peny")) {
            word ="s".concat(word.substring(4, word.length()));
            previousPrefix = check;
            }
            else { // ke-3
                check = word.substring(0, 3);
                if (check.equals("mem") || check.equals("pem")) {
                    temp =(char)word.charAt(3);
//                    if (temp == "b" || temp =="f" || temp =="p") {
                    if (temp == 'b' || temp =='f' || temp =='p') {
                        word = word.substring(3, word.length());
                        }
                       else if(isVowel(temp)) {
                          word = "p".concat(word.substring(3, word.length()));
                          }
                     previousPrefix = check;
                }
//                else if check = “men” or “pen” {
                else { // ke-4
                    if (check.equals("men") || check.equals("pen")) {
                       temp = word.charAt(3);
//                    if temp = “c” or “d” or “j” {
                       if (temp == 'c' || temp =='d' || temp =='j') {
                           word = word.substring(3, word.length());
                           }
                        else if(isVowel(temp)) {
                           word = "t".concat(word.substring(3, word.length()));
                         }
                        previousPrefix = check;
                    }
                    else { //ke-5
                        check = word.substring(0, 2);
//                        if check = “me” {
                        if (check.equals("me")) {
                            temp = word.charAt(2);
//                            if temp = “l” or “m” or “n” or “r” or “w” or “y” {
                            if (temp == 'l' || temp =='m' || temp =='n' ||
                                    temp == 'r' || temp =='w' || temp =='y') {
                                word = word.substring(2, word.length());
                                previousPrefix = check;
                            }
                        }
//                        else if check = “di” or check = “ke” {
                            else if(check.equals("di") || check.equals("ke")){
                                temp = word.charAt(2);
                                word = word.substring(2, word.length());
                                previousPrefix = check;
                                }
                         }// end of else ke-5
                      } // end of else ke-4
                   } // end of else ke-3
                } // end of else ke-2
            } // end of else ke-1
       }
     return word;
   }
   /*
 * dalam dokumen akan
 * dihilangkan awalan kedua dari suatu kata
 *
 */
   public String hilangAwalanKedua(String word){
     if(!(fileTidak.contains(word))) {
	String check2;
//   System.out.println("di hilangAwalanKedua "+word);
	check2 = word.substring(0, 3);
//   System.out.println("check2 di hilangAwalanKedua "+check2);
	if((check2.equals("pel")) || check2.equals("bel"))
            {
            check2 = word.substring(3, 7);
            if (check2.equals("ajar")) {
		word = word.substring(3, word.length());
		previousPrefix = check2;
		}
	    }
	else {
		check2 = word.substring(0, 2);
//  System.out.println("check2 di hilangAwalanKedua "+check2);
		if (check2.equals("be") || check2.equals("pe")) {
                    if (isNotVowel(word.charAt(2)) && (isVowel(word.charAt(3)))
                            && word.substring(4,5).equals("r")) {
//  System.out.println("bertanya");
			word = word.substring(2,word.length());
			previousPrefix = check2;
			}                    
                    else if (word.substring(2,3).equals("r")) {
				word = word.substring(3, word.length());
				previousPrefix = check2;
                     }
                }
            }
        if(previousPrefix==null) previousPrefix = check2;
       }
    return word;
    }

    public boolean isNotVowel(char kar){
        boolean has=false;
        //a e o u i
        if(kar!='a' && kar!='e' && kar!='o' && kar!='u' && kar!='i') has=true;
        return has;
    }
    public boolean isVowel(char kar){
        boolean has=false;
        //a e o u i
        if(kar=='a' || kar=='e' || kar=='o' || kar=='u' || kar=='i') has=true;
        return has;
    }

    /*
 * dalam dokumen akan
 * dihilangkan awalan dan akhiran kata
 *
 */
   public String hilangAkhiran(String word)
    {
     if(!(fileTidak.contains(word))) {
// System.out.println("hilangAkhiran : "+word);
        String check;
        check = word.substring(word.length()-3, word.length());
        if (check.equals("kan")){
            if((previousPrefix.compareTo("ke") != 0)
                      && (previousPrefix.compareTo("peng") != 0))
                    word=word.substring(0, word.length()-3);
           }
          else {
             check=word.substring(word.length()-2, word.length());
             if(check.equals("an")) {
                 if((previousPrefix.compareTo("di") != 0)
                         && (previousPrefix.compareTo("meng") != 0)
                         && (previousPrefix.compareTo("ter") != 0))
                         word = word.substring(0, word.length()-2);
                 }
             else {
                 check= word.substring(word.length()-1, word.length());
                 if (check.equals("i")){
                    if ((previousPrefix.compareTo("ber") != 0)
                          && (previousPrefix.compareTo("ke") != 0)
                           && (previousPrefix.compareTo("peng") != 0))
                         word = word.substring(0, word.length()-1);
		 	}
                    }
		 }
        }
    return word;
    }
 /*
 *  membuat document yang berasal dari kumpulan kata/kalimat
 *  Input : kumpulan kata/kalimat yg disimpan di ArrayList
 *  Output : document yg bertipe String
 */
    public String buatDocDariKata(ArrayList list){
        int n=list.size();
        //ArrayList listq=new ArrayList();
        String hasil="asd";
        for(int i=0;i<n;i++){
            if(i==0) hasil=((String)list.get(i)).concat(" ");
            else hasil=hasil.concat((String)list.get(i)).concat(" ");
        }
        return hasil;
    }
     /*
     * memecah document menjadi beberapa kata
     * dokumen asli dari baca file
     *
     */
    public ArrayList pecahDocBersihJadiKata(String dokumen){
        int index=0;
        int wordIndex=0;
        String word;
        char k1,k2;
        ArrayList hasil=new ArrayList();
        for(int i=0;i<dokumen.length()-1;i++){
            k1=dokumen.charAt(i);
            k2=dokumen.charAt(i+1);
            if( (k1 != ' ' && k2==' ')||(k1 != ' ' && k2=='\r'))  {
//            if( k1 != ' ' && k2==' ')  {
                if(wordIndex==0) word = dokumen.substring(0, index+1);
                  else word = dokumen.substring(wordIndex + 1, index + 1);
                hasil.add(word);
                wordIndex = i+1;
            }
            else index = i + 1;
        }
        if(index==dokumen.length()-1){
            word = dokumen.substring(wordIndex+1, index+1);
            hasil.add(word);
            }
        int m=hasil.size();
//        System.out.println("nilai m = "+m);
        if(hasil.get(m-1).equals(" ")) hasil.remove(m-1);
        return hasil;
    }
    /*
     * memecah document menjadi beberapa kata
     * dokumen asli dari baca file
     *
     */
    public ArrayList pecahDocJadiKata(String dokumen){
        int index=0;
        int wordIndex=0;
        String word;
        char k1,k2;
        ArrayList hasil=new ArrayList();
        for(int i=0;i<dokumen.length()-1;i++){
            k1=dokumen.charAt(i);
            k2=dokumen.charAt(i+1);
            if( (k1 != ' ' && k2==' ')||(k1 != ' ' && k2=='\r'))  {
                if(wordIndex==0) word = dokumen.substring(0, index+1);
                  else word = dokumen.substring(wordIndex + 1, index + 1);
//                if(k2=='\r') {
//                    System.out.println(" i = "+i+" dan masuk k2='\r'");
//                    word = kalimat.substring(wordIndex + 3, index + 1);
//                    word
//                    word=String.valueOf(word);
//                    word=word.replace("\r","");
//                    word=word.replace("\r","");
//                }//replace("\r","");
//                if(sentence.charAt(wordIndex+1)!=' ')

                hasil.add(word);
                wordIndex = i+1;
            }
            else index = i + 1;
        }
        if(index==dokumen.length()-1){
            word = dokumen.substring(wordIndex+1, index+1);
            hasil.add(word);
            }
        int m=hasil.size();
//        System.out.println("nilai m = "+m);
        if(hasil.get(m-1).equals(" ")) hasil.remove(m-1);
        return hasil;
    }
  

    

    public void tampilArrayList(ArrayList list){
        int n=list.size();
        for(int i=0;i<n;i++){
            System.out.println("List ke-"+i+" :"+list.get(i));
        }
    }
    /*
 *  Baca file .txt berukuran besar
 *  File file = new File("nama file.txt");
 *  object.readDoc(file);
 *
 */
    @SuppressWarnings("CallToThreadDumpStack")
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
    @SuppressWarnings("CallToThreadDumpStack")
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
/*
 * menghilangkan kata tanya yang ada di dokumen
 *
 */
//public String hilangTanyaDariDokumen(String dokumen){
//     dokumen=dokumen.replace("apa","");
//      dokumen=dokumen.replace("mengapa","");
//       dokumen=dokumen.replace("bagaimana","");
//        dokumen=dokumen.replace("siapa","");
//         dokumen=dokumen.replace("kenapa","");
//    return dokumen;
//    }

} // end of class
