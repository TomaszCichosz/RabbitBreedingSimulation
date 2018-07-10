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
        for (int i = 0; i < maleCount; i++) {
            maleRabbits.add(new Rabbit(false));
        }
        for (int i = 0; i < femaleCount; i++) {
            femaleRabbits.add(new Rabbit(true));
        }
        while (femaleRabbits.size() + maleRabbits.size() < limit) {
            for (int i = 0; i < femaleRabbits.size(); i++) {
                if (femaleRabbits.get(i).getAge() >= 4) {
                    breed(limit);
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

    private void breed(long limit) {
        for (int i = 0; i < 14; i++) {
            if (femaleRabbits.size() + maleRabbits.size() < limit) {
                femaleRabbits.add(new Rabbit(true));
            }
        }
        for (int i = 0; i < 5; i++) {
            if (femaleRabbits.size() + maleRabbits.size() < limit) {
                maleRabbits.add(new Rabbit(false));
            }
        }
    }

    public List<Rabbit> getFemaleRabbits() {
        return femaleRabbits;
    }

    public List<Rabbit> getMaleRabbits() {
        return maleRabbits;
    }
}
