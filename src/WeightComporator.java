import java.util.Comparator;

public class WeightComporator implements Comparator<Toy> {

    @Override
    public int compare(Toy toy1, Toy toy2) {
        return Double.compare(toy1.getWeight(),toy2.getWeight()) * -1;
    }
}