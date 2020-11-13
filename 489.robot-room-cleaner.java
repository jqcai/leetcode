import java.util.*;

/*
 * @lc app=leetcode id=489 lang=java
 *
 * [489] Robot Room Cleaner
 */
/**
 * // This is the robot's control interface. // You should not implement it, or
 * speculate about its implementation interface Robot { // Returns true if the
 * cell in front is open and robot moves into the cell. // Returns false if the
 * cell in front is blocked and robot stays in the current cell. public boolean
 * move();
 *
 * // Robot will stay in the same cell after calling turnLeft/turnRight. // Each
 * turn will be 90 degrees. public void turnLeft(); public void turnRight();
 *
 * // Clean the current cell. public void clean(); }
 */

class Solution {
    public void cleanRoom(Robot robot) {
        dfs(robot, new HashSet<>(), 0, 0);
    }

    public void dfs(Robot robot, Set<Long> hs, int i, int j) {
        long pos = calculatePos(i, j);
        if (hs.contains(pos)) {
            return;
        }
        robot.clean();
        hs.add(pos);

        if (!hs.contains(calculatePos(i + 1, j)) && robot.move()) {
            dfs(robot, hs, i + 1, j);
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }
        robot.turnRight();
        if (!hs.contains(calculatePos(i, j + 1)) && robot.move()) {
            robot.turnLeft();
            dfs(robot, hs, i, j + 1);
            robot.turnLeft();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }
        robot.turnRight();
        if (!hs.contains(calculatePos(i - 1, j)) && robot.move()) {
            robot.turnRight();
            robot.turnRight();
            dfs(robot, hs, i - 1, j);
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }
        robot.turnRight();
        if (!hs.contains(calculatePos(i, j - 1)) && robot.move()) {
            robot.turnRight();
            dfs(robot, hs, i, j - 1);
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }
        robot.turnRight();
        return;
    }

    public long calculatePos(int i, int j) {
        return (((long)i) << 32) | (j & 0xffffffffL);
    }
}
