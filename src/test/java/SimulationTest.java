import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimulationTest {

    private Simulation simulation;

    @Before
    public void initializeSimulation() {
        simulation = new Simulation();
    }

    @Test
    public void givenNoRabbits_whenSimulate_thenReturnNegativeOne() {
        int maleCount = 0;
        int femaleCount = 0;

        int result = simulation.simulate(maleCount, femaleCount, 100);

        assertEquals(-1, result);
    }

    @Test
    public void givenNoFemaleRabbits_whenSimulate_thenReturnNegativeOne() {
        int maleCount = 100;
        int femaleCount = 0;

        int result = simulation.simulate(maleCount, femaleCount, 100);

        assertEquals(-1, result);
    }

    @Test
    public void givenOneFemaleRabbitWithLimit100_whenSimulate_thenReturnCorrectly() {
        int maleCount = 0;
        int femaleCount = 1;

        int result = simulation.simulate(maleCount, femaleCount, 100);

        assertEquals(10, result);
    }

    @Test
    public void givenOneFemaleRabbitWithLimit1000_whenSimulate_thenReturnCorrectly() {
        int maleCount = 0;
        int femaleCount = 1;

        int result = simulation.simulate(maleCount, femaleCount, 1000);

        assertEquals(12, result);
    }
}
