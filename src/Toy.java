public class Toy {
    private int id;
    private String name;
    private int weight;

    public Toy( int id, String name, int weight){
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public double getWeight() {
        return (double) this.weight;
    }


     @Override
    public String toString(){
        return getId() + " " + getName() + " " + (int) getWeight();
     }
}
