package io.zhang.andy;

import java.util.ArrayList;
import java.util.List;

/**
 * @{link Elevator} represents a real elevator with several state
 */
public class Elevator {
    private ElevatorState state;
    private int floor;
    // When the flag is on the elevator is between two floors
    private boolean middle;
    // A list represents floors that the elevator will dock
    // TODO consider to use a different collection to serve an ordered set
    private List<DockTask> dockTasks;

    public static final int MAXFLOOR = 10;

    /**
     * @param state
     * @param floor
     * @param middle
     */
    public Elevator(ElevatorState state, int floor, boolean middle) {
        super();
        this.state = state;
        this.floor = floor;
        this.middle = middle;
        dockTasks = new ArrayList<DockTask>(MAXFLOOR);
    }

    /**
     * @return the state
     */
    public synchronized ElevatorState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public synchronized void setState(ElevatorState state) {
        this.state = state;
    }

    /**
     * @return the floor
     */
    public synchronized int getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public synchronized void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * @return the middle
     */
    public synchronized boolean isMiddle() {
        return middle;
    }

    /**
     * @param middle the middle to set
     */
    public synchronized void setMiddle(boolean middle) {
        this.middle = middle;
    }

    /**
     * @return the dockFloors
     */
    public List<DockTask> getDockTasks() {
        synchronized (this) {
            return dockTasks;
        }
    }

    /**
     * @param add a
     */
    public void addDockTask(DockTask task) {
        this.dockTasks.add(task);
    }

    public enum ElevatorState {
        /**
         * The Elevator is stopped and doesn't have any schedule
         */
        STOPPED,

        /**
         * The elevator is going up
         */
        UP,

        /**
         * The elevator is going down
         */
        DOWN,

        /**
         * The elevator is docking to a floor. When an elevator is docking its speed will slow down by 2 times. Also
         * it can't take another docking tasks within the floors between the docking floor and the elevator's current
         * position.
         */
    }
}
