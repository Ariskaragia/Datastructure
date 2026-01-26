import java.security.Key;
import java.util.Comparator;

public class PQ implements PriorityQueueInterface {
    public int llll=0;
    private Object[] heap;
    private int pos[]=new int[1000];
    private int size; 
    private Comparator comparator; 

    private static final int AUTOGROW_SIZE = 4; 

  
    public PQ(Comparator comparator,int k) {
        this.heap = new Object[k+ 1];
        this.size = 0;
        this.comparator = comparator;
    }


    public void insert(City item) {
        /*elegxvs an einai to size megalutero apo to 75% */
        if (size >= (heap.length - 1)*75/100)
        /*an einai megalvnoyme ton pinaka */
            grow();

        /*mesa ston pinaka kataxvroyme thn item  */
        heap[++size] = item;
        /*enas neos pinakas poy kataxvrei sthn uesh toy id to noymero size  */
        pos[item.getID()]=size;


        swim(size);
        llll++;
    }


    public Object peek() {

        if (size == 0)
            return null;


        return heap[1];
    }

    public Object getMin() {
        if (size == 0)
            return null;

        Object root = heap[1];

        heap[1] = heap[size];
        size--;


        sink(1);

        return root;
    }

    public City min() {
        /*epistofh tou mikroteroy stoixeioy */
        if (size == 0)
            return null;
        return (City)heap[1];
    }

    public City max(){
        if (size==0){
            return null;}
            /*an den einai kenos o pinakas kai exei toulaxoston 2 stoixeia tote kanoume anazhthsh toy megalutrou */
            /*kataxvro to max san to prvto stoixeio  */
        City maxx = (City)heap[1];
        for(int i =2;i<=size;i++){
            /*an to max<tou stoixeiou tote bale to max to stoixeio me thn loop pairnav apo ola ta stoixeia tou pinaka */
            if(maxx.compareTo((City)heap[i])){
                maxx=(City)heap[i];
            }
        }
        /*epestrece max */
        return maxx;
    
    }


    private void swim(int i) {
        if (i == 1)
            return;


        int parent = i / 2;

        while (i != 1 && comparator.compare(heap[i], heap[parent]) > 0) {
            swap(i, parent);
            i = parent;
            parent = i / 2;
        }

    }


    private void sink(int i) {

        int left = 2 * i;
        int right = left + 1;
        if (left > size)
            return;

        while (left <= size) {

            int max = left;
            if (right <= size) {
                if (comparator.compare(heap[left], heap[right]) < 0)
                    max = right;
            }

            if (comparator.compare(heap[i], heap[max]) >= 0)
                return;
            else {
                swap(i, max);
                i = max;
                left = i * 2;
                right = left + 1;
            }
        }
    }

    private void swap(int i, int j) {
    	Object tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }


    private void grow() {
        /*neos pinakas megalyteros kata 4 stoixeia kai janatopoueto ta prohgoume stoixeia se auton kai meta o palios ginetai o kainourgios */
    	Object[] newHeap = new Object[heap.length + AUTOGROW_SIZE];

       for (int i = 0; i <= size; i++) {
           newHeap[i] = heap[i];
       }
        
        heap = newHeap;
    }

    public String toString() {
        if (isEmpty())
            return "[]";
  
        String result = "";
        /*emfanizv mono to onoma apo kaue stoixeio tou pinaka meso enos loop */
        for (int i = 1; i <= size; i++) {
            result +=((City)heap[i]).toString()+"\n";
        }
        
        return result;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public City remove(int id){
        /*ejhghsh sto pdf */

        City c=(City)heap[pos[id]];
        heap[pos[id]]=heap[size];
        size--;
        sink(pos[id]);
        return c;   


    }

    public int size(){
        return size;
    }


    public City getItem(int i) {
        return (City)heap[i];
    }

 


        

    
    }
    




