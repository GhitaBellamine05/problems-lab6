package problem3;

public class Novel extends Book{
    //attributes
    public double price;
    // constructor
    public Novel(String name, String author, int nbPages,double price) {
        super(name, author, nbPages);
        this.price = price;
    }
    @Override
    public String toString() {
        return super.toString() + ", Price: " + price;
    }

}
