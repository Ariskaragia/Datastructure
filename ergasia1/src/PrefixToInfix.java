/*p3220066 ARISTEIDHS KARAGIANNAKOS
 * p3220037 ELLY DANAZI
 */

import java.util.*;
 
class PrefixToInfix{
    public static int count = 0;
    public static int countt = 0;
 
    
static    boolean ariumuitika_prajeis(char x) 
{
    switch(x)
    {
        case '+':
            
        case '-':
            
        case '*':
            
        case '/':
           
            return true;
    }
    return false;
}

static    boolean an_ariumoi(char x) 
{
    switch(x)
    {
        case '1':
        
        case '2':
      
        case '3':
      
        case '4':

        case '5':
        
        case '6':
      
        case '7':
      
        case '8':

        case '9':
        
        case '0':
      

            return true;
    }
    return false;
}
 

public static String convert(String str)
{
    StringDoubleEndedQueue<String> list = new StringDoubleEndedQueueLmpl<>();
     
   
    int l = str.length();
     
   
    for(int i = l - 1; i >= 0; i--)
    {
        char c = str.charAt(i);
        if (ariumuitika_prajeis(c))
        {
            String st = list.removeLast();
            String stt = list.removeLast();
             
           
            String y = "(" + st + c + stt + ")";
            list.addLast(y);
        } 
        else
        {
             
           
            list.addLast(c + ""); 
        }
    }
    return list.removeLast();
}
 
public static void main(String[] args)
{
    Scanner in = new Scanner(System.in);
    System.out.println("Give us the exp you want to enter");
    String exp= in.nextLine();
    boolean flagg= false;
    boolean flaggg=true;
    for(int i =0;i<exp.length();i++){
        char c = exp.charAt(i);
        if(ariumuitika_prajeis(c)){
            count++;
        }
        if(!(an_ariumoi(c)||ariumuitika_prajeis(c))){
            flaggg=false;
        }
    }
    for(int i =0;exp.length()-2+i<exp.length();i++){
        char c = exp.charAt(exp.length()-1-i);
        if(an_ariumoi(c)){
            countt++;
        }
    }
    if ((count==2||count>exp.length()-2-count)){
        flagg=true;
    }
    if(exp.length()-count==count+1&&flagg&&flaggg)
    System.out.println("Infix : " + convert(exp));
    else{
        System.out.println("the infix that you put is wrong");
    }
}
}