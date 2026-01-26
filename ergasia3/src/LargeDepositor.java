public class LargeDepositor{
    private int AFM;
    private String firstName;
    private String lastName;
    private double savings;
    private double taxedIncome;

    LargeDepositor(int AFM, String firstName,String lastName,double savings,double taxedIncome){
        this.AFM=AFM;
        this.firstName=firstName;
        this.lastName=lastName;
        this.savings=savings;
        this.taxedIncome=taxedIncome;
        
    }

    int key(){
        return AFM;
    }

    String getfirstName(){
        return firstName;
    }

    String getlastName(){
        return lastName;
    }

    double getsavings(){
        return savings;
    }

    double settaxedIncome(){
        return taxedIncome;
    }

    double gettaxedIncome(){
        return taxedIncome;
    }

    void setkey(int key){
        AFM=key;
    }

    void setfirstName(String fn){
        firstName=fn;
    }

    void setlastName(String ln){
        lastName=ln;
    }

    void setsavings(double save){
        savings=save;
    }

    

    void settaxedIncome(double tI){
        taxedIncome=tI;
    }


    public String toString(){
        return "The AFM of this person is: "+AFM + "\n" +"The Firstname of this person is: " + firstName + "\n"+"The Lastname of this person is: " + lastName + "\n"+"The Savings of this person is: " + savings + "\n"+"The TaxedIncome of this person is: " + taxedIncome+ "\n"+ "\n"+ "\n";
    }


    
    
}

