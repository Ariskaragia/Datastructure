/*p3220066 ARISTEIDHS KARAGIANNAKOS
 * p3220037 ELLY DANAZI
 */
public class NodeList<T> {

    protected T data;
    protected NodeList<T> next;
    protected NodeList<T> previous;

    

    NodeList(T data){
        this.data=data;
        this.next = null;
        this.previous=null;

    }


    public T getData(){
        return data;
    }


    public NodeList<T> getNext(){
        return next;

    }


    public void setNext(NodeList<T> next){
        this.next=next;
    }

    public NodeList<T> getPrevious(){
        return previous;

    }

    public void setprevious(NodeList<T> previous){
        this.previous=previous;
    }
    
}
