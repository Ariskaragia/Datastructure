import java.io.File;
import java.util.*;
/*ejigisei sto pdf */
public class Influenza_k {
    static int partition(City[] a, int p, int r)
    {
        City larg = a[r];
        int i = (p - 1);
 
        for (int j = p; j <= r - 1; j++) {
            if(a[j].compareTo(larg))  {
                i++;
                City exch = a[i];
                a[i] = a[j];
                a[j] = exch;
                
            }
        }
        City exch = a[i+1];
        a[i+1] = a[r];
        a[r] = exch;
        return (i + 1);
    }
 
    public static void quicksort(City[] a, int p, int r){
        if (r <= p) return;
        else{
        int i = partition(a, p, r);
        quicksort(a, i+1, r);
        quicksort(a, p, i-1);
        } 
    }

    public static void main(String[] args) {
        /*h l pairnei thn timh k apo thn cmd  */
        String l = args[0];
        int number = Integer.valueOf(l);
        /*diabazv to txt kai to topouetv se ena pinaka */
        Readcityy app = new Readcityy();
        String file = args[1];
		app.ReadFile(file);
        City []products = new City[2*number];
        products = app.queue;
        int k=app.length;
        /*to taxinomo */
        quicksort(products,0,k-1);
        if(number>0){
        System.out.println("The top "+ number + " cities are:");
        for(int i=0;i<number&&number>0;i++){
            System.out.println(products[i].toString());
        }}
        if(number<=0){
            System.out.println("You put a number that is higher from the towns");
        }
}


        
    }

