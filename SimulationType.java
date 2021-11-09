package p1;

/**
 * 
 * 
 * @param the enumerated literals of the enum class SimulationType.
 * 
 */
public enum SimulationType {
	Automatic("Simulation executes to completion without User input."),
	Manual("Each step in the simulation must be manually activated, actions are also manual "), SemiAutomatic(
			"The simulation will execute until predefined break points -- user must manually continue the simulation to the next breakpoint or continue to the end.");

	/**
	 * 
	 * @param the instance variable of the String description for SimulationType
	 */
	private String description;

	/**
	 * 
	 * @param constructor for the SimulationType enum.
	 */
	SimulationType(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return the enumeratered literals so they can be painted to the screen.
	 */
	public String getDescription() {
		return description;

	}

	public void setDescription(String description) {
		this.description = description;
	}
}
