import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private List<Rabbit> femaleRabbits = new ArrayList<>();
    private List<Rabbit> maleRabbits = new ArrayList<>();

    private int simulate(int maleCount, int femaleCount, long limit) {

        return 0;
    }

    private void breed() {
        for (int i = 0; i < 14; i++) {
            femaleRabbits.add(new Rabbit(true));
        }
        for (int i = 0; i < 14; i++) {
            maleRabbits.add(new Rabbit(false));
        }
    }
}
