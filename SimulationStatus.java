package p1;

/**
 * 
 * 
 * @param the enumerated literals of the enum class SimulationStatus.
 * 
 * 
 */
public enum SimulationStatus {
    Aborted("Simulation was aborted due to an error"), AtBreakPoint("Simulation is at a (predefined) breakpoint"),
    Completed("Simulation has executed to completion"), Cancelled("Simulation was cancelled"),
    Initialised(" Simulation is initialised, execution has not started"), Started("Simulation has started execution");

    /**
     * 
     * @param the instance variable of the String description for SimulationStatus.
     * 
     */
    private String description;

    /**
     * 
     * @param constructor for the SimulationStatus enumerated literals.
     * 
     */
    SimulationStatus(String description) {
        this.description = description;
    }

    /**
     * 
     * @return the enumeratered literals so they can be painted to the screen.
     * 
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
