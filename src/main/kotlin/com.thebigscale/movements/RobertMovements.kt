package movements

/**
 * Interfaces representing different types of Robotic movements.
 */
import Robot

interface RobotMovement {
    fun makeMovement(robot: Robot): Position
}

interface ForwardRobotMovement: RobotMovement{
    override fun makeMovement(robot: Robot): Position
}

interface BackwardRobotMovement: RobotMovement{
    override fun makeMovement(robot: Robot): Position
}


interface LeftRobotMovement: RobotMovement{
    override fun makeMovement(robot: Robot): Position

}


interface RightRobotMovement: RobotMovement{
    override fun makeMovement(robot: Robot): Position
}

data class Position(val gridCoordinates: GridCoordinates, val orientation: Orientation, val hasScent: Boolean)

enum class Orientation(prettyPrint: String) {
    EAST("E"), WEST("W"), NORTH("N"), SOUTH("S")
}

data class GridCoordinates(val x: Int, val y: Int)
