package problem3;

public class Dictionary extends Document{
    // attributes
    private String language;
    // constructor
    public Dictionary(String name, String language) {
        super(name);
        this.language = language;
    }
    @Override
    public String toString() {
        return super.toString() + ", Language: " + language;
    }
}

