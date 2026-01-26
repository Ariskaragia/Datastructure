

import java.util.Comparator;

public class IntegerComparator implements Comparator{
    /*sykrinei an ena city einai meagyleto apo to allo mesv apo to compare to kai epistefei 1 an to t1<t2 allivs -1  */
    public int compare(Object t1, Object t2) {
        int k=-1;
         if(((City)t1).compareTo((City)t2)){
            k=1;
            
        }
        return k;
    }
}
