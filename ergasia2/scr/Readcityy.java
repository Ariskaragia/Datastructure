import java.util.*;
import java.io.*;

class Readcityy{
    public static int length=0;
    public City[] queue= new City[500];
    public void ReadFile(String path){
    BufferedReader reader = null;
        String line="";
        int ID=0;
        String name="";
        int population=0;
        int InfluenzaCases=0;
        int count;

       
    

        try {
            /*diabazoume to arxeio grammh grammh  */
            File obj = new File(path);
			Scanner scanner = new Scanner(obj);

			while (scanner.hasNextLine()) {
                /*afou diabasoume thn gramh apouhkeuoume ta stoixeia se anan pinaka tis grammhs kaue foara poy briskei keno */
                line=scanner.nextLine();
                String[] arr=line.split(" ");
                count=0;
                for (String a : arr){
                    try{
                        /*an einai ariumos tote to bazoyme sto katalilo kataxvritei   */
                        int number=Integer.valueOf(a);
                        count++;
                        if(count==1){
                            ID= number;
                        }
                        else if(count==2){
                            population=number;
                        }
                        else if(count==3){
                            InfluenzaCases=number;
                        }

                    } catch(NumberFormatException e){
                        /*an den einai ariumos tote to apouhkeuoyme sto onoma tis poleis kai to prosuetei kaue fora ekei poy briskei xaraktira kai einai anamesa sto id kai to population */
                        if(count<2){
                        name=name+" "+a;
                        }
                    }
                }
                if ((ID>=1 && ID<=999) && (name.length()<=50) && (population>0 & population<=10000000)){
                        City obb=new City(ID,name,population,InfluenzaCases);
                        queue[length]=obb;
                        length++;
                        name="";}
			}
            

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    
    
    
    }
}



 

    
	



