package p1;

/**
 * 
 * 
 * @param the enumerated literals of the enum class DaysOfTheWeek.
 */
public enum DaysOfTheWeek {
    Monday("Monday"), Tuesday("Tuesday"), Wednesday("Wednesday"), Thursday("Thursday"), Friday("Friday"),
    Saturday("Saturday"), Sunday("Sunday");

    /**
     * 
     * @param the instance variable of the String description for DaysOfTheWeek.
     */
    private String description;

    /**
     * 
     * @param constructor for the daysOfTheweek enum.
     */
    DaysofTheWeek(String description) {
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

    // Weeks start on a Sunday;
    public static DaysofTheWeek firstDayAmerican() {
        return Sunday;
    }

    // Weeks start on a Monday.
    public static DaysofTheWeek firstDayBritish() {
        return Monday;
    }

    public static DaysofTheWeek next(DaysofTheWeek day) {
        return DaysofTheWeek.values()[(day.ordinal() == 6 ? 0 : day.ordinal() + 1)];
    }
}
