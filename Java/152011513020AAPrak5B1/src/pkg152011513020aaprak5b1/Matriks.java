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
public class Matriks {
    private int baris,kolom;
    private double mat[][];
    DecimalFormat out=new DecimalFormat("0.##");
    public Matriks(int a,int b)
      { baris=a;
        kolom=b;
        mat=new double[a][b];
        for(int i=0;i<baris;i++)
           for(int j=0;j<kolom;j++) mat[i][j]=0;
       }

   public int baris() {return baris;}
   public int kolom() {return kolom;}
   public double ambil(int brs,int kol) { return mat[brs][kol]; }

   public double elemen(double isi,int brs,int kol) {
       mat[brs][kol]=isi;
       return mat[brs][kol];
       }
   public void tampil()
       {//System.out.println();
        for(int i=0;i<baris;i++){
           for(int j=0;j<kolom;j++){
               //System.out.print(+mat[i][j]+" ");
               //System.out.format("%5s", Double.toString(mat[i][j]));
               String kerja=out.format(mat[i][j]);
               System.out.format("%6s", kerja);
           }
           System.out.println();
        }
       }
   public void tampil_10()
       {
        for(int i=0;i<baris;i++){
           for(int j=0;j<kolom;j++){
               String kerja=out.format(mat[i][j]);
               System.out.format("%2s", kerja);
           }
           System.out.println();
        }
       }
   public void tampil_mat_fitness()
       {
        for(int i=0;i<baris;i++){
           for(int j=0;j<kolom;j++){
               if(j<kolom-1){
                    String kerja=out.format(mat[i][j]);
                    System.out.format("%2s", kerja);
                    }
                else{
                    String kerja=out.format(mat[i][j]);
                    System.out.format("%8s", kerja);
                    }
           }
           System.out.println();
        }
       }
   public void tampil_mat_fitness_sebagian(int bagian)
       {
        for(int i=0;i<bagian;i++){
           for(int j=0;j<kolom;j++){
               if(j<kolom-1){
                    String kerja=out.format(mat[i][j]);
                    System.out.format("%2s", kerja);
                    }
                else{
                    String kerja=out.format(mat[i][j]);
                    System.out.format("%8s", kerja);
                    }
           }
           System.out.println();
        }
       }
   public void jumlah_mat(Matriks m1,Matriks m2)
       {
        for(int i=0;i<baris;i++)
           for(int j=0;j<kolom;j++)
               mat[i][j]=m1.mat[i][j]+m2.mat[i][j];               
       }
   public void kurang_mat(Matriks m1,Matriks m2)
       {
        for(int i=0;i<baris;i++)
           for(int j=0;j<kolom;j++)
               mat[i][j]=m1.mat[i][j]-m2.mat[i][j];
        }
   public double trace(Matriks m)
        {
         int brs=m.baris;
         int kol=m.kolom;
         if(brs!=kol) {
            System.out.print("jumlah baris tdk sama dengan jumlah kolom --> ");
            return 0;
         }
         double jlh=0;
         for(int i=0;i<brs;i++) jlh=jlh+m.mat[i][i];
         return jlh;
        }
   public Vektor rata_per_kolom(Matriks m)
        {int klm=m.kolom;
         int brs=m.baris;
         double kerja;
         Vektor rata_kolom=new Vektor(klm);
         for(int j=0;j<klm;j++){
            kerja=0.0;
            for(int i=0;i<brs;i++) kerja=kerja+m.mat[i][j]/(double)brs;
            //System.out.println("kerja di mean per kolom : "+kerja);
            rata_kolom.elemen(kerja,j);
            //out.format(rata_kolom.elemen(kerja,j));
            }
         return rata_kolom;
        }
   public Vektor rata_per_baris(Matriks m)
        {int klm=m.kolom;
         int brs=m.baris;
         double kerja;
         Vektor rata_baris=new Vektor(brs);
         for(int i=0;i<brs;i++) {
            kerja=0;
            for(int j=0;j<klm;j++) kerja=kerja+m.mat[i][j]/klm;
            rata_baris.elemen(kerja,i);
            }
         return rata_baris;
        }
   public Vektor ambil_baris(Matriks m, int b_ke)
        {int klm=m.kolom;
         //int brs=m.baris;
         double kerja=0;
         Vektor vekt_baris=new Vektor(klm);
         for(int j=0;j<klm;j++)
            {
             kerja=m.mat[b_ke][j];
             vekt_baris.elemen(kerja,j);
            }
         return vekt_baris;
        }
   public void ganti_baris(Matriks m,Vektor v_ganti, int b_ke)
        {int klm=m.kolom;
         int brs=m.baris;
         //int uk_v=v_ganti.size();
         double kerja=0;     
         for(int j=0;j<klm;j++){
             m.elemen(v_ganti.ambil(j),b_ke,j);
            }
        }
   public Vektor ambil_kolom(Matriks m, int k_ke)
        {int bar=m.baris;
         //int brs=m.baris;
         double kerja=0;
         Vektor vekt_kolom=new Vektor(bar);
         for(int j=0;j<bar;j++)
            {
             kerja=m.mat[j][k_ke];
             vekt_kolom.elemen(kerja,j);
            }
   //System.out.println("vek_kolom : ");
  // vekt_kolom.tampil();
         return vekt_kolom;
        }
  public Matriks ambil_2baris(Matriks mat1, int brs_awal)
        {int klm=mat1.kolom;
         //int brs=m.baris;
         double kerja=0;
         Matriks mat_2baris=new Matriks(2,klm);
         int itung=0;
         for(int imat=brs_awal;imat<(brs_awal+2);imat++){
            for(int j=0;j<klm;j++)
                {
                kerja=mat1.mat[imat][j];
                mat_2baris.elemen(kerja,itung,j);
                }
            itung++;
         }
         //System.out.println("mat_baris : ");
        // mat_baris.tampil_10();
        //System.out.println();
         return mat_2baris;
        }
  /*
   *  Mengambil n baris dari matriks mat2 dimulai dari baris ke-brs_mulai    
   */
  public Matriks ambil_nbaris(Matriks mat2,int n, int brs_mulai)
        {int klm=mat2.kolom;
         //int brs=m.baris;
         double kerja=0;
         Matriks mat_nbaris=new Matriks(n,klm);
         int itung=0;
         for(int imat=brs_mulai;imat<(brs_mulai+n);imat++){
            for(int j=0;j<klm;j++)
                {
                kerja=mat2.mat[imat][j];
                mat_nbaris.elemen(kerja,itung,j);
                }
            itung++;
         }
    //System.out.println("mat_nbaris : ");
    //mat_nbaris.tampil_10();
        //System.out.println();
         return mat_nbaris;
        }
  public Vektor var_per_kolom(Matriks m)
        {int klm=m.kolom;
         int brs=m.baris;
         Vektor var_kol=new Vektor(klm);
         double kerja;
         m=m.sentralisasi(m);
         for(int j=0;j<klm;j++){
            kerja=0;
            for(int i=0;i<brs;i++)
                kerja=kerja+Math.pow(m.mat[i][j],2)/(brs-1);
            var_kol.elemen(kerja,j);
            }
         return var_kol;
        }
   public Matriks sentralisasi(Matriks m)
        {int klm=m.kolom;
         int brs=m.baris;
         double kerja;
         Matriks hasil=new Matriks(brs,klm);
         Vektor rata_kolom=new Vektor(klm);
         rata_kolom=rata_per_kolom(m);
         for(int i=0;i<brs;i++)
            for(int j=0;j<klm;j++){
              hasil.mat[i][j]=m.mat[i][j]-rata_kolom.ambil(j);
            }
         return hasil;
        }
   public Matriks normalisasi(Matriks m)
        {int klm=m.kolom;
         int brs=m.baris;
         double kerja;
         Matriks hasil=new Matriks(brs,klm);
         Vektor v_kolom=new Vektor(klm);
         v_kolom=var_per_kolom(m);
         m=m.sentralisasi(m);
         for(int i=0;i<brs;i++)
            for(int j=0;j<klm;j++){
              hasil.mat[i][j]=m.mat[i][j]/v_kolom.ambil(j);
            }
         return hasil;
        }
   public Matriks transpose(Matriks m)
        {int klm=m.kolom;
         int brs=m.baris;
         Matriks hasil=new Matriks(klm,brs);
         for(int i=0;i<brs;i++)
            for(int j=0;j<klm;j++){
              hasil.mat[j][i]=m.mat[i][j];
            }
         return hasil;
        }
       /*
     *  kel_ke --> nilai 0 berarti kelompok 1
     *             nilai 1 berarti kelompok 2
     *  m2 --> matriks data
     *  v_brs --> baris ke ... dari mat populasi : yang berisi kelompok
     *            per object
     *  kel_ke --> kelompok ke ...
     *
        * Menghasilkan matriks yang isinya : object-object yang masuk kelompok
        * ke kel_ke
     */
    public Matriks mat_kelompok(Matriks m2,Vektor v_brs,int jlh_kel,int kel_ke)
        {
         int kol_kel=m2.kolom();
         int brs_kel=m2.baris();
         //int el_v=v_brs.size();
         //vektor v_kerja=new vektor(el_v);
         //int jlh_clust=(int)v_brs.elemen_max(v_brs)+1;
         Vektor v_kel=new Vektor(jlh_kel);
         v_kel=v_kel.jlh_kelompok(v_brs,jlh_kel);
 //boolean cekq=v_kel.cek_ada_null(v_brs,jlh_kel);
 //System.out.println("awal mat_kelompok --> v_kel memuat NULL : "+cekq);
 // System.out.println("fct mat_kelompok --> v_brs : ");
 // v_brs.tampil();
 // System.out.print("fct mat_kelompok --> v_kel : ");
 // v_kel.tampil();
         int puter=(int)v_kel.ambil(kel_ke);
//  System.out.println("fct mat_kelompok -->kel_ke, puter : "+kel_ke+", "+puter);
         Matriks m_kel=new Matriks(puter,kol_kel);
         Vektor v_indeks=new Vektor(puter);
         int ketemu;
         int id=0;
         for(int cari=0;cari<brs_kel;cari++){
                    ketemu=0;
                    if(v_brs.ambil(cari)==kel_ke) {
                        ketemu=cari;
                        v_indeks.elemen(ketemu,id);
                        id++;
                        }
                }
         /*
        System.out.print("v_brs : ");
        v_brs.tampil();
        System.out.print("v_indeks : ");
        v_indeks.tampil();
          */
       // System.out.println("puter, kol : "+puter+", "+kol_kel);
         double kerja=0;
         for(int i_kel=0;i_kel<puter;i_kel++){
            for(int j_klp=0;j_klp<kol_kel;j_klp++){
                //System.out.println("kel, klp : "+kel+", "+klp);
                kerja=m2.ambil((int)v_indeks.ambil(i_kel), j_klp);
                m_kel.elemen(kerja,i_kel,j_klp);
            }
         }
   // System.out.println("fct mat_kelompok --> m_kelompok : ");
   // m_kel.tampil();
         return m_kel;
        }
    /*
     *      m2 --> matriks anak hasil crossover
     *      jlh_kel --> banyaknya kelompok
     */
  public Matriks cek_ada_null(Matriks m2,int jlh_kel)
        {
         int kol_cek=m2.kolom();
         int brs_cek=m2.baris();
         Vektor v_kerja=new Vektor(kol_cek);
         Vektor v_indeks=new Vektor(brs_cek);
   // System.out.println("fct cek_ada_null --> mat asli : ");
   // m2.tampil();
         boolean ketemu;
         double kerja;
         int id=0;
         for(int i=0;i<brs_cek;i++){
             for(int j=0;j<kol_cek;j++){
                 v_kerja.elemen(m2.ambil(i,j), j);
                }
             ketemu=v_kerja.cek_ada_null(v_kerja, jlh_kel);
             if(ketemu)  v_indeks.elemen(0, i);
                else {v_indeks.elemen(1, i); id++;}
             }
 // System.out.println("fct cek_ada_null (class matriks), brs_cek ; "+ brs_cek+
 //              " --> vektor indeks dari mat null : ");
//      v_indeks.tampil();
       int muter=0;
        Matriks m_baru=new Matriks(id,kol_cek);
        for(int i=0;i<brs_cek;i++){
             if(v_indeks.ambil(i)==1){
                for(int j=0;j<kol_cek;j++){
                    m_baru.elemen(m2.ambil(i,j),muter, j);
                    }
                muter++;
                }
             }
   // System.out.println("fct cek_ada_null --> mat not null : ");
   // m_baru.tampil();
         return m_baru;
        }
   public Matriks gabung_mat_mat(Matriks m1, Matriks m2)
        {
        int bar1=m1.baris;
        int bar2=m2.baris;
        int kol1=m1.kolom;
        int kol2=m2.kolom;
        int bar_gab=bar1+bar2;
        Matriks mat_gabung=new Matriks(bar_gab,kol1);
        if(kol1!=kol2){
            System.out.println("kolom matriks 1 dan 2 tidak sama !");
            System.out.println("proses tidak dapat dilakukan !");
            return mat_gabung;
            }
        double kerja_gab;
        int puter2=0;
        //boolean terus=false;
        for(int i_gab=0;i_gab<bar_gab;i_gab++){
          for(int j_gab=0;j_gab<kol1;j_gab++){
//System.out.println("i_gab, j_gab : "+i_gab+", "+j_gab);
            if(i_gab<bar1) kerja_gab=m1.ambil(i_gab,j_gab);
                else {
//System.out.println("i_gab, puter2 , j_gab : "+i_gab+", "+puter2+", "+j_gab);
                kerja_gab=m2.ambil(puter2,j_gab);
                //terus=true;
                }
            mat_gabung.elemen(kerja_gab,i_gab,j_gab);
            }
          if(i_gab>=bar1) puter2++;
          }
        //System.out.println("mat_gabung : ");
        //mat_gabung.tampil_10();
        return mat_gabung;
        }
   /*
    *  Menambah matriks mat1 dengan satu kolom paling kanan yang diisi
    *  dengan vek1
    */
   public Matriks tambah_1kolom_mat(Matriks mat1, Vektor vek1)
        {
        int bar1=mat1.baris;
        int kol1=mat1.kolom;
        int kol=kol1+1;
        int u_vek=vek1.size();
        Matriks mat_gabung=new Matriks(bar1,kol);
        double kerja_gab;
        for(int i_gab=0;i_gab<bar1;i_gab++){
          for(int j_gab=0;j_gab<kol1;j_gab++){
              kerja_gab=mat1.ambil(i_gab,j_gab);
              mat_gabung.elemen(kerja_gab,i_gab,j_gab);
            }
        }
        for(int i_gab=0;i_gab<bar1;i_gab++){
              kerja_gab=vek1.ambil(i_gab);
              mat_gabung.elemen(kerja_gab,i_gab,kol1);
            }
        //System.out.println("mat_vekt_gabung : ");
        //mat_gabung.tampil_10();
        return mat_gabung;
        }
   public Matriks tambah_1baris_mat(Matriks mat1, Vektor vek1)
        {
        int bar1=mat1.baris;
        int kol1=mat1.kolom;
        int bar=bar1+1;
        int u_vek=vek1.size();
        Matriks mat_gabung2=new Matriks(bar,kol1);
        double kerja_gab;
        for(int i_gab=0;i_gab<bar1;i_gab++){
          for(int j_gab=0;j_gab<kol1;j_gab++){
              kerja_gab=mat1.ambil(i_gab,j_gab);
              mat_gabung2.elemen(kerja_gab,i_gab,j_gab);
            }
        }
        for(int j_gab=0;j_gab<kol1;j_gab++){
              kerja_gab=vek1.ambil(j_gab);
              mat_gabung2.elemen(kerja_gab,bar,j_gab);
            }
        //System.out.println("mat_vekt_gabung : ");
        //mat_gabung.tampil_10();
        return mat_gabung2;
        }
   /*
    *   Membuat matriks baru dari matriks lama yang kolom ke- k_ke -nya
    *   dihilangkan --> matriks baru = matriks lama tanpa kolom ke- k_ke
    *   k_ke --> letak kolom yang akan dihilangkan
    */
   public Matriks kurang_1kolom_mat(Matriks mat1, int k_ke)
        {
        int bar1=mat1.baris;
        int kol1=mat1.kolom;
        //int kol=kol1-1;
        Matriks mat_kurang=new Matriks(bar1,kol1-1);
        double kerja_gab;
        int indeks;
        for(int i_gab=0;i_gab<bar1;i_gab++){
          indeks=0;
          for(int j_gab=0;j_gab<kol1;j_gab++){
              if(j_gab!=k_ke){
                 kerja_gab=mat1.ambil(i_gab,j_gab);
                 mat_kurang.elemen(kerja_gab,i_gab,indeks);
                 indeks++;
                }
            }
        }
        //System.out.println("mat_vekt_kurang : ");
       //mat_kurang.tampil_10();
        return mat_kurang;
        }
   /*
    *  Sort matriks berdasarkan kolom ke- kol_ke
    */
  public Matriks sort_mat(Matriks mat1, int kol_ke)
        {
        int bar1=mat1.baris;
        int kol1=mat1.kolom;
        Matriks mat_sort=new Matriks(bar1,kol1);
        Vektor v_indeks=new Vektor(bar1);
        Vektor v_ambil=ambil_kolom(mat1,kol_ke);
        //System.out.println("v_ambil : ");
        //v_ambil.tampil();
        v_indeks=v_indeks.indeks_sort_vektor(v_ambil);
        //System.out.println("v_ambil : ");
        //v_ambil.tampil();
        //System.out.println("v_indeks : ");
        //v_indeks.tampil();
        
        double kerja_baru;
        for(int i_gab=0;i_gab<bar1;i_gab++){
          for(int j_gab=0;j_gab<kol1;j_gab++){
              kerja_baru=mat1.ambil((int)v_indeks.ambil(i_gab),j_gab);
              mat_sort.elemen(kerja_baru,i_gab,j_gab);
            }
        }
       // mat1.tampil_10();
   //System.out.println("mat_sort : ");
   //mat_sort.tampil_10();
        return mat_sort;
        }
  public void sort_mat_ke_kecil(Matriks mat1, int kol_ke)
        {
        int bar1=mat1.baris;
        int kol1=mat1.kolom;
        Matriks mat_sort=new Matriks(bar1,kol1);
        Vektor v_indeks=new Vektor(bar1);
        Vektor v_ambil=ambil_kolom(mat1,kol_ke);
        v_indeks=v_indeks.indeks_sort_vektor(v_ambil);
        double kerja_baru;
        for(int i_gab=0;i_gab<bar1;i_gab++){
          for(int j_gab=0;j_gab<kol1;j_gab++){
              kerja_baru=mat1.ambil((int)v_indeks.ambil(i_gab),j_gab);
              mat_sort.elemen(kerja_baru,i_gab,j_gab);
            }
        }
        for(int i_gab=0;i_gab<bar1;i_gab++){
          for(int j_gab=0;j_gab<kol1;j_gab++){
              kerja_baru=mat_sort.ambil(i_gab,j_gab);
              mat1.elemen(kerja_baru,i_gab,j_gab);
            }
        }
       // mat1.tampil_10();
   //System.out.println("mat_sort : ");
   //mat_sort.tampil_10();
      }
  public Matriks hilangkan_vektor_nol_mat(Matriks mat1,int byk_kel)
        {
        int bar1=mat1.baris;
        int kol1=mat1.kolom;
        Vektor v_indeks=new Vektor(bar1);
        int tdk_nol=0;
        boolean cek;
        for(int i_hil=0;i_hil<bar1;i_hil++){
            Vektor v_ambil=ambil_baris(mat1,i_hil);
            cek=v_ambil.cek_ada_null(v_ambil,byk_kel);
            if(cek){
                v_indeks.elemen(0, i_hil);
                }  
            else {
                 tdk_nol++;
                 v_indeks.elemen(1, i_hil);
                 }
        }
        Matriks mat_hsl=new Matriks(tdk_nol,kol1);
        int muter=0;
        double kerja_baru;
        for(int i_hil=0;i_hil<bar1;i_hil++){
            if((int)v_indeks.ambil(i_hil)==1){
                for(int j_hil=0;j_hil<kol1;j_hil++){
                    kerja_baru=mat1.ambil(i_hil,j_hil);
                    mat_hsl.elemen(kerja_baru,muter,j_hil);
                }
            muter++;
            }
        }
  // System.out.println("hilangkan_vektor_nol_mat : ");
  // mat_hsl.tampil_10();
       return mat_hsl;
      }
}
