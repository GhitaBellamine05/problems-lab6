package challenge;

public class Place {
    // attributes
    private String town;
    private int distance;
    // constructor
    public Place(String name,int distance){
        this.town = name;
        this.distance = distance;
    }
    // getters
    public String getName(){return this.town;}
    public int getDistance(){return this.distance;}
    // setters
    public void setTown(String name){this.town = name;}
    public void setDistance(int distance){this.distance = distance;}
    @Override
    public String toString(){
        return town +", " + distance;
    }


}
