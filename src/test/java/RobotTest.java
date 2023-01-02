import api.Position;
import api.Robot;
import api.RobotDirection;
import exception.RobotGameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    @Test
    public void testMovement() throws RobotGameException {

        Robot robot = new Robot(new Position(0, 0, RobotDirection.SOUTH));

        assertEquals("Operation success", robot.move());
        assertEquals(0, robot.getPosition().getX());
        assertEquals(-1, robot.getPosition().getY());
        assertEquals(RobotDirection.SOUTH, robot.getPosition().getDirection());


        robot.setPosition(new Position(1, 2, RobotDirection.EAST));
        robot.move();
        robot.move();
        robot.turnLeft();
        robot.move();

        assertEquals(3, robot.getPosition().getX());
        assertEquals(3, robot.getPosition().getY());
        assertEquals(RobotDirection.NORTH, robot.getPosition().getDirection());

        robot.setPosition(new Position(0, 0, RobotDirection.NORTH));
        robot.turnRight();
        assertEquals(RobotDirection.EAST, robot.getPosition().getDirection());
        robot.turnRight();
        assertEquals(RobotDirection.SOUTH, robot.getPosition().getDirection());
        robot.turnRight();
        assertEquals(RobotDirection.WEST, robot.getPosition().getDirection());
        robot.turnRight();
        assertEquals(RobotDirection.NORTH, robot.getPosition().getDirection());
        robot.turnRight();
        assertEquals(RobotDirection.EAST, robot.getPosition().getDirection());
    }

}