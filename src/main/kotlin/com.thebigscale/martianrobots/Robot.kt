package martianrobots

interface Robot {
    fun orientation(): Orientation
    fun getGridCoordinates(): GridCoordinates
    fun location(): GridCoordinates
    fun moveForward(): Boolean
    fun moveBackward(): Boolean
    fun turnLeft(): Boolean
    fun turnRight(): Boolean
}

class RobotImpl(x: Int, y: Int, orientation: Orientation, private val scent: Set<GridCoordinates>) : Robot {
    private var gridCoordinates: GridCoordinates = GridCoordinates(x, y)
    private var orientation: Orientation

    init {
        this.orientation = orientation
    }

    private fun hasScent(x: Int, y: Int): Boolean {
        return scent.contains(GridCoordinates(x, y))
    }

    override fun orientation(): Orientation {
        return orientation
    }

    override fun getGridCoordinates(): GridCoordinates {
        return gridCoordinates
    }

    override fun location(): GridCoordinates {
        return gridCoordinates
    }

    override fun moveForward(): Boolean {
        var x: Int = gridCoordinates.x
        var y: Int = gridCoordinates.y
        when (orientation) {
            Orientation.EAST -> x++
            Orientation.WEST -> x--
            Orientation.NORTH -> y++
            Orientation.SOUTH -> y--
        }
        if (hasScent(x, y)) return false
        GridCoordinates(x, y)
        return true
    }

    override fun moveBackward(): Boolean {
        var x: Int = gridCoordinates.x
        var y: Int = gridCoordinates.y
        when (orientation) {
            Orientation.EAST -> x--
            Orientation.WEST -> x++
            Orientation.NORTH -> y--
            Orientation.SOUTH -> y++
        }
        if (hasScent(x, y)) return false
        GridCoordinates(x, y)
        return true
    }

    override fun turnLeft(): Boolean {
        orientation = when (orientation) {
            Orientation.EAST -> Orientation.NORTH
            Orientation.WEST -> Orientation.SOUTH
            Orientation.NORTH -> Orientation.WEST
            Orientation.SOUTH -> Orientation.EAST
        }
        return true
    }

    override fun turnRight(): Boolean {
        orientation = when (orientation) {
            Orientation.NORTH -> Orientation.EAST
            Orientation.SOUTH -> Orientation.WEST
            Orientation.EAST -> Orientation.SOUTH
            Orientation.WEST -> Orientation.NORTH
        }
        return true
    }
}

enum class Orientation(prettyPrint: String) {
    EAST("E"), WEST("W"), NORTH("N"), SOUTH("S")
}

data class GridCoordinates(val x: Int, val y: Int)