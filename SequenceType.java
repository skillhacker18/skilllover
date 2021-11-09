package p1;

/**
 * 
 * 
 * @param the enumerated literals of the enum class SequenceType.
 * 
 */
public enum SequenceType {
    American("Weeks start on a Sunday"), Bitish("Weeks start on a Monday");

    /**
     * 
     * @param the instance variable of the String description for SequenceType.
     * 
     */
    private String description;

    /**
     * 
     * @param constructor for the SequenceType enum.
     * 
     */
    SequenceType(String description) {
        this.description = description;

    }

    /**
     * 
     * @return  the enumeratered literals so they can be painted to the screen.
     * 
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
