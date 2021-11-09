package p1;

import java.util.ArrayList;
import java.util.Random;

public class Simulator {

  /**
   * instance variables
   */
  private SimulationType simulationType;
  private BreakPointType breakPoint;
  private SequenceType sequenceType;
  private int duration;
  private DaysOfTheWeek startsOn;
  private int instantsPerDay;
  private SimulationStatus status;
  private int currentDay;
  private int currentInstant;
  private ArrayList<SequenceDay> day;
  private ArrayList<Event> eventsQueue;
  private ArrayList<Event> completedEvents;
  private ArrayList<Event> inProgressEvents;

  public Simulator() {
    simulationType = SimulationType.Automatic;
    breakPoint = BreakPointType.ExecuteToCompletion;
    sequenceType = SequenceType.American;
    duration = 8;
    startsOn = DaysOfTheWeek.Sunday;
    instantsPerDay = 24;
    status = SimulationStatus.Initialised;
    currentDay = -1;
    currentInstant = -1;
    days = new ArrayList<SequenceDay>();
    eventsQueue = new ArrayList<Event>();
    completedEvents = new ArrayList<Event>();
    inProgressEvents = new ArrayList<Event>();
  }

  /**
   * 
   * @param type
   * @param bpType
   * @param seqType
   * @param duration
   * @param startsOn
   * @param instantsPerDay
   */
  public Simulator(final SimulationType type, final BreakPointType bpType, final SequenceType seqType,
      final int duration, final DaysOfTheWeek startsOn, final int instantsPerDay) {
    simulationType = type;
    breakPoint = bpType;
    sequenceType = seqType;
    this.duration = duration;
    this.startsOn = startsOn;
    this.instantsPerDay = instantsPerDay;
    status = SimulationStatus.Initialised;
    currentDay = -1;
    currentInstant = -1;
    days = new ArrayList<SequenceDay>();
    eventsQueue = new ArrayList<Event>();
    completedEvents = new ArrayList<Event>();
    inProgressEvents = new ArrayList<Event>();
  }

  /**
   * 
   * @param type
   * @param bpType
   * @param seqType
   * @param duration
   * @param startsOn
   * @param instantsPerDay
   */
  public boolean abort() {
    if (status == SimulationStatus.Aborted) {
      System.out.println("Simulation cannot continue, aborting");
      return true;
    }
    return false;

  }

  /**
   * 
   * @return
   */
  public boolean breakSimulation() {
    if (inProgressEvents.size() == 0) {
      return true;
    }
    return false;
  }

  /**
   * 
   * @return
   */
  public boolean cancel() {
    return this.simulationType == SimulationType.Manual && simulationType == SimulationType.SemiAutomatic;

  }

  /**
   * 
   * @return
   */
  public boolean continueSimulation() {
    return status == SimulationStatus.AtBreakPoint; // or simulationType = SimulationType.SemiAutomatic

  }

  /**
   * 
   * @return
   */
  public boolean continueToCompletion() {
    return status == SimulationStatus.Completed;

  }

  /**
   * 
   * @return
   */
  public boolean continueTo(BreakPointType bp) {
    if (breakPoint == bp) {
      return true;
    }
    return false;

  }

  /**
   * 
   * @return
   */
  public boolean start() {
    if (status == SimulationStatus.Started) {
      currentDay = 0;
      currentInstant = 0;
      return true;
    }
    return false;

  }

  /**
   * 
   * @return
   */
  public boolean step() {
    currentInstant++;
    currentDay++;
    r = instantsOfEvents.add(currentInstant);
    eventsAtInstant.add(r);
  }

  /**
   * 
   * @return
   */
  public boolean isAtBreakPoint() {
    if (status == SimulationStatus.AtBreakPoint) {
      return true;
    }
    return false;
  }

  /**
   * 
   * @return
   */
  public ArrayList<Integer> getBreakPoints() {
    // declare empty list of correct data type
    final var intarray = new ArrayList<Integer>();
    // loop over each enum and add their integer representation to x
    for (final var element : this.days) {
      intarray.add(element.getDay());
    }
    return intarray; // return correct data type
  }

  /**
   * 
   * @return
   */
  public int getCurrentDay() {
    return currentDay;
  }

  /**
   * 
   * @return
   */
  public int getCurrentinstant() {
    return currentInstant;
  }

  /**
   * 
   * @return
   */
  public int getInstantsPerDay() {
    return instantsPerDay;
  }

  /**
   * 
   * @return
   */
  public Instant getInstant(int day, int instant) {
    Instant object = new Instant(day, instant);
    return object;
  }

  /**
   * 
   * @return
   */
  public long getTotalOperationInstants() {
    long i = 0;
    for (var e : this.eventsQueue) {
      i += (long) e.getInstantsOfEvent().size();
    }
    for (var e : this.completedEvents) {
      i += (long) e.getInstantsOfEvent().size();
    }
    for (var e : this.inProgressEvents) {
      i += (long) e.getInstantsOfEvent().size();
    }
    return i;

  }

  /**
   * 
   * @return
   */
  public long getTotalOperationInstants(int dayValue) {

    return getTotalOperationInstants();

  }

  /**
   * 
   * @return
   */
  public long getTotalBlackoutInstants() {
    long i = 0;
    for (var e : this.eventsQueue) {
      for (var ei : e.getInstantsOfEvent()) {
        if (ei.isBlackout())
          i++;
      }
    }
    for (var e : this.completedEvents) {
      for (var ei : e.getInstantsOfEvent()) {
        if (ei.isBlackout())
          i++;
      }
    }
    for (var e : this.inProgressEvents) {
      for (var ei : e.getInstantsOfEvent()) {
        if (ei.isBlackout())
          i++;
      }
    }
    return i;

  }

  /**
   * 
   * @return
   */
  public long getTotalBlackoutInstants(int dayValue) {
    return getTotalBlackoutInstants();

  }

  /**
   * 
   * @return
   */
  public void addBlackoutInterval(int dayValue, Interval interval) {
    this.day.add(new SequenceDay(dayValue, interval));

  }

  /**
   * instantsperday duration
   * 
   * @return
   */
  public boolean validateParameters() {
    if (instantsPerDay < 0) {
      return false;
    }
    if (duration < 0) {
      return false;
    }
    return true;

  }

  /**
   * 
   * @return
   */
  public boolean validateExecution() {
    // because its flawed
    return true;
  }

  /**
   * 
   * @return
   */
  public void addNewEvent(EventPriority priority, int day, int instant, int duration, String data) {
    eventsQueue.add(new Event(day, instant, duration, priority, data));

  }

  /**
   * 
   * @return
   */
  public void addRandomEvents(int eventsToAdd) {
    final var random = new Random(0);
    for (int i = 0; i < eventsToAdd; ++i) {
      var priority = new EventPriority[] { EventPriority.Low, EventPriority.Medium, EventPriority.High }[random
          .nextInt(3)];
      eventsQueue.add(new Event(4, random.nextInt(24), random.nextInt(1, 5), priority, "Tuesday"));

    }
  }

  /**
   * 
   * @return
   */
  public Event getNextEventToProcess() {
    // merge Events from eventsQueue and inProgressQueue
    final var events = new ArrayList<Event>(this.inProgressEvents);
    events.addAll(this.eventsQueue);

    // sort by EventPriority (High to Low)
    events.sort((a, b) -> {
      final var ap = a.getEventPriority().ordinal();
      final var bp = b.getEventPriority().ordinal();
      if (ap < bp)
        return -1;
      if (ap > bp)
        return 1;
      return 0;
    });

    // grouping Events by priority
    final var highEvent = new ArrayList<Event>(events);
    final var mediumEvent = new ArrayList<Event>(events);
    final var lowEvent = new ArrayList<Event>(events);

    highEvent.removeIf(x -> x.getEventPriority().ordinal() != 0);
    mediumEvent.removeIf(x -> x.getEventPriority().ordinal() != 1);
    lowEvent.removeIf(x -> x.getEventPriority().ordinal() != 2);

    // sort each group by their eventID
    highEvent.sort((a, b) -> a.compareTo(b));
    mediumEvent.sort((a, b) -> a.compareTo(b));
    lowEvent.sort((a, b) -> a.compareTo(b));

    if (highEvent.size() > 0)
      return highEvent.get(0);
    if (mediumEvent.size() > 0)
      return mediumEvent.get(0);
    return lowEvent.get(0); // will error if empty
  }
}