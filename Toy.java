package Raffle6;

//public class Toy
public class Toy implements Comparable<Toy>{

    private int id;
    private String name;
    private int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getWeidht() {
        return weight;
    }

    @Override
    public String toString() {
        return "id=" + id + "{name=" + name + ", weight=" + weight + "}";
    }

    // @Override
    // public int compareTo(Toy o) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    // }
    @Override
    public int compareTo(Toy other) {
        if (other == null) {
            return -1; // this < other
        }
        int delta = this.weight - other.weight;
        if (delta != 0) {
            return - delta;
        }  
        return this.name.compareTo(other.name);
    }
}
