import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private List<Rabbit> femaleRabbits;
    private List<Rabbit> maleRabbits;
    private long deadRabbitsCount;

    public Simulation() {
        femaleRabbits = new ArrayList<>();
        maleRabbits = new ArrayList<>();
        deadRabbitsCount = 0;
    }

    public int simulate(int maleCount, int femaleCount, long limit) {
        int months = 0;
        initializingPopulation(maleCount, femaleCount);
        int femaleRabbitsPopulation;
        int maleRabbitsPopulation;
        while (femaleRabbits.size() + maleRabbits.size() < limit && !femaleRabbits.isEmpty()) {
            femaleRabbitsPopulation = femaleRabbits.size();
            for (int i = 0; i < femaleRabbitsPopulation; i++) {
                if (getRabbitAge(femaleRabbits, i) >= 4) {
                    breed();
                }
                femaleRabbits.get(i).age();
                if (getRabbitAge(femaleRabbits, i) > 96) {
                    femaleRabbits.remove(i);
                    i--;
                    deadRabbitsCount++;
                }
            }
            maleRabbitsPopulation = maleRabbits.size();
            for (int i = 0; i < maleRabbitsPopulation; i++) {
                maleRabbits.get(i).age();
                if (getRabbitAge(maleRabbits, i) > 96) {
                    maleRabbits.remove(i);
                    i--;
                    deadRabbitsCount++;
                }
            }
            months++;
            System.out.println(femaleRabbits.size() + maleRabbits.size());
        }
        if (femaleRabbits.isEmpty()) {
            return -1;
        } else return months;
    }

    private int getRabbitAge(List<Rabbit> rabbits, int i) {
        return rabbits.get(i).getAge();
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

    public long getDeadRabbitsCount() {
        return deadRabbitsCount;
    }

    public List<Rabbit> getFemaleRabbits() {
        return femaleRabbits;
    }

    public List<Rabbit> getMaleRabbits() {
        return maleRabbits;
    }
}
