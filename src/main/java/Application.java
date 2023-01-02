import api.Robot;
import api.PlayBoard;
import application.Simulator;
import exception.RobotGameException;

import java.util.Scanner;
public class Application {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        PlayBoard playBoard = new PlayBoard(4, 4);
        Robot robot = new Robot();

        Simulator simulator = new Simulator(playBoard, robot);

        System.out.println("Welcome to Robot simulator");
        System.out.println("Please enter operation, Valid operations are:");
        System.out.println("1.'PLACE X,Y,NORTH|SOUTH|EAST|WEST'");
        System.out.println("2.MOVE \n3.LEFT \n4.RIGHT \n5.REPORT \n6.EXIT");

        boolean isGameExit = false;
        while (!isGameExit) {
            String userInput = sc.nextLine();
            if ("EXIT".equals(userInput)) {
                isGameExit = true;
            } else {
                try {
                    String gameOutput = simulator.parseOperation(userInput);
                    System.out.println(gameOutput);
                } catch (RobotGameException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
