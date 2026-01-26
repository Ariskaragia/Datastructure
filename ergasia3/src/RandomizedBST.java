import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
/* ARISTEIDIS KARAGIANNAKOS P3220066
ELLI DANEZI P3220037*/
public class RandomizedBST implements TaxEvasionInterface {
    public static int  count=0;
    public static int  countt=0;

        private class TreeNode {

            private LargeDepositor item;
            private TreeNode left; // pointer to left subtree
            private TreeNode right; // pointer to right subtree
            private int N; // number of nodes in the subtree rooted at this TreeNode
    
            public TreeNode(LargeDepositor item) {
                this.item = item;
                this.left = null;
                this.right = null;
                this.N = 1; // initialized as 1 for the current node
            }
    
            public int key() {
                return item.key();
            }
    
            public LargeDepositor getItem() {
                return item;
            }
    
            public void setItem(LargeDepositor item) {
                this.item = item;
            }
    
            public TreeNode getLeft() {
                return left;
            }
    
            public void setLeft(TreeNode left) {
                this.left = left;
            }
    
            public TreeNode getRight() {
                return right;
            }
    
            public void setRight(TreeNode right) {
                this.right = right;
            }
    
            public int getN() {
                return N;
            }
    
            public void setN(int N) {
                this.N = N;
            }
           
        }

        TreeNode root;

    public RandomizedBST() {
        this.root = null;
    }

    public void insert(LargeDepositor item) {
        count++;
        if (root == null)
            root = new TreeNode(item);

        TreeNode current = root;

        while (true) {
            if (current.getItem() == item)
                return;

            if (current.getItem().key() -item.key() < 0) {
                if (current.getRight() == null) {
                    current.setRight(new TreeNode(item));
                    return;
                } else {
                    current = current.getRight();
                }
            } else {
                if (current.getLeft() == null) {
                    current.setLeft(new TreeNode(item));
                    return;
                } else {
                    current = current.getLeft();
                }
            }
        }
    }

    

    public void load(String path,RandomizedBST bst){
        BufferedReader reader = null;
        String line="";
        int AFM=0;
        String name="";
        String Firstname="";
        String Lastname="";
        double savings=0.0;
        double taxedIncome=0.0;
        int count;
            try {
            File obj = new File(path);
			Scanner scanner = new Scanner(obj);

			while (scanner.hasNextLine()) {
                
                line=scanner.nextLine();
                String[] arr=line.split(" ");
                count=0;
                for (String a : arr){
                        count++;
                        if(count==1){
                            int number=Integer.valueOf(a);
                            AFM= number;
                        }
                        else if(count==2){
                            Firstname=a;
                        }
                        else if(count==3){
                            Lastname=a;
                        }
                        else if(count==4){
                            double numbe=Double.valueOf(a);
                            savings=numbe;
                        }
                        else if(count==5){
                            double numbe=Double.valueOf(a);
                            taxedIncome=numbe;
                        }


                }
                        LargeDepositor obb=new LargeDepositor(AFM,Firstname, Lastname, savings, taxedIncome);
                        bst.insert(obb);
                        
			}
            

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    
    
    
    }
        public boolean search(LargeDepositor item) {
                TreeNode current = root;
                while (true) {
                    if (current == null)
                        return false;

                    if (current.getItem().equals(item))
                        return true;

                    if (current.getItem().key()- item.key() < 0)
                        current = current.getRight();
                    else
                        current = current.getLeft();
                }
            }
            public LargeDepositor searchByAFM(int key) {
                TreeNode current = root;
                while (true) {
                    if (current == null){
                        return null;}
        
                    if (current.item.key()==key)
                        return current.item; 
        
                    if (current.item.key()-key < 0)
                        current= current.right;
                    else
                        current = current.left;
                }
            }
    public void updateSavings(int AFM, double savings){
        TreeNode current = root;
        if(current.item==null){
            System.out.println("fail could not find the afm ");}
        else{
            current.item.setsavings(savings);
            
            System.out.println("success");}
    }

    public StringDoubleEndedQueueLmpl<LargeDepositor> searchByLastName(String last_name) {
        StringDoubleEndedQueueLmpl<LargeDepositor> list = new StringDoubleEndedQueueLmpl<>();
        loop(root, list, last_name);
        return list;
               
    }
    public void loop(TreeNode h, StringDoubleEndedQueueLmpl<LargeDepositor> list, String last_name){
        if (h!=null){
            if (h.item.getlastName().equals(last_name)){
                list.addFirst(h.item);
            }
            loop(h.left,list,last_name);
            loop(h.right,list,last_name);
        }
    }


    public void remove(int key) {
        // find node to delete and its parent
        TreeNode current = root;
        TreeNode parent = null;
        LargeDepositor item = searchByAFM(key);
        count--;
        while (true) {
            if (current == null)
                return;

            if (current.getItem().equals(item))
                break;

            parent = current;

            if (current.item.key()- item.key() < 0)
                current = current.getRight();
            else
                current = current.getLeft();
        }

        // node to replace with
        TreeNode replace = null;

        // only right
        if (current.getLeft() == null)
            replace = current.getRight();
        else if (current.getRight() == null)
            replace = current.getLeft();
        else {
            // find left most child of current right subtree!
            TreeNode findCurrent = current.getRight();

            while (true) {
                if (findCurrent.getLeft() != null)
                    findCurrent = findCurrent.getLeft();
                else
                    break;
            }

            // only has zero or one child (there is no left child!!!)
            remove(findCurrent.getItem().key());

            findCurrent.setLeft(current.getLeft());
            findCurrent.setRight(current.getRight());

            replace = findCurrent;
        }
        // replace parents reference

        if (parent == null) { //root
            root = replace;
        } else {
            if (parent.getLeft() == current)
                parent.setLeft(replace);

            if (parent.getRight() == current)
                parent.setRight(replace);
        }
    }
    double mean=0.0;
    public double getMeanSavings(){
        mean=0.0;
        loop(root);
        return mean/count;
    }


    public void loop(TreeNode h){
        if (h!=null){
            mean+=h.item.gettaxedIncome();
            
            
            loop(h.left);
            loop(h.right);
        }
        }


        public void secondloop(TreeNode h,int k,LargeDepositor sort[]){
            if (h!=null){
                    countt++;
                    sort[countt-1]=h.item;
                secondloop(h.left, k, sort);
                secondloop(h.right, k, sort);
        
                
            }   
            }
            
        
        
        
        
        public void printTopLargeDepositors(int k){
           LargeDepositor  sort[]= new LargeDepositor[8];
           countt=0;
           secondloop(root, k, sort);
           for (int i=0;i<=countt-1;i++){
            for(int j=countt-1;j>i;j--){
                if(sort[j].gettaxedIncome()<8000.0){
                    LargeDepositor item= sort[j];
                    sort[j]=sort[j-1];
                    sort[j-1]=item;
                }else{
                    if(sort[j].getsavings()-sort[j].gettaxedIncome()<sort[j-1].getsavings()-sort[j-1].gettaxedIncome()){
                        LargeDepositor item= sort[j];
                        sort[j]=sort[j-1];
                        sort[j-1]=item;
                    }
        
                }}
                
            }
            if(k>countt){
                k=countt;
                System.out.println("there are only "+countt +" elements");
            }
           for (int i=0; i<k; i++) {
            System.out.println(sort[i].toString());
           }
        
        
        }

        public  void print(TreeNode h) {
            if (h.left != null) {
                print(h.left);
            }
            System.out.println(h.item.toString());
            if (h.right != null) {
                print(h.right);
            }
        }

        
        
        public void printByAFM() {
            print(root);
        }
           

        




    


    public static void main(String[] args) {

        RandomizedBST bst = new RandomizedBST();

        
    
        boolean f =true;
        while(f){
                    System.out.println(" 1.insert \n 2.load names from a file \n 3.update savings from an AFM \n 4.Search AFM \n 5. search by lastname \n 6. remove by AFM \n 7. getMeanSavings \n 8.printTopLargeDepositors \n 9.printByAFM \n 0.exit" );
                    Scanner in = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Enter your choise");
                    int choise = in.nextInt();

                    if(choise==1){
                        System.out.println("Enter your AFM"); 
                        int AFM = in.nextInt(); 
                        System.out.println("Enter your Fisrtname"); 
                        String Firstname = in.next();
                        System.out.println("Enter your lastname"); 
                        String lastname = in.next();
                        System.out.println("Enter your savings"); 
                        double savings = in.nextDouble();
                        System.out.println("Enter your taxedIncome"); 
                        double  taxedIncome  = in.nextDouble();
                        LargeDepositor item= new LargeDepositor(AFM, Firstname, lastname, savings, taxedIncome);
                        bst.insert(item);
                    }

                    else if(choise==2){

                        System.out.println("give me a file name");
                        String File = in.next();
                        bst.load(File,bst);

                    }
                    else if(choise==3){
                        System.out.println("Enter your AFM"); 
                        int AFM = in.nextInt();
                        System.out.println("Enter your savings"); 
                        double  savings  = in.nextDouble();
                        bst.updateSavings(AFM,savings);

                    }
                    else if(choise==4){
                        System.out.println("Enter your AFM"); 
                        int AFM = in.nextInt();
                        LargeDepositor item = bst.searchByAFM(AFM);
                        System.out.println(item.toString());

                    }
                    else if(choise==5){
                        System.out.println("Enter your lastname"); 
                        String lastname = in.next();
                        StringDoubleEndedQueueLmpl<LargeDepositor> list = new StringDoubleEndedQueueLmpl<>();
                        list =bst.searchByLastName(lastname);
                        int k = list.size();
                        for(int i =0 ;i<k;i++){
                            LargeDepositor item = list.removeFirst();
                            System.out.println(item.toString());
                        }


                    }
                    else if(choise==6){
                        System.out.println("Enter your AFM"); 
                        int AFM = in.nextInt();
                        bst.remove(AFM);
                        

                    }
                    else if(choise==7){
                        System.out.println(bst.getMeanSavings());
                    }
                    else if(choise==8){
                        System.out.println("Enter your k elements you wat to print"); 
                        int k = in.nextInt();
                        bst.printTopLargeDepositors(k);

                    }
                    else if(choise==9){
                        bst.printByAFM();

                    }
                    else if(choise==0){
                        f=false;
                    }


            
                
                }





    



        
       
    }

    


    

    



}
    

