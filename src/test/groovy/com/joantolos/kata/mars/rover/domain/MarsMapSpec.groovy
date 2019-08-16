package com.joantolos.kata.mars.rover.domain

import com.joantolos.kata.mars.rover.tools.Compass
import spock.lang.Shared
import spock.lang.Specification

class MarsMapSpec extends Specification {

    @Shared MarsMap marsMap

    def setupSpec() {
        marsMap = new MarsMap(new Position(0,0), Compass.NORTH)
    }

    def 'Mars map should return initial coordinates state' () {
        expect:
        marsMap.coordinates[0][0] == '[ ↑ ]'
    }

    def 'Mars map should return new position' () {
        given: 'I mark the new Mars rover position'
        marsMap.render(new Position(0, 1), Compass.EAST)

        expect:
        marsMap.coordinates[0][0] == '[   ]'
        marsMap.coordinates[1][0] == '[ → ]'
    }

    def 'Mars map should return initial position' () {
        given: 'I mark the new Mars rover position'
        new MarsMap(new Position(0,0), Compass.NORTH)
    }

    def 'Mars map should return a printable map' () {
        given: 'I mark the new Mars rover position'
        MarsMap map = new MarsMap(new Position(0,0), Compass.NORTH)
        map.getPrintable() != null
    }
}
