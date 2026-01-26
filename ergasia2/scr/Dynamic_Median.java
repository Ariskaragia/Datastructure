import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Dynamic_Median {

    public static double median=0.0; 
    public static void main(String[] args) {
        PQ pq = new PQ(new IntegerComparator(), 5);
        PQ minheap = new PQ(new IntegerComparator(),5);
        String file = args[0];
        int k =5;
        int count=0;

        
            BufferedReader reader = null;
            String line = "";
            int id = 0;
            String name = "";
            int population =0;
            int cases = -1;
            String[] data;
            try {
                reader = new BufferedReader(new FileReader(new File(file)));
                line = reader.readLine();
                while (line != null) {
                    data = line.split(" ");
                    count=0;
                    for (String d : data){
                        try{
                            int number=Integer.parseInt(d);
                            count++;
                            if(count==1){
                                id= number;
                            }
                            else if(count==2){
                                population=number;
                            }
                            else if(count==3){
                                cases=number;
                            }
    
                        } catch(NumberFormatException e){
                        
                            name=name+" "+d;
                            
                        }
                    }
                    
                    if ((id>=1 && id<=999) && (name.length()<=50) && (population>0 & population<=10000000) && (cases<=population) ){
                        City c = new City(id, name, population, cases);
                        name="";
                        minheap.insert(c);
                        if (pq.size()==k){
                            /*pairnv to magalytero stoixeio mexri stigmhs kai meta to sygkrinv me to current antikeimeno an einai mikrotero diagarfei toy palioteroy kai insert tou kainourgiou */
                            if(pq.max().compareTo(c)==false){
                                pq.remove(pq.max().getID());
                                pq.insert(c);
                            }
                        }else if (pq.size()<k){
                            pq.insert(c);
                            count++;
                        }
                        
                    }else{
                        System.out.print("Wrong file data");
                        break;
                    }
                    if(minheap.llll%5==0){
                    /*ana 5 poy prosuetontai emaginse sthn median me tous kainoyrgioy mesous orous */
                    System.out.println(median=Median(minheap));}                   
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("Error reading line ...");
            }
    }   
private static double Median(PQ heap) {
        if (heap.size() % 2 != 0){
            /*an ta stoixeia tou pinaka einai peritos ariumos tote  */
            for (int i = 0; i<(heap.llll-1)/2;i++){
                /*diagace ta stoixeia tou pinaka mexri to proteleftaio mexri thn mesh  */
                if(heap.llll-1!=1){
                    heap.getMin();}
            }
            median = ((City)heap.getMin()).calculateDensity();
            /*kai emfanise to to calculation density tou mesaiou stoixeiou */
            return median;
        }
        else{
            /*an einai zygos ariumos to sizw */
            for (int i = 0; i<(heap.llll)/2;i++){
                /*diagrafv mexri ta 2 tealyta mesai stoixeia prin  */
                if(heap.llll!=2){
                heap.getMin();}
            }
            /*pairnv ta dyo taleutai stoia ta sykrinv kai pairnv to mikrotero */
            double root = ((City)heap.getMin()).calculateDensity();
            double root2 = ((City)heap.getMin()).calculateDensity();

            if(root>root2){
                return root2;
            }
            else{
                return root;
            }

        }
        
    
}
}