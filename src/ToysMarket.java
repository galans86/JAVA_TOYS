
import java.util.*;

public class ToysMarket {
    private PriorityQueue<Toy> toysPQ = new PriorityQueue<>(new WeightComporator());
    private ArrayList<Toy> toysList = new ArrayList<>();
    private int maxWeight = 10;
    private int sumWeight;

    public void put() {
        Scanner scan = new Scanner(System.in);
        int id;
        String name;
        int weight;

        for (int i = 0; i < 3; i++) {
            System.out.printf("Добавление игрушки %d\n", i + 1);
            System.out.println("Введите ID: ");
            id = scan.nextInt();
            System.out.println("Введите наименование");
            name = scan.next();
            System.out.println("Введите частоту выпадения(вес)");
            weight = scan.nextInt();
            if (weight <= 0) {
                System.out.printf("Введите значение > 0\n");
                i--;
            } else {
                if (weight != 0 && weight == getAllowWeight(i + 1, weight)) {
                    toysPQ.offer(new Toy(id, name, weight));
                } else {
                    System.out.printf("Суммарный вес длжен быть равен %d\n", this.maxWeight);
                    i--;
                }
            }
        }
//        toysPQ.offer(new Toy(1, "test1", 5)); //for test
//        toysPQ.offer(new Toy(2, "test2", 2));
//        toysPQ.offer(new Toy(3, "test3", 3));
    }

    public void get() {
        while (!toysPQ.isEmpty()) {
            Toy toy = toysPQ.poll();
            for (int i = 0; i < toy.getWeight(); i++) {
                toysList.add(toy);
            }
        }

        Random rand = new Random();

        for (int i = 0; i < this.maxWeight; i++) {
            Double randWeight = rand.nextDouble() * 10;
            Toy toy = findToy(toysList, randWeight);
            if (toy != null) {
                System.out.println(toy);
                toysList.remove(toy);
            }
        }
    }

    private Toy findToy(ArrayList<Toy> toysList, Double weight) {
        Toy toy = null;
        for (int i = 0; i < toysList.size(); i++) {
            toy = toysList.get(i);
            if (toy != null && toy.getWeight() <= weight) {
                return (Toy) toy;
            }
        }
        return (Toy) toy;
    }

    private int getAllowWeight(int i, int weight) {
        if ((i == 3 && weight == this.maxWeight - this.sumWeight)
                || (i < 3 && weight <= this.maxWeight - this.sumWeight)) {
            this.sumWeight  += weight;
            return weight;
        }
        return 0;
    }
}

