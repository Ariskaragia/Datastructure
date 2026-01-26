import java.util.*;
import java.io.*;

class DynamicInfluenza_k_withPQ{
    
    public static PQ ReadFile_MerosG(PQ pq,String FileName,int k){
        BufferedReader reader = null;
        String line = "";
        int id = 0;
        String name = "";
        int population =0;
        int cases = -1;
        String[] data;
        int count;
        try {
            reader = new BufferedReader(new FileReader(new File(FileName)));
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
                    if (pq.size()==k){
                        if(pq.max().compareTo(c)==false){
                            pq.remove(pq.max().getID());
                            pq.insert(c);
                        }
                    }else if (pq.size()<k){
                        pq.insert(c);
                    }
                    
                }else{
                    System.out.print("Wrong file data");
                    break;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading line ...");
        }
        return pq;
    }

    public static void main(String[] args) {

        String l = args[0];
        int k = Integer.valueOf(l);
        String file = args[1];
        PQ pq = new PQ(new IntegerComparator(),k);
        pq=ReadFile_MerosG(pq,file, k);
        System.out.println("The top "+ k + " cities are: ");
        for(int i=0;i<k;i++){
            System.out.println((City)pq.getMin());
        }


    }


}