# MartianRobots
A martian Robot will get instructions from an external source and perform its movements.

Rules of the game
-------------
The surface of Mars can be modelled by a rectangular grid around which robots are able to move according to instructions provided from Earth. 

You are to write a program that determines each sequence of robot positions and reports the final position of the robot.

A robot position consists of a grid coordinate (a pair of integers: x-coordinate followed by y-coordinate) and an orientation (N, S, E, W for north, south, east, and west).

A robot instruction is a string of the letters “L”, “R”, and “F” which represent, respectively, the instructions:

● Left: the robot turns left 90 degrees and remains on the current grid point.

● Right: the robot turns right 90 degrees and remains on the current grid point.

● Forward: the robot moves forward one grid point in the direction of the current
orientation and maintains the same orientation.

The direction North corresponds to the direction from grid point (x, y) to grid point (x, y+1). There is also a possibility that additional command types may be required in the future and provision should be made for this.

How to build
------------
Standard Maven lifecycles. 

How to test
-----------
There are unit tests

`mvn clean test` 


TODO's
--------

TODO: Refactor the movements to its own strategies
 

