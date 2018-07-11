public class SimulationSPOJStyle {

    public static int simulate(int maleCount, int femaleCount, long limit) {

        long[] femaleGenerations = new long[97];
        long[] maleGenerations = new long[97];
        int months = 4;

        femaleGenerations[4] = femaleCount;
        maleGenerations[4] = maleCount;
        long population = maleCount + femaleCount;

        long newFemaleGeneration = 0;
        long newMaleGeneration = 0;
        while (population < limit) {
            for (int i = 4; i < 97; i++) {
                newFemaleGeneration += femaleGenerations[i] * 14;
                newMaleGeneration += femaleGenerations[i] * 5;
            }

            for (int i = 95; i >= 0; i--) {
                femaleGenerations[i + 1] = femaleGenerations[i];
                maleGenerations[i + 1] = maleGenerations[i];
            }

            femaleGenerations[0] = newFemaleGeneration;
            maleGenerations[0] = newMaleGeneration;
            newFemaleGeneration = 0;
            newMaleGeneration = 0;

            population = 0;
            for (int i = 0; i < 97; i++) {
                population += femaleGenerations[i] + maleGenerations[i];
            }
            months++;
            System.out.println(population);
        }
        return months;
    }
}
