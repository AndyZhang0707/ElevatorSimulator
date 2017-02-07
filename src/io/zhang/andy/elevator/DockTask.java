package io.zhang.andy.elevator;

/**
 * @{link DockTask} represents tasks for elevators to dock.
 *        </p>
 *        It has the task floor and the direction where the elevator to go
 * 
 *        TODO the DockTask might need to be sortable
 */
public class DockTask {
    private int floor;
    private TaskDirectory direction;

    /**
     * @param floor
     * @param direction
     */
    public DockTask(int floor, TaskDirectory direction) {
        super();
        this.floor = floor;
        this.direction = direction;
    }

    /**
     * @return the floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * @return the direction
     */
    public TaskDirectory getDirection() {
        return direction;
    }

    public enum TaskDirectory {
        UP, DOWN,
    }
}
