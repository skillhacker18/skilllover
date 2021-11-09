package p1;

import java.lang.Comparable;

public final class Interval implements Comparable<Interval> {
    private int starts;
    private int duration;

    /**
     * 
     * @param start
     * @param duration
     */
    public Interval(final int start, final int duration) {
        this.starts = start;
        this.duration = duration;

    }

    /**
     * 
     * @param start
     * @param duration
     */
    public boolean equals(final Interval other) {
        if (other.getStart() == this.starts && other.getDuration() == this.duration)
            return true;

        return false;
    }

    /**
     * 
     * @param other
     * @return
     */
    public boolean isAfter(final Interval other) {
        final int otherInterval = other.getStart() + other.getDuration();
        final int thisInterval = this.starts + this.duration;
        return thisInterval > otherInterval;
    }

    /**
     * 
     * @param other
     * @return
     */
    public boolean isBefore(final Interval other) {
        final int otherInterval = other.getStart() + other.getDuration();
        final int thisInterval = this.starts + this.duration;
        return thisInterval < otherInterval;

    }

    /**
     * 
     * @param other
     * @return
     */
    public boolean overlapsOnTheLeft(final Interval other) {
        final int thisInterval = this.starts + this.duration;
        if (other.getStart() < thisInterval && other.getStart() > this.starts)
            return true;
        return false;
    }

    /**
     * 
     * @param other
     * @return
     */
    public boolean overlapsOnTheRight(final Interval other) {
        final int otherInterval = other.getStart() + other.getDuration();
        if (this.starts < otherInterval && this.starts > other.getStart())
            return true;
        return false;
    }

    /**
     * 
     * @param other
     * @return
     */
    public boolean overlaps(final Interval other) {
        return overlapsOnTheRight(other) || overlapsOnTheLeft(other);
    }

    /**
     * 
     * @param other
     * @return
     */
    public boolean contains(final Interval other) {
        return !this.equals(other);
    }

    /**
     * 
     * @param other
     * @return
     */
    boolean isContiguousWith(final Interval other) {
        // english class 12pm 1hour
        final int otherInterval = other.getStart() + other.getDuration();
        // math class 1pm 2hour
        final int thisInterval = this.starts + this.duration;
        if (otherInterval == this.starts || thisInterval == other.getStart())
            return true;

        return false;
    }

    /**
     * 
     * @return
     */
    public int getStart() {
        return starts;
    }

    /**
     * 
     * @return
     */
    public int getDuration() {
        return duration;
    }

    /**
     * 
     * @return
     */
    public int getEnd() {
        return this.starts + this.duration - 1;
    }

    /**
     * 
     * @return 
     */
    public boolean validate(final int maxValue) {
        if (starts >= 1 && duration >= 1 && this.getEnd() <= maxValue)
            return true;

        return false;
    }

    @Override
    public int compareTo(final Interval other) {
        // TODO Auto-generated method stub
        if (this.starts < other.getStart())
            return -1;
        if (this.starts > other.getStart())
            return 1;
        return 0;
    }

}
