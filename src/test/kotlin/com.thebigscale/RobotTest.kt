package com.thebigscale

import RobotImpl
import movements.GridCoordinates
import movements.Orientation
import movements.Position
import movements.impl.BackwardRobotMovementImpl
import movements.impl.ForwardRobotMovementImpl
import movements.impl.LeftRobotMovementImpl
import movements.impl.RightRobotMovementImpl
import org.hamcrest.core.Is.*
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test


class RobotTest {

    private lateinit var scents: MutableSet<GridCoordinates>

    @Before
    fun setup(){
        scents = mutableSetOf();
    }

    @Test
    fun should_turn_robot_from_north_to_west() {
        //Given
        val initialPosition = Position(GridCoordinates(0, 0), Orientation.NORTH, false)
        val robot = RobotImpl(initialPosition)

        //When
        val newPosition = robot.move(LeftRobotMovementImpl())

        //Then
        assertThat(newPosition.orientation, `is`(Orientation.WEST))
        assertThat(newPosition.gridCoordinates, `is`(robot.position().gridCoordinates))
    }


    @Test
    fun should_turn_robot_from_south_to_east() {
        //Given
        val initialPosition = Position(GridCoordinates(10, 20), Orientation.SOUTH, false)
        val robot = RobotImpl(initialPosition)

        //When
        val newPosition = robot.move(LeftRobotMovementImpl())

        //Then
        assertThat(newPosition.orientation, `is`(Orientation.EAST))
        assertThat(newPosition.gridCoordinates, `is`(robot.position().gridCoordinates))
    }


    @Test
    fun should_turn_robot_from_east_to_north() {
        //Given
        val initialPosition = Position(GridCoordinates(10, 20), Orientation.EAST, false)
        val robot = RobotImpl(initialPosition)

        //When
        val newPosition = robot.move(LeftRobotMovementImpl())

        //Then
        assertThat(newPosition.orientation, `is`(Orientation.NORTH))
        assertThat(newPosition.gridCoordinates, `is`(robot.position().gridCoordinates))
    }

    @Test
    fun should_turn_robot_from_west_to_south() {
        //Given
        val initialPosition = Position(GridCoordinates(10, 20), Orientation.WEST, false)
        val robot = RobotImpl(initialPosition)

        //When
        val newPosition = robot.move(LeftRobotMovementImpl())

        //Then
        assertThat(newPosition.orientation, `is`(Orientation.SOUTH))
        assertThat(newPosition.gridCoordinates, `is`(robot.position().gridCoordinates))
    }

    @Test
    fun should_turn_robot_from_north_to_east() {
        //Given
        val initialPosition = Position(GridCoordinates(10, 20), Orientation.NORTH, false)
        val robot = RobotImpl(initialPosition)

        //When
        val newPosition = robot.move(RightRobotMovementImpl())

        //Then
        assertThat(newPosition.orientation, `is`(Orientation.EAST))
        assertThat(newPosition.gridCoordinates, `is`(robot.position().gridCoordinates))
    }

    @Test
    fun should_turn_robot_from_south_to_west() {
        //Given
        val initialPosition = Position(GridCoordinates(10, 20), Orientation.SOUTH, false)
        val robot = RobotImpl(initialPosition)

        //When
        val newPosition = robot.move(RightRobotMovementImpl())

        //Then
        assertThat(newPosition.orientation, `is`(Orientation.WEST))
        assertThat(newPosition.gridCoordinates, `is`(robot.position().gridCoordinates))
    }

    @Test
    fun should_turn_robot_from_east_to_south() {
        //Given
        val initialPosition = Position(GridCoordinates(10, 20), Orientation.EAST, false)
        val robot = RobotImpl(initialPosition)

        //When
        val newPosition = robot.move(RightRobotMovementImpl())

        //Then
        assertThat(newPosition.orientation, `is`(Orientation.SOUTH))
        assertThat(newPosition.gridCoordinates, `is`(robot.position().gridCoordinates))
    }

    @Test
    fun should_turn_robot_from_west_to_north() {
        //Given
        val initialPosition = Position(GridCoordinates(10, 20), Orientation.WEST, false)
        val robot = RobotImpl(initialPosition)

        //When
        val newPosition = robot.move(RightRobotMovementImpl())

        //Then
        assertThat(newPosition.orientation, `is`(Orientation.NORTH))
        assertThat(newPosition.gridCoordinates, `is`(robot.position().gridCoordinates))
    }

    @Test
    fun should_move_forward_toward_edge() {
        //Given
        val initialPosition = Position(GridCoordinates(10, 20), Orientation.NORTH, false)
        val robot = RobotImpl(initialPosition)

        //When
        val newPosition = robot.move(ForwardRobotMovementImpl())

        //Then
        assertThat(newPosition.gridCoordinates, `is`(GridCoordinates(10, 21)))
    }

    @Test
    fun should_move_backward_toward_edge() {
        //Given
        val initialPosition = Position(GridCoordinates(10, 20), Orientation.NORTH, false)
        val robot = RobotImpl(initialPosition)

        //When
        val newPosition = robot.move(BackwardRobotMovementImpl())

        //Then
        assertThat(newPosition.gridCoordinates, `is`(GridCoordinates(10, 19)))
    }
}