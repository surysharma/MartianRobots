import movements.GridCoordinates
import movements.Position
import movements.RobotMovement

/**
 * Client facing external Robot interface.
 */
interface Robot {
    fun hasScent(gridCoordinates: GridCoordinates): Boolean
    fun move(movement: RobotMovement): Position
    fun position(): Position
}

/**
 * stateful Robot client with an up to date position
 */
class RobotImpl : Robot {

    private var position: Position

    constructor(position: Position){
        this.position = position
    }

    override fun position() = Position(this.position.gridCoordinates, this.position.orientation, this.position.hasScent)

    override fun hasScent(gridCoordinates: GridCoordinates): Boolean = position.hasScent

    override fun move(movement: RobotMovement): Position {
        this.position = movement.makeMovement(this)
        return this.position
    }
}
