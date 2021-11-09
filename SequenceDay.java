package p1;

import java.util.ArrayList;

public class SequenceDay {
    private int Day;
    private DaysofTheWeek name;
    private ArrayList<Instant> instants;
    private ArrayList<Interval> blackoutIntervals;

    /**
     * @param Constructors:
     * @param dayValue
     * @param name
     * @param instantsPerDay
     */
    public SequenceDay1(final int dayValue, final DaysofTheWeek name,final int instantsPerDay) {

        Day = dayValue;
        this.name = name;
        instants = new ArrayList<Instant>(instantsPerDay);
        blackoutIntervals = new ArrayList<Interval>(instantsPerDay);

    }

    /**
     * 
     * @param i_starts
     * @param i_duration
     */
    public void addBlackoutInterval(final int i_starts, final int i_duration) {
        var interout = new Interval(i_starts, i_duration);
        var instant = new Instant(i_duration, null, i_duration);
        instant.switchBlackout();
        blackoutIntervals.add(interout);
        instants.add(instant);

    }
    
    /**
     * 
     * @param i_starts
     * @param i_duration
     */
    public void removeBlackoutInterval(final int i_starts, final int i_duration) {
        // void removeBlackoutInterval(...)
        int index = -1;
        for (int i = 0; i < blackoutIntervals.size(); i++) {
            if (blackoutIntervals.get(i).getStart() == i_starts
                    && blackoutIntervals.get(i).getDuration() == i_duration) {
                index = i;
                break;
            }
        }

        if (index >= 0)
            instants.get(index).switchBlackout();
    }

    /**
     * 
     * @param instantsPerDay
     * @return a boolean
     */
    public boolean validate(final int instantsPerDay) {
        // validate(...)
        if (instants.size() < instantsPerDay)
            return false;
        for (int i = 0; i < blackoutIntervals.size() - 1; i++) {
            final var current = blackoutIntervals.get(i);
            final var next = blackoutIntervals.get(i + 1);
            if (current.overlaps(next) || !current.validate(/* max value */ 3) || !next.validate(/* max value */3))
                return false;
        }

        return true;

    }

    /**
     * 
     * @param event
     * @param atInstant
     */
    public void addEvent(final Event event, final int atInstant) {
        instants.get(atInstant).addEvent(event);
    }

    /**
     * 
     * @return the number of blackout instants.
     */
    public int getNbrOfBlackoutInstants() {
        return blackoutIntervals.size();
    }

    /**
     * 
     * @return the amounts of instants for the operation
     */
    public int getNbrOfOperationInstants() {
        return instants.size();

    }

    /**
     * 
     * @return the day.
     */
    public int getDay() {
        return Day;
    }

    /**
     * 
     * @return Name.
     */
    public DaysofTheWeek getName() {
        return name;
    }

    /**
     * 
     * @param instant
     * @return the instants
     */
    public Instant getInstant(final int instant) {
        return instants.get(instant);
    }

}
