package com.thebigscale

import junit.framework.Assert.*
import GridCoordinates
import Orientation
import RobotImpl
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
        val robot = RobotImpl(10, 20, Orientation.NORTH, scents)
        assertTrue(robot.turnLeft())
        assertThat(Orientation.WEST, `is`(robot.orientation()))
    }

    @Test
    fun should_turn_robot_from_south_to_east() {
        //Given
        val robot = RobotImpl(10, 20, Orientation.SOUTH, scents)

        //When
        val turnLeft = robot.turnLeft()

        //Then
        assertTrue(turnLeft)
        assertThat(Orientation.EAST, `is`(robot.orientation()))
    }

    @Test
    fun should_turn_robot_from_east_to_north() {
        //Given
        val robot = RobotImpl(10, 20, Orientation.EAST, scents)

        //When
        val turnLeft = robot.turnLeft()

        //Then
        assertTrue(turnLeft)
        assertThat(Orientation.NORTH, `is`(robot.orientation()))
    }

    @Test
    fun should_turn_robot_from_west_to_south() {
        //Given
        val robot = RobotImpl(10, 20, Orientation.WEST, scents)
        //When
        val turnLeft = robot.turnLeft()

        //Then
        assertTrue(turnLeft)
        assertThat(Orientation.SOUTH, `is`(robot.orientation()))
    }

    @Test
    fun should_turn_robot_from_north_to_east() {
        //Given
        val robot = RobotImpl(10, 20, Orientation.NORTH, scents)

        //When
        val turnRight = robot.turnRight()

        //Then
        assertTrue(turnRight)
        assertThat(Orientation.EAST, `is`(robot.orientation()))
    }

    @Test
    fun should_turn_robot_from_south_to_west() {
        //Given
        val robot = RobotImpl(10, 20, Orientation.SOUTH, scents)

        //When
        val turnRight = robot.turnRight()

        //Then
        assertTrue(turnRight)
        assertThat(Orientation.WEST, `is`(robot.orientation()))
    }

    @Test
    fun should_turn_robot_from_east_to_south() {
        //Given
        val robot = RobotImpl(10, 20, Orientation.EAST, scents)

        //When
        val turnRight = robot.turnRight()

        //Then
        assertTrue(turnRight)
        assertThat(Orientation.SOUTH, `is`(robot.orientation()))
    }

    @Test
    fun should_turn_robot_from_west_to_north() {
        //Given
        val robot = RobotImpl(10, 20, Orientation.WEST, scents)

        //When
        val turnRight = robot.turnRight()

        //Then
        assertTrue(turnRight)
        assertThat(Orientation.NORTH, `is`(robot.orientation()))
    }


    @Test
    fun should_move_forward_toward_edge(): Unit {
        //Given
        val robot = RobotImpl(10, 20, Orientation.NORTH, scents)
        scents.add(GridCoordinates(10, 21))

        //When
        val moveForward = robot.moveForward()

        //Then
        assertFalse(moveForward)
        assertThat(GridCoordinates(10, 20), `is`(robot.getGridCoordinates()))

    }

    @Test
    fun should_move_backward_toward_edge() {
        //Given
        val robot = RobotImpl(10, 20, Orientation.NORTH, scents)
        scents.add(GridCoordinates(10, 19))
        scents.add(GridCoordinates(6, 4))

        //When
        val moveBackward = robot.moveBackward()

        //Then
        assertFalse(moveBackward)
        assertThat(GridCoordinates(10, 20), `is`(robot.getGridCoordinates()))
    }

}