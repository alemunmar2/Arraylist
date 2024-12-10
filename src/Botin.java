import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
public class Botin {
    public static void main(String[] args) {

        ArrayList<Double> billetes = new ArrayList<Double>();
        billetes.add(10.0);
        billetes.add(20.0);
        billetes.add(50.0);
        billetes.add(100.0);
        billetes.add(200.0);

        int personas = 3;

        Map<Integer, ArrayList> billete = new HashMap<Integer, ArrayList>();

        for (int i = 0; i < personas; i++) {
            billete.put(i, new ArrayList<>());
        }

        Random random = new Random();

        while (!billetes.isEmpty()) {
            int index = random.nextInt(billetes.size());
            int persona = (billetes.size() - 1) % personas;
            billete.get(persona).add(billetes.get(index));
            billetes.remove(index);

        }
        System.out.println(billete);

    }
}
