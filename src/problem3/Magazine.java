package problem3;

public class Magazine extends Document{
    //attributes
    private String month;
    private int year;
    // constructor
    public Magazine(String name, String month, int year) {
        super(name);
        this.month =month;
        this.year =year;
    }
    @Override
    public String toString() {
        return super.toString() + ", Month: " + month + ", Year: " + year;
    }

}
