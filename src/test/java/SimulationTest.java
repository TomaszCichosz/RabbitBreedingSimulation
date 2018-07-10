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

        int result = simulation.simulate(0, 0, 100);

        assertEquals(-1, result);
    }
}
