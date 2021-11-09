package p1;

/**
 * 
 * 
 * @param the enumerated literals of the enum class BreakPointType.
 */

public enum BreakPointType {
    Day("Simulation will have a breakpoints after each day"),
    EndOfWeek("Simulation will have a breakpoints after the end of the week"),
    SevenDays("Simulation will have a breakpoints after each seven (7) days"),
    FourteenDays("Simulation will have a breakpoints after each fourteen (14) days"),
    TwentyEightDays("Simulation will have a breakpoints after each twenty-eight (28) days"),
    ExecuteToCompletion("Simulation will have no breakpoints");

    /**
     * 
     * @param the instance variable of the String description for BreakPointType.
     */
    private String description;

    /**
     * 
     * @param constructor for the breakPoint enum.
     */
    BreakPointType(String description) {
        this.description = description;
    }

    /**
     * 
     * @return an Instance Method that can be painted on the screen
     */
    public String getDescription() {
        return description;
    }

}
