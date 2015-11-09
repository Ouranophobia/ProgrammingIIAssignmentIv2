
package programmingiiassignmenti;

public class Name {
    
    private final String first;
    private final String last;
    
    public Name(String first, String last){
        this.first = first;
        this.last = last;
    }
    
    public String getName(){
        return first + " " + last;
        
    }
}
