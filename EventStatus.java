package p1;

/**
 * 
 * 
 * @param the enumerated literals of the enum class EventStatus.
 */
public enum EventStatus {

    Completed("Event has executed to completion"), Cancelled("Event was cancelled"),
    Initialised("Event is initialised"), Skipped("Event was skipped"), Started("Event has started execution");

    /**
     * 
     * @param the instance variable of the String description for EventStatus
     */
    private String description;

    /**
     * 
     * @param constructor for the EventStatus enum.
     */
    EventStatus(String description) {
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
