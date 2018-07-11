public class SimulationSPOJStyle {

    public static int simulate(int maleCount, int femaleCount, long limit) {

        long[] femaleGenerations = new long[97];
        long[] maleGenerations = new long[97];
        int months = 4;

        //initial conditions
        femaleGenerations[4] = femaleCount;
        maleGenerations[4] = maleCount;
        long population = maleCount + femaleCount;

        //breeding loop
        long newFemaleGeneration;
        long newMaleGeneration;
        while (population < limit) {
            newFemaleGeneration = 0;
            newMaleGeneration = 0;

            //breeding of mature females
            for (int i = 4; i < 97; i++) {
                newFemaleGeneration += femaleGenerations[i] * 14;
                newMaleGeneration += femaleGenerations[i] * 5;
            }

            //aging process
            for (int i = 95; i >= 0; i--) {
                femaleGenerations[i + 1] = femaleGenerations[i];
                maleGenerations[i + 1] = maleGenerations[i];
            }
            //adding new generations to arrays
            femaleGenerations[0] = newFemaleGeneration;
            maleGenerations[0] = newMaleGeneration;

            population = 0;
            for (int i = 0; i < 97; i++) {
                population += femaleGenerations[i] + maleGenerations[i];
            }
            System.out.println(population);

            months++;
        }
        return months;
    }
}
