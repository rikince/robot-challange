package api;

import exception.RobotGameException;

public class Robot {

    private Position position;

    public Robot() {
    }

    public Robot(Position position) {
        this.position = position;
    }

    public boolean setPosition(Position position) {
        if (position == null)
            return false;

        this.position = position;
        return true;
    }

    public String move() throws RobotGameException {
        return move(position.getNextPosition());
    }

    public String move(Position newPosition) {
        if (newPosition == null)
            return "Operation failed";

        // change position
        this.position = newPosition;
        return "Operation success";
    }

    public Position getPosition() {
        return this.position;
    }

    public String turnLeft() {
        if (this.position.robotDirection == null)
            return "Operation failed";

        this.position.robotDirection = this.position.robotDirection.leftDirection();
        return "Operation success";
    }

    public String turnRight() {
        if (this.position.robotDirection == null)
            return "Operation failed";

        this.position.robotDirection = this.position.robotDirection.rightDirection();
        return "Operation success";
    }
}
