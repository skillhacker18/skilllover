package p1;

import java.util.ArrayList;

public final class Instant implements Comparable<Instant> {

    private int instant;
    private String name;
    private boolean isBlackout;
    private ArrayList<Event> eventsAtInstant;

    /**
     * <constructor>
     * @param day
     * @param dayString
     * @param instant
     */
    public Instant(int day, String dayString, int instant) {
        this.instant = instant;
        name = dayString;
        isBlackout = false;
        eventsAtInstant = new ArrayList<Event>();

    }

    /**
     * 
     * @return the name of the instant.
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return the value of the instant.
     * 
     */
    public int getInstant() {
        return instant;
    }

    /**
     * 
     * @return  true if the instant is a blackout instant, and false otherwise.
     */
    public boolean isBlackout() {
        return isBlackout;

    }

    public void switchBlackout() {
        isBlackout = !isBlackout;
    }


    public void addEvent(Event event) {
        eventsAtInstant.add(event);
    }

    
    @Override
    public int compareTo(final Instant other) {
        // TODO Auto-generated method stub
        if (this.instant < other.getInstant())
            return -1;
        if (this.instant > other.getInstant())
            return 1;
        return 0;
    }
}
