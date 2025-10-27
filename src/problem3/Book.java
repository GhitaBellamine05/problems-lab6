package problem3;

public class Book extends Document{
    // attributes
    protected String author;
    protected int nbPages;
    // constructor
    public Book(String name, String author, int nbPages) {
        super(name);
        this.author = author;
        this.nbPages = nbPages;
    }
    // getters
     public String getAuthor(){
        return this.author;
     }
     public int getNbPages(){
        return this.nbPages;
     }
    @Override
    public String toString() {
        return super.toString() + ", Author: " + author + ", Pages: " + nbPages;
    }


}
