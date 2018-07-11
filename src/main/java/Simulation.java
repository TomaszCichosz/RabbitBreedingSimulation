import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private List<RabbitGeneration> femaleRabbitsGenerations;
    private long femaleRabbitsCount;
    private List<RabbitGeneration> maleRabbitsGenerations;
    private long maleRabbitsCount;
    private long deadRabbitsCount;

    public Simulation() {
        femaleRabbitsGenerations = new ArrayList<>();
        femaleRabbitsCount = 0;
        maleRabbitsGenerations = new ArrayList<>();
        maleRabbitsCount = 0;
        deadRabbitsCount = 0;
    }

    public int simulate(int maleCount, int femaleCount, long limit) {
        if (femaleCount <= 0) {
            return -1;
        }
        int months = 0;
        initializingPopulation(maleCount, femaleCount);
        int rabbitsGenerationSize;
        RabbitGeneration rabbitGeneration;
        while (femaleRabbitsCount + maleRabbitsCount < limit) {
            rabbitsGenerationSize = femaleRabbitsGenerations.size();
            for (int i = 0; i < rabbitsGenerationSize; i++) {
                rabbitGeneration = femaleRabbitsGenerations.get(i);
                if (rabbitGeneration.getAge() >= 4) {
                    breed(rabbitGeneration.getCount());
                }
                rabbitGeneration.age();
                if (rabbitGeneration.getAge() > 96) {
                    timeToDieFemales(rabbitGeneration.getCount(), i);
                    i--;
                }
            }
            rabbitsGenerationSize = maleRabbitsGenerations.size();
            for (int i = 0; i < rabbitsGenerationSize; i++) {
                rabbitGeneration = maleRabbitsGenerations.get(i);
                rabbitGeneration.age();
                if (rabbitGeneration.getAge() > 96) {
                    timeToDieMales(rabbitGeneration.getCount(), i);
                    i--;
                }
            }
            months++;
            System.out.println(femaleRabbitsCount + maleRabbitsCount);
        }
        return months;
    }

    private void initializingPopulation(int maleCount, int femaleCount) {
        femaleRabbitsGenerations.add(new RabbitGeneration(femaleCount));
        femaleRabbitsCount = femaleCount;
        maleRabbitsGenerations.add(new RabbitGeneration(maleCount));
        maleRabbitsCount = maleCount;
    }

    private void breed(long femaleRabbitsCountToBreed) {
        femaleRabbitsGenerations.add(new RabbitGeneration(14 * femaleRabbitsCountToBreed));
        femaleRabbitsCount += 14 * femaleRabbitsCountToBreed;
        maleRabbitsGenerations.add(new RabbitGeneration(5 * femaleRabbitsCountToBreed));
        maleRabbitsCount += 5 * femaleRabbitsCountToBreed;
    }

    private void timeToDieFemales(long rabbitGenerationCount, int i) {
        femaleRabbitsCount -= rabbitGenerationCount;
        deadRabbitsCount += rabbitGenerationCount;
        femaleRabbitsGenerations.remove(i);
    }

    private void timeToDieMales(long rabbitGenerationCount, int i) {
        maleRabbitsCount -= rabbitGenerationCount;
        deadRabbitsCount += rabbitGenerationCount;
        maleRabbitsGenerations.remove(i);
    }

    public long getDeadRabbitsCount() {
        return deadRabbitsCount;
    }
}
