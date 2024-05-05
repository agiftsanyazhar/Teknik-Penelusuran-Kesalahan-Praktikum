/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg152011513020aaprak5b1;

import java.text.DecimalFormat;

/**
 *
 * @author Eto
 */
public class Vektor {
   private double vek[];
   private int ukuran;
   DecimalFormat out=new DecimalFormat("0.##");

   public Vektor(){} // constructor tanpa argumen

   public Vektor(int n){ // constructor dg argumen
        vek=new double[n];        
        ukuran=n;
        //System.out.println("Lewat Constructor!!! ");
     }

    public int size() {return ukuran;}

    public double ambil(int i){ return vek[i]; }

    public double elemen(double a, int i){
          vek[i]=a;
          return vek[i];
     }
    public double jumlah_vektor(Vektor v){
        double jlh=0;
        int uk=v.ukuran;
        for(int i=0;i<uk;i++)  jlh=jlh+v.vek[i];
        return jlh;
     }

    /*
     * byk_el_vektor --> banyaknya indeks dalam vektor asli
     * mengambil komplemen indeks dari vektor v
     * menghasilkan vektor yang merupakan komplemen dari v
     *
    public vektor komplemen_indeks_vektor(vektor v_asli,vektor v, int byk_el_vektor){
        double jlh=0;
        int puter=v.size();
        int puter_asli=v_asli.size();
        int el=byk_el_vektor-puter;
        vektor v_komplemen=new vektor(el);
        for(int i=0;i<puter;i++)  {
            vektor v_temp=new vektor(byk_el_vektor-i);
            int terambil=(int)v.ambil(i);
            v_temp=v.hilang_elemen_ke_vektor(v,terambil);
            for(int j=0;j<){

            }
        }
// System.out.println("v_ambil :");
// v_ambil.tampil();
        return v_komplemen;
     }
     * 
     */
    /*
     * menghilangkan elemen ke n dari suatu vektor
     */
    public Vektor hilang_elemen_ke_vektor(Vektor v, int n){
        int el=v.size();
        Vektor v_ambil=new Vektor(el-1);
        int puter=0;
        for(int i=0;i<el;i++)  {
            if(v.ambil(i)!=n) {
                v_ambil.elemen(v.ambil(i), puter);
                puter++;
            }
        }
 System.out.println("v_ambil di ambil_elemen_ke_vektor :");
 v_ambil.tampil();
        return v_ambil;
     }
    /*
     * mengambil n elemen pertama dari suatu vektor
     */
    public Vektor ambil_nelemen_vektor(Vektor v, int n){
        double jlh=0;
        Vektor v_ambil=new Vektor(n);
        for(int i=0;i<n;i++)  v_ambil.elemen(v.vek[i],i);
// System.out.println("v_ambil :");
// v_ambil.tampil();
        return v_ambil;
     }
 /*
 *  Menghitung pengurangan antara dua vektor v1 dan v2
 *  v1-v2
 */
    public Vektor kurang_2vektor(Vektor v1,Vektor v2){
        double jarak,kerja=0;
        int el_jarak=v1.ukuran;
        Vektor v_has=new Vektor(el_jarak);
        for(int i=0;i<el_jarak;i++){
           kerja=v1.ambil(i)-v2.ambil(i);
           v_has.elemen(kerja, i);
        }
 //System.out.println("v hasil v1-v2 :");
 //v_has.tampil();
        return v_has;
      }
/*
 *  Menghitung norm vektor vekt
 *
 */
    public double norm_vektor(Vektor vekt){
        double nil_norm;
        int el_jarak=vekt.ukuran;
        Vektor v_norm=new Vektor(el_jarak);
        //for(int i=0;i<el_jarak;i++){
        Vektor kerja=v_norm.kuadrat_vektor(vekt);
        nil_norm=Math.sqrt(kerja.jumlah_vektor(kerja));
        //}
 //System.out.println("nil_norm : "+nil_norm);
     return nil_norm;
      }
 /*
 *  Menghitung perkalian antara konstanta c dan vektor v1
 *  c*v1
 */
    public Vektor kali_konstanta_vektor(Vektor v1,double konst){
        double jarak,kerja=0;
        int el_jarak=v1.ukuran;
        Vektor v_has=new Vektor(el_jarak);
        for(int i=0;i<el_jarak;i++){
           kerja=konst*v1.ambil(i);
           v_has.elemen(kerja, i);
        }
 //System.out.println("v hasil c*v1 :");
 //v_has.tampil();
        return v_has;
      }

    public double elemen_min(Vektor vmin){
        double min;
        Vektor v_kerja=sort_vektor(vmin);
        min=v_kerja.ambil(0);
        return min;
     }
    public double elemen_max(Vektor vmin){
        double max;
        int end=vmin.size();
        Vektor v_kerja=sort_vektor(vmin);
        max=v_kerja.ambil(end-1);
        return max;
     }
    public Vektor sort_vektor(Vektor v){
        //double jlh=0;
        int uk=v.ukuran;
        //v.tampil();
        Vektor v_sort=new Vektor(uk);
        double kerja;
        for(int i=0;i<uk;i++){
            v_sort.elemen(v.ambil(i),i);
        }
        for(int i=0;i<uk-1;i++){
            //if(i==uk-1) break;
            for(int j=i;j<uk;j++){
//System.out.println("i,j : "+i+", "+j);
              if(v_sort.ambil(i)>v_sort.ambil(j)) {
                  kerja=v_sort.ambil(i);
                  v_sort.elemen(v_sort.ambil(j), i);
                  v_sort.elemen(kerja,j);
                  //v_sort.tampil();
                }
            }
        }
        //v.tampil();
        //System.out.println("sort vektor");
        //v_sort.tampil();
        return v_sort;
     }
    public Vektor indeks_sort_vektor(Vektor v){
        int uk=v.ukuran;
        Vektor v_kerja=new Vektor(uk);
        Vektor v_index=new Vektor(uk);
        //v.tampil();
        /*
         *  untuk menghindari sort vektor aslinya
         *  diperlukan v_kerja sebagai penggantinya
         */
        for(int i=0;i<uk;i++){
            v_kerja.elemen(v.ambil(i),i);
        }
        double kerja1,kerja2;
        for(int i=0;i<uk;i++){
            v_index.elemen(i,i);
        }
        for(int i=0;i<uk-1;i++){
            for(int j=i;j<uk;j++){
//System.out.println("i,j : "+i+", "+j);
              if(v_kerja.ambil(i)>v_kerja.ambil(j)) {
                  kerja1=v_kerja.ambil(i);
                  v_kerja.elemen(v_kerja.ambil(j), i);
                  v_kerja.elemen(kerja1,j);
                  kerja2=v_index.ambil(i);
                  v_index.elemen(v_index.ambil(j), i);
                  v_index.elemen(kerja2,j);
                  //v_sort.tampil();
                }
            }
        }
        //System.out.println("sort vektor");
        //v.tampil();
        //System.out.println("indeks vektor");
        //v_index.tampil();
        return v_index;
     }
 
    public Vektor kuadrat_vektor(Vektor v){
        double jlh=0;
        int uk=v.ukuran;
        Vektor v_kuad=new Vektor(uk);
        for(int i=0;i<uk;i++)  v_kuad.vek[i]=v.vek[i]*v.vek[i];
        return v_kuad;
      }
 /*
  *  Menghitung jarak Eucledian dua vektor v1 dan v2
 */
    public double jarak_2vektor(Vektor v1,Vektor v2){
        double jarak,kerja=0;
        int el_jarak=v1.ukuran;
        for(int i=0;i<el_jarak;i++){
           kerja=kerja+Math.pow((v1.ambil(i)-v2.ambil(i)),2);
        }
        jarak=Math.sqrt(kerja);
        return jarak;
      }
/*
 *  Kesamaan dua vektor v1 dan v2 --> dalam prosentase : ... %
 */
    public double kesamaan_2vektor(Vektor v1,Vektor v2){
        double sama;
        int el_jarak=v1.ukuran;
        int itung=0;
        for(int i=0;i<el_jarak;i++){
           if(v1.ambil(i)==v2.ambil(i)) itung++;
        }
        sama=(double)itung*100/el_jarak;
  //System.out.println("kesamaan_2vektor : "+sama+" %");
        return sama;
      }
    /*
     *  v_b --> vektor yang berisi nomer kelompok object
     *  jlh_kel --> banyaknya kelompok
     *
     *  Menghasilkan vektor yang berisi banyaknya anggota per kelompok
     *  misal : ada 3 kelompok --> (2,5,6) : kel 1 beranggotakan 2 object
     *                                       kel 2 beranggotakan 5 object dst
     */
    public Vektor jlh_kelompok(Vektor v_b,int jlh_kel)
        {
         int puter=v_b.size();
         int kerja;//,itung=0;
         Vektor v_kel=new Vektor(jlh_kel);
   //System.out.println("v_kel awal : ");
   //v_kel.tampil();
         for(int i_k=0;i_k<jlh_kel;i_k++){
            kerja=0;
            //itung++;
            for(int i_v=0;i_v<puter;i_v++){
                if(v_b.ambil(i_v)==i_k) kerja++;
            }
            v_kel.elemen((double)kerja, i_k);
         }
   //System.out.print("v_kel : ");
   //v_kel.tampil();
         return v_kel;
        }
     /*
     *  matriks m_index memuat 2 baris --> baris I berisi index dan baris kedua
     *       berisi beberapa anggota yang salah satu anggotanya yang = elemen
     *       akan dihilangkan --> vektor index-nya saja
     *
     */
    public Vektor ambil_indeks(Matriks m_index,int elemen,int byk_elemen){
        double kerja1,kerja2;
        int kol=m_index.kolom();
        Vektor v_indeks=new Vektor(byk_elemen);
   //System.out.println("m_index : ");
   //m_index.tampil();
        int mut=0;
        for(int i=0;i<kol;i++){
            kerja1=(int)m_index.ambil(1,i);
            kerja2=(int)m_index.ambil(0,i);
            if(kerja1!=elemen) {
                v_indeks.elemen(kerja2,mut);
                mut++;
            }
        }
 //System.out.print("v_indeks : ");
 //v_indeks.tampil();
        return v_indeks;
      }
    public int pilih_indeks(Matriks m_index,double nil_elemen){
        int kerja1;
        double kerja2;
        int kol=m_index.kolom();
        //vektor v_indeks=new vektor(byk_elemen);
   //System.out.println("m_index : ");
   //m_index.tampil();
        boolean terus=true;
        int i=0;
        int indeks_pilih=0;
        do{
            kerja1=(int)m_index.ambil(0,i);
            kerja2=m_index.ambil(1,i);
            if(kerja2==nil_elemen) {
 //System.out.print("indeks_pilih di pilih_indeks : "+indeks_pilih);
                indeks_pilih=kerja1;
                terus=false;
            }
            i++;
            if(i>=kol) terus=false;
        }while(terus);
 //System.out.print("v_indeks : ");
 //v_indeks.tampil();
        return indeks_pilih;
      }
/*
 * menghasilkan v_kelompok yang isinya indeks kelompok per object
 * misal ada 7 object dan 3 kelompok --> (0,1,0,2,1,1,0)
 * matriks m_pusat diperoleh dari fct pusat_kelompok
 *
 */
    public Vektor kelompok(Matriks dat_kmeans,Matriks m_pusat){
        int bar_km=dat_kmeans.baris();
        int kol_km=dat_kmeans.kolom();
        int k=m_pusat.baris();
        Vektor v_kelompok=new Vektor(bar_km);
        Vektor v1=new Vektor(bar_km);
        Vektor v2=new Vektor(bar_km);
        double kerja,kerja2,lama=0,baru=0;
        int bil_acak,masuk;
        //for(int i=0;i<3;i++){
        for(int i=0;i<bar_km;i++){
          lama=0;
          baru=0;
          for(int j=0;j<kol_km;j++){
              kerja=dat_kmeans.ambil(i, j);
              v1.elemen(kerja,j);
             }
          for(int puter=0;puter<k;puter++){
            for(int j=0;j<kol_km;j++){
              kerja2=m_pusat.ambil(puter, j);
              v2.elemen(kerja2,j);
             }
            baru=v1.jarak_2vektor(v1, v2);
            if(puter==0) {
                lama=baru;
                v_kelompok.elemen(puter,i);
                }
                else if(baru<lama) {
                     lama=baru;
                     v_kelompok.elemen(puter,i);
                    }
  //System.out.println("object ke-"+i+" dan puter, baru : "+puter+" --> "+baru);
           } // end puter
  //System.out.println("");
        } //  end i
        //System.out.println("");
   /*
   System.out.print("di function kelompok, ");
   System.out.println("v_kelompok : ");
   v_kelompok.tampil();
   System.out.println("jlh per kelompok _kelompok : ");
   vektor v_jlh=v_kelompok.jlh_kelompok(v_kelompok,k);
   v_jlh.tampil();
    */
        return v_kelompok;
        }


    /*
     * v_olah adalah vektor yang akan dihilangkan elemennya yang = elemen
     * byk_elemen : banyaknya elemen yang akan dihilangkan
     *
     */
    public Vektor hilangkan_elemen(Vektor v_olah,int elemen, int byk_elemen)
        {
         int puter=v_olah.size();
         int itung=0;
 //System.out.println("v_olah di hilangkan_elemen : ");
 //v_olah.tampil();
         Vektor v_hilang=new Vektor(byk_elemen);
         for(int i=0;i<puter;i++){
             if((int)v_olah.ambil(i)!=elemen) {
                 v_hilang.elemen(v_olah.ambil(i), itung); 
                 itung++;
             }
         }
 //System.out.println("v_hilang di hilangkan_elemen : ");
 //v_hilang.tampil();
          return v_hilang;
        }
    /*
     *   Cek apakah ada no kelompok yang tidak masuk v_brs
     *    ? ada kelompok yang tidak punya anggota
     *
     *  v_brs --> vektor yang berisi nomer kelompok object atau
     *              vektor kelompok
     *  jlh_kel --> banyaknya kelompok
     *
     */
    public boolean cek_ada_null(Vektor v_brs,int jlh_kel)
        {
         int kerja;//,itung=0;
         boolean hasil;
         Vektor v_kerja=jlh_kelompok(v_brs,jlh_kel);
         int nil_min=(int)elemen_min(v_kerja);
         if(nil_min==0) hasil=true; else hasil=false;
         return hasil;
        }
    public int cek_optimal_max(Vektor v_opt)
        {
         double k1,k2;//,itung=0;
         int puter=v_opt.size();
         int hasil=0,i=0;
         boolean terus=true;
 //System.out.println("v_opt di cek_optimal : ");
 //v_opt.tampil();
         //vektor v_kerja=jlh_kelompok(v_brs,jlh_iter);
         //for(int i=0;i<puter-2;i++)
         do {
               k1=v_opt.ambil(i+1)-v_opt.ambil(i);
               k2=v_opt.ambil(i+2)-v_opt.ambil(i+1);
  //System.out.println("i : "+i+" dan k1,k2 : "+k1+" , "+k2);
               if(k1>=0 && k2<=0){
                   hasil=i+1+2;
                   terus=false;
               }
               i++;
               if(i>puter-3) terus=false;
            }while(terus);
         return hasil;
        }
    public boolean cek_ada_tdk_null(Vektor v_brs)
        {
         //int kerja;//,itung=0;
         boolean hasil;
         int uk_v=v_brs.size();
         //for(int i=0;i<uk_v;i++){
         int muter=0;
         do{
             if(v_brs.ambil(muter)!=0) hasil=true;
                else hasil=false;
             muter++;
            }while(muter<uk_v);
         return hasil;
        }
    /*
    public double jumlahan_vektor(vektor v_brs)
        {
         double hsl_jlh=0;//,itung=0;
         int uk_v=v_brs.size();
         for(int i=0;i<uk_v;i++) hsl_jlh=hsl_jlh+v_brs.ambil(i);
         return hsl_jlh;
        }
     *
     */
    /*
    public boolean cek_anggota_null(vektor v_klpk,int jlh_kel)
        {
         boolean hasil;
         int jlh_anggota=v_klpk.size();
         if(jlh_anggota<jlh_kel) hasil=true; else hasil=false;
         return hasil;
        }
     *
     */
    public void tampil(){
          System.out.print("(");
          //String kerja2;
          for(int i=0;i<ukuran;i++)
                {
                  if(vek[i]<0 && vek[i]>-0.000000001) vek[i]=0;
                  String kerja=out.format(vek[i]);
                  if(i<(ukuran-1)) System.out.format("%2s",kerja+",");
                       else System.out.format("%1s",kerja);
                }
          System.out.println(")");
          //System.out.println("");
          }
  }
