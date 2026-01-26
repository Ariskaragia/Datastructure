public class City {
    private int ID;
    private String name;
    private int population;
    private int InfluenzaCases;

    City(int ID,String name,int population,int InfluenzaCases){
        this.ID=ID;
        this.name=name;
        this.population=population;
        this.InfluenzaCases=InfluenzaCases;
    }

    int getID(){
        return ID;
    }

    String getName(){
        return name;
    }

    int getPopulation(){
        return population;
    }

    int getInfluenzaCases(){
        return InfluenzaCases;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setInfluenzaCases(int influenzaCases) {
        InfluenzaCases = influenzaCases;
    }

    public String toString(){

        return name;
    }
    
    double calculateDensity(){
        double calc=(double)InfluenzaCases/(double)population*50000;
        return (double) Math.round(calc * 100) / 100;
    }
    /*epistrofei true h false analogvs me thn taxinomhsh prvta me to calclation density meta me to onoma kai meta me to id  */
    public  boolean compareTo(City c){
        if (calculateDensity()<c.calculateDensity()){
            return true;
        }else if (calculateDensity()>c.calculateDensity()){
            return false;
        }else{
            if (name.compareTo(c.getName())<0){
                return true;
            }else if (name.compareTo(c.getName())>0){
                return false;
            }else{
                if (ID<c.getID()){
                    return true;
                }else{
                    return false;
                }
            }

       }
    }     
}
