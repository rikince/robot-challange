package api;

import java.util.HashMap;
import java.util.Map;
public enum RobotDirection {

    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private static Map<Integer, RobotDirection> map = new HashMap<>();

    static {
        for (RobotDirection robotDirectionEnum : RobotDirection.values()) {
            map.put(robotDirectionEnum.directionIndex, robotDirectionEnum);
        }
    }

    private final int directionIndex;

    private RobotDirection(int direction) {
        this.directionIndex = direction;
    }

    public static RobotDirection valueOf(int directionNum) {
        return map.get(directionNum);
    }

    /**
     * Returns the direction on the left of the current one
     */
    public RobotDirection leftDirection() {
        return rotate(-1);
    }

    /**
     * Returns the direction on the right of the current one
     */
    public RobotDirection rightDirection() {
        return rotate(1);
    }

    private RobotDirection rotate(int step) {

        int newIndex = (this.directionIndex + step) < 0 ?
                map.size() - 1 :
                (this.directionIndex + step) % map.size();

        return RobotDirection.valueOf(newIndex);
    }
}
