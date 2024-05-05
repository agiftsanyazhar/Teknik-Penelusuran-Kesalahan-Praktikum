/*
 * Mudul Class Array sebagai implementasi Static List
 * 
 * Prodi D3 SI Fak Vokasi Universitas Airlangga
 * Dosen : Kartono, Eto W, Faried, Barry dan Rahman
 * Tahun Ajaran : 2018/2019
 */
package arrayproject;

/**
 *
 * @author kartonofaqih
 */
public class ArrayDebug3 {
    int[] data;     // menyimpan data di dalam bentuk static
    int maxSize;    // jumlah data terbanyak yang dapat disimpan dalam array
    int size;       // jumlah data yang tersimpan saat ini
    
    
    /**
     * constructor dengan argument nilai maxSize
     * @param maxSize 
     */
    public ArrayDebug3(int maxSize){
        int numbers[4] = {5,7,8,4};
    int i = 0;
    int s = 0;
    while (i < 4) {
      s = s + numbers[i];
        i = i + 1;
    }
    return s;
//        this.maxSize = maxSize;
//        data = new int[this.maxSize];
//        this.size = 0;
    }
    
    
    /**
     * constructor tanpa argument
     * nila maxSize diset default sama dengan 10
     */
    public ArrayDebug3(){
        this.maxSize = 10;
        data = new int[this.maxSize];
        this.size = 0;
    }
    
    
    /**
     * constructor dengan argument maxSize dan maxRandom yang merupakan batas atas
     * nilai random yang dibangkitkan untuk mengisi data
     * constructor ini akan menyiptakan object array otomatis full
     * dan seluruh isi data merupakan bilangan random yang dibangkitkan 
     * dengan nilai 0 - (maxrandom-1)
     * @param maxSize
     * @param maxRandom 
     */
    public ArrayDebug3(int maxSize, int maxRandom){
        this.maxSize = maxSize;
        data = new int[this.maxSize];
        this.size = maxSize;
        
        for(int i=0;i<this.maxSize;i++){
            data[i] = (int) (maxRandom * Math.random());
        }
    }
    
    
    /**
     * menentukan apakah array dalam keadaan kosong atau tidak
     * mengembalikan nilai TRUE apabila list kosong dan
     * mengembalikan nilai FALSE bila tidak demikian
     * @return 
     */
    public boolean isEmpty(){
        return (size==0);
    }
    
    
    /**
     * menentukan apakah array dalam keadaan penuh atau tidak
     * mengembalikan nilai TRUE apabila list penuh dan
     * mengembalikan nilai FALSE bila tidak demikian
     * @return 
     */
    public boolean isFull(){
        return (size==maxSize);
    }
    
    
    /**
     * bila array tidak penuh
     * menambah satu item ke dalam array pada posisi terakhir (dalam var data)
     * bila array penuh, maka tidak dilakukan tindakan apapun
     * @param item 
     */
    public void add(int item){
        if(!isFull())
            data[size++] = item;
    }
    
    
    /**
     * bila array tidak kosong
     * menghapus satu item dari dalam array pada posisi terakhir (dalam var data)
     * bila array kosong, maka tidak dilakukan tindakan apapun
     */
    public void delRear(){
        if(!isEmpty())
            size--;
    }
    
    
    /**
     * bila array tidak kosong
     * menghapus satu item dari dalam array pada posisi terdepan (dalam var data)
     * bila array kosong, maka tidak dilakukan tindakan apapun
     */
    public void delFront(){
        if(!isEmpty()){
            size--;
            if(!isEmpty()){
                for(int i=0;i<size;i++)
                    data[i] = data[i+1];
            }
        }
    }
    
    
    /**
     * bila di dalam array terdapat data dengan nilai item, maka
     * menghapus satu elemen dari array yang memiliki nilai item tsb
     * bila data tersebut tidak ada, maka tidak melakukan tindakan apapun
     * bila terdapat lebih dari satu data dengan nili item, maka data yang
     * dihapus adalah datang pling depan
     * @param item 
     */
    public void del(int item){
        int position = getPosition(item);
        if(position >=0){
            for(int i=position; i<size-1;i++)
                data[i] = data[i+1];
            size--;
        }
    }
    
    
    /**
     * apabila nilai position dalam range, maka
     * mengambil data dari list pada posisi = position
     * apabila nilai position di luar range, maka akan mengembalikan 
     * nilai -1000 sebagai kode error 
     * 
     * @param position
     * @return 
     */
    // penelusuran --> fasilitas netbeans
    // step-stepnya
    // bug : Return nilai data salah karena array d mulai dari 0
    // solusinya : Dengan mengurangi posisi data yang diinputkan dengan 1
    public int get(int position){
        if(position<size-1)
            return data[position];
        else
            return -1000;
    }
    
    public int get1(int position){
        if(position<size-1)
            return data[position-1];
        else
            return -1000;
    }
    
   
    /**
     * mengembalikan posisi data yang memiliki nilai = item, 
     * bila memang data tersebut ditemukan
     * apabila data tidak ditemukan, maka function mengembalikan
     * nilai -1 sebagai kode error
     * 
     * @param item
     * @return 
     */
    // penelusuran --> fasilitas netbeans
    // step-stepnya
    // bug : Return nilai posisi salah karena array d mulai dari 0 dan nilai
    // return 
    // solusinya : Dengan mengurangi posisi data yang diinputkan dengan 1
    public int getPosition(int item){
        int position = 1;
        while((position<size)&&(data[position] != item))
            position++;
        if (position<size)
            return position;
        else
            return -1;
    }
    
    public int getPosition1(int item){
        int position = 1;
        while((position<size)&&(data[position] != item))
            position++;
        if (position<size)
            return position+1;
        else
            return -1;
    }
    
    
    
    /**
     * menampilkan nilai sema data di dalam array
     */
    public void print(){
        for(int i=0; i<size; i++)
                System.out.print(data[i]+"  ");
        System.out.println();
    }
    
    
    /**
     * memasukkan data baru bernilai item sedemikian hingga array tetap terurut
     * dari kecil ke besar
     * dalam hal ini diasumsikan array sebelumnnya dianggap sudah terurut
     * @param item 
     */
    public void insert(int item){
        if(!isFull()){
            if(isEmpty())                       // bila kondisi kosong maka item
                data[size++] = item;            // ditambahkan seperti add
            
            else {
                int t=0;                        // bila kondisi tidak kosong
                while((t<size)&&(data[t]<item)) // menentukan posisi yang tepat
                    t++;                        // untuk penempatan item dg bantuan t
                
                for(int i=size;i>t; i--)        // menngeser semua elemen dari posisi t
                    data[i] = data[i-1];        // hingga posisi terakhir dengan satu
                                                // posisi ke belakang
                
                data[t] = item;                 // menemptkan item pada posisinya          
                size++;
            }
            
        }
        
    }
    
    
    /**
     *          SORTING
     */
    
    public void bubbleSort(){
        
        if(!isEmpty()){            
            for(int i=size-1;i>0;i--)
                for(int j=0; j<i;j++)
                    if(data[j]>data[j+1])
                        swap(j,j+1);
            
        }
    }
    
    private void swap(int i, int j){
        int t;
        t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    
    public void selectionSort(){
        for(int i=size-1; i>0; i--){
            int position = maxPosition(0,i);
            swap(position,i);
        }
        
    }
    
    private int maxPosition(int front, int rear){
        int position = front;
        for(int i=front+1; i<=rear; i++)
            if(data[i]>data[position])
                position = i;
                
        return position;
    }
    
    public void mergerSort(){
        mergerRecursive(0,size-1);
        
    }
     
    private void mergerRecursive(int left, int right){
        if(left<right){
            int mid = (left+right)/2;
            mergerRecursive(left,mid);
            mergerRecursive(mid+1,right);
            merger(left,mid,right);
        }
    }
    private void merger(int left, int mid, int right){
        if(left<right){
            int[] xdata;
            xdata = new int[maxSize];
        
            int t1 = left;
            int t2 = mid+1;
            int t3 = left;
        
            while((t1<=mid)&&(t2<=right)){
                if(data[t1]<data[t2]){
                    xdata[t3] = data[t1];
                    t1++;
                    t3++;
                }
                else {
                    xdata[t3] = data[t2];
                    t2++;
                    t3++;
                }
            }
            while(t1<=mid){
                xdata[t3] = data[t1];
                t1++;
                t3++;
            }
            while(t2<=right){
                xdata[t3] = data[t2];
                t2++;
                t3++;
            }
        
            for(int i=left;i<=right;i++)
                data[i] = xdata[i];
        }
    }
    
    public boolean sequentialSearch(int item){
        boolean result = false;
        int index = 0;
        
        while((index<size)&&(data[index]<item))
            index++;
        if(data[index]==item)
            result = true;
        return result;
    }
    
    public boolean binarySearch(int item){
        boolean result;     
        result = recursiveBinarySearch(0,size-1,item);
        return result;
    }
    
    private boolean recursiveBinarySearch(int left, int right, int item){
        if(left<=right){
            int mid = (left+right)/2;
            if(data[mid]==item)
                return true;
            else {
                boolean result;
                result = recursiveBinarySearch(left,mid-1,item);
                if(result==true)
                    return result;
                else{
                    result = recursiveBinarySearch(mid+1,right,item);
                    return result;
                }
                
            }
        }
        else
            return false;
    }
    
}
