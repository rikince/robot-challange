package application;


import api.*;
import exception.RobotGameException;
public class Simulator {

    GameBoard gameBoard;
    Robot robot;

    public Simulator(GameBoard gameBoard, Robot robot) {
        this.gameBoard = gameBoard;
        this.robot = robot;
    }

    public String placeRobot(Position position) throws RobotGameException {

        if (gameBoard == null)
            throw new RobotGameException("Invalid gameBoard object");

        if (position == null)
            throw new RobotGameException("Invalid position object");

        if (position.getDirection() == null)
            throw new RobotGameException("Invalid direction value");

        if (!gameBoard.isValidPosition(position))
            return "Operation failed";

        robot.setPosition(position);
        return "Operation success";
    }

    public String parseOperation(String userInput) throws RobotGameException {

        String[] arrUserInput = userInput.split(" ");

        Operation command;
        try {
            command = Operation.valueOf(arrUserInput[0]);
        } catch (IllegalArgumentException e) {
            throw new RobotGameException("Please enter correct operation value");
        }

        if (command == Operation.PLACE && arrUserInput.length < 2) {
            throw new RobotGameException("Please enter correct PLACE operation parameter");
        }

        String[] params;
        int x = 0;
        int y = 0;
        RobotDirection userInputRobotDirection = null;
        if (command == Operation.PLACE) {
            params = arrUserInput[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                userInputRobotDirection = RobotDirection.valueOf(params[2]);
            } catch (Exception e) {
                throw new RobotGameException("Invalid command");
            }
        }

        String output;

        switch (command) {
            case PLACE:
                output = String.valueOf(placeRobot(new Position(x, y, userInputRobotDirection)));
                break;
            case MOVE:
                Position newPosition = robot.getPosition().getNextPosition();
                if (!gameBoard.isValidPosition(newPosition))
                    output = String.valueOf("Operation failed");
                else
                    output = String.valueOf(robot.move(newPosition));
                break;
            case LEFT:
                output = String.valueOf(robot.turnLeft());
                break;
            case RIGHT:
                output = String.valueOf(robot.turnRight());
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new RobotGameException("Invalid operation");
        }

        return output;
    }

    public String report() {
        if (robot.getPosition() == null)
            return null;

        return robot.getPosition().getX() + "," + robot.getPosition().getY() + "," + robot.getPosition().getDirection().toString();
    }
}
