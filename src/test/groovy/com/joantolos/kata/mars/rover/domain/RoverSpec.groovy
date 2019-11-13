package com.joantolos.kata.mars.rover.domain

import com.joantolos.kata.mars.rover.tools.Compass
import com.joantolos.kata.mars.rover.ui.Console
import spock.lang.Shared
import spock.lang.Specification

class RoverSpec extends Specification {

    @Shared MarsMap map

    def setupSpec() {
        Movements.valueOf(Movements.BACKWARD.toString())
        Compass.valueOf(Compass.NORTH.toString())
        map = new MarsMap(new Position(0,0), Compass.NORTH)
    }

    def 'Mars Rover should return its location' () {
        given:
        Rover rover = new Rover(0,0,Compass.NORTH, new Console())

        expect:
        rover.getPosition()
    }

    def 'Mars Rover should move forwards when facing every direction, including edge positions' () {
        given: 'Moving a new rover forwards'
        Rover rover = new Rover(startingX, startingY, direction, new Console())
        rover.move(Movements.FORWARD)

        expect: 'The correct position'
        rover.getPosition().x == expectingX
        rover.getPosition().y == expectingY

        where: 'The rover is facing all possible directions'
        startingX   |   startingY   ||   direction          |   expectingX  |   expectingY
        1           |   1           ||   Compass.NORTH      |   1           |   2
        1           |   1           ||   Compass.SOUTH      |   1           |   0
        1           |   1           ||   Compass.EAST       |   2           |   1
        1           |   1           ||   Compass.WEST       |   0           |   1

        99          |   99          ||   Compass.NORTH      |   99          |   0
        1           |   1           ||   Compass.SOUTH      |   1           |   0
        99          |   99          ||   Compass.EAST       |   0           |   99
        1           |   1           ||   Compass.WEST       |   0           |   1
    }

    def 'Mars Rover should move backwards when facing every direction, including edge positions' () {
        given: 'Moving a new rover backwards'
        Rover rover = new Rover(startingX, startingY, direction, new Console())
        rover.move(Movements.BACKWARD)

        expect: 'The correct position'
        rover.getPosition().x == expectingX
        rover.getPosition().y == expectingY

        where: 'The rover is facing all possible directions'
        startingX       |   startingY   ||   direction          |   expectingX  |   expectingY
        1               |   1           ||   Compass.NORTH      |   1           |   0
        1               |   1           ||   Compass.SOUTH      |   1           |   2
        1               |   1           ||   Compass.EAST       |   0           |   1
        1               |   1           ||   Compass.WEST       |   2           |   1

        99              |   99          ||   Compass.SOUTH      |   99          |   0
        1               |   1           ||   Compass.NORTH      |   1           |   0
        99              |   99          ||   Compass.WEST       |   0           |   99
        1               |   1           ||   Compass.EAST       |   0           |   1
    }

    def 'Should send command stream to rover' () {
        given: 'A new rover'
        Rover rover = new Rover(1,1,Compass.NORTH, new Console())

        when: 'Sending the command "forwards, backwards, East, backwards, North, forwards, South, West"'
        rover.sendSequence('fbEbNfSW')

        then:
        rover.position == new Position(0, 2)
        rover.currentDirection == Compass.WEST
    }

    def 'Should stop the rover when found an obstacle' () {
        given: 'A new rover'
        Rover rover = new Rover(1,1,Compass.NORTH, new Console())

        when: 'Moving the rover to all possible positions'
        Integer numberOfMovementsMade = 0

        for(int i=1; i<= rover.getMarsMap().getSize(); i++){
            for(int j=1; j<= rover.getMarsMap().getSize(); j++){
                if(!rover.sendSequence('f'))
                    break
                numberOfMovementsMade++
            }
            if(!rover.sendSequence('EfS'))
                break
        }

        then: 'The number of movements should be less than the total square number'
        Integer maximumSquaresPossible = rover.getMarsMap().getSize() * rover.getMarsMap().getSize()
        numberOfMovementsMade < maximumSquaresPossible
    }
}
