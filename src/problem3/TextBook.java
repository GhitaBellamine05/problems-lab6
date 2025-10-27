package problem3;

public class TextBook extends Book{
    // attributes
    public String level;
    public TextBook(String name, String author, int nbPages, String level) {
        super(name, author, nbPages);
        this.level = level;
    }
    @Override
    public String toString() {
        return super.toString() + ", Level: " + level;
    }
}
