package api;

import exception.RobotGameException;
public class Position {

    int x;
    int y;

    RobotDirection robotDirection;

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.robotDirection = position.getDirection();
    }

    public Position(int x, int y, RobotDirection robotDirection) {
        this.x = x;
        this.y = y;
        this.robotDirection = robotDirection;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public RobotDirection getDirection() {
        return this.robotDirection;
    }

    public void setDirection(RobotDirection robotDirection) {
        this.robotDirection = robotDirection;
    }

    public void change(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public Position getNextPosition() throws RobotGameException {
        if (this.robotDirection == null)
            throw new RobotGameException("Invalid robot direction");

        Position newPosition = new Position(this);
        switch (this.robotDirection) {
            case NORTH:
                newPosition.change(0, 1);
                break;
            case EAST:
                newPosition.change(1, 0);
                break;
            case SOUTH:
                newPosition.change(0, -1);
                break;
            case WEST:
                newPosition.change(-1, 0);
                break;
        }
        return newPosition;
    }

}
