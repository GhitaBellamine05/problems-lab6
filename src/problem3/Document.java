package problem3;

public class Document {
    // attributes
    private static int counter = 1;
    protected int numEnrg;
    protected String name;
    // Custructor
    public Document(String name){
        this.name = name;
        this.numEnrg = counter++;
    }
    // getters
    public String getName(){
        return this.name;
    }
    public int getNumEnrg(){
        return this.numEnrg;
    }
    //setter
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Document #" + numEnrg + " - Title: " + name;
    }
}
