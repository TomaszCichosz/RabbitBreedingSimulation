import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private List<Rabbit> femaleRabbits;
    private List<Rabbit> maleRabbits;

    public Simulation() {
        this.femaleRabbits = new ArrayList<>();
        this.maleRabbits = new ArrayList<>();
    }

    public int simulate(int maleCount, int femaleCount, long limit) {
        int months = 0;
        initializingPopulation(maleCount, femaleCount);
        while (femaleRabbits.size() + maleRabbits.size() < limit) {
            for (int i = 0; i < femaleRabbits.size(); i++) {
                if (femaleRabbits.get(i).getAge() >= 4) {
                    breed();
                }
                femaleRabbits.get(i).aging();
                if (femaleRabbits.get(i).getAge() > 96) {
                    femaleRabbits.remove(i);
                }
            }
            for (int i = 0; i < maleRabbits.size(); i++) {
                maleRabbits.get(i).aging();
                if (maleRabbits.get(i).getAge() > 96) {
                    maleRabbits.remove(i);
                }
            }
            months++;
        }
        return months;
    }

    private void initializingPopulation(int maleCount, int femaleCount) {
        for (int i = 0; i < maleCount; i++) {
            maleRabbits.add(new Rabbit());
        }
        for (int i = 0; i < femaleCount; i++) {
            femaleRabbits.add(new Rabbit());
        }
    }

    private void breed() {
        for (int i = 0; i < 14; i++) {
            femaleRabbits.add(new Rabbit());
        }
        for (int i = 0; i < 5; i++) {
            maleRabbits.add(new Rabbit());
        }
    }

    public List<Rabbit> getFemaleRabbits() {
        return femaleRabbits;
    }

    public List<Rabbit> getMaleRabbits() {
        return maleRabbits;
    }
}
