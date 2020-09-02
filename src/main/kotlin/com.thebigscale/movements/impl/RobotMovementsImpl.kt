package movements.impl


/**
 * Strategies for different types of Robotic movements. Each class is responsible for only one type of movement.
 */

import Robot
import movements.*

class ForwardRobotMovementImpl: ForwardRobotMovement {
    override fun makeMovement(robot: Robot): Position {
        var x: Int = robot.position().gridCoordinates.x
        var y: Int = robot.position().gridCoordinates.y
        when (robot.position().orientation) {
            Orientation.EAST -> x +=1
            Orientation.WEST -> x -=1
            Orientation.NORTH -> y +=1
            Orientation.SOUTH -> y -=1
        }
        if (robot.hasScent(robot.position().gridCoordinates)) return Position(GridCoordinates(x, y), robot.position().orientation, false)
        return Position(GridCoordinates(x, y), robot.position().orientation, true)
    }
}


class BackwardRobotMovementImpl: BackwardRobotMovement {
    override fun makeMovement(robot: Robot): Position {
        var x: Int = robot.position().gridCoordinates.x
        var y: Int = robot.position().gridCoordinates.y
        when (robot.position().orientation) {
            Orientation.EAST -> x -=1
            Orientation.WEST -> x +=1
            Orientation.NORTH -> y -=1
            Orientation.SOUTH -> y +=1
        }
        if (robot.hasScent(robot.position().gridCoordinates)) return Position(GridCoordinates(x, y), robot.position().orientation, false)
        return return Position(GridCoordinates(x, y), robot.position().orientation, true)
    }
}


class LeftRobotMovementImpl: LeftRobotMovement{
    override fun makeMovement(robot: Robot): Position {
        val orientation: Orientation = when (robot.position().orientation) {
            Orientation.EAST -> Orientation.NORTH
            Orientation.WEST -> Orientation.SOUTH
            Orientation.NORTH -> Orientation.WEST
            Orientation.SOUTH -> Orientation.EAST
        }
        return Position(robot.position().gridCoordinates, orientation, true)
    }
}


class RightRobotMovementImpl: RightRobotMovement{
    override fun makeMovement(robot: Robot): Position {
        val orientation: Orientation = when (robot.position().orientation) {
            Orientation.NORTH -> Orientation.EAST
            Orientation.SOUTH -> Orientation.WEST
            Orientation.EAST -> Orientation.SOUTH
            Orientation.WEST -> Orientation.NORTH
        }
        return Position(robot.position().gridCoordinates, orientation, true)
    }

}