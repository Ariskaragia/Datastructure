/*p3220066 ARISTEIDHS KARAGIANNAKOS
 * p3220037 ELLY DANAZI
 */

import java.io.*;
import java.util.*;



public class DNAPalindrome {
    //complementary DNA code method
    static boolean flag = true;
      public static boolean complem(char x, char y){
        if((x =='A') && (y =='T') ||(x == 'T') && (y == 'A') ||(x =='C' && y =='G') ||(x == 'G' && y == 'C')){
            flag = true;
        }
        else{
            flag = false;
        }
        return flag;
        }
public static void main (String[] args) {
    //Standard input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter DNA code here, only A,T,C,G accepted");
        String dna = in.nextLine();
    if(dna.contains(" ")){
            System.out.println("Please enter DNA code with no spaces between the letters");
    }
    else{
    //dna String in an character array
        StringDoubleEndedQueue<String> q = new StringDoubleEndedQueueLmpl<>();
        char[] chars = dna.toCharArray();
        int fl = 0;
        int l = chars.length;//size of queue
        int m = l/2;

        //DNA string complementary
        for(int i=0; i<m; i++){
        char c2 = dna.charAt((l-1)-i);
        char c = dna.charAt(i);
            String op3 = String.valueOf(c);
            String op4 = String.valueOf(c2);
            if (!q.isEmpty()) {
                String op2 = q.removeFirst();
                q.addFirst(op3);
                q.addLast(op4);

            } else {

                q.addFirst(op3);
                q.addLast(op4);
            }
        
            if (complem(c, c2 )!= true){
               fl = 1;
            }
            
        }
        //print 
        if (fl == 0){
            System.out.println("The DNA code is Watson-Crick complemented palindrome");
        }
        else{
            System.out.println("The DNA code is not Watson-Crick complemented palindrome");
        }
    }


}}