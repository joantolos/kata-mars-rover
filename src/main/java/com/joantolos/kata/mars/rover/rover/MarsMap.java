package com.joantolos.kata.mars.rover.rover;

import com.joantolos.kata.mars.rover.domain.Mars;
import com.joantolos.kata.mars.rover.domain.Position;
import com.joantolos.kata.mars.rover.utils.Compass;

import java.util.stream.IntStream;

public class MarsMap {

    private String[][] coordinates;

    public MarsMap(Position position, Compass compass){
        this.coordinates = new String[Mars.SIZE][Mars.SIZE];
        this.renderMap(position, compass);
    }

    public Boolean renderMap(Position position, Compass compass) {
        IntStream.range(0, Mars.SIZE).forEach(currentX -> {
            IntStream.range(0, Mars.SIZE).forEach(currentY -> {
                if(currentX == position.getX() && currentY == position.getY()){
                    coordinates[currentX][currentY] = "[ " + compass.getInitial() + " ]";
                } else {
                    if(isPositionAvailable(new Position(currentX, currentY))) {
                        coordinates[currentX][currentY] = "[   ]";
                    } else {
                        coordinates[currentX][currentY] = "[ # ]";
                    }
                }
            });
        });
        return true;
    }

    public Boolean isPositionAvailable(Position position){
        return Mars.obstacles().stream().filter(obstacle -> obstacle.equals(position)).findFirst().orElse(null)==null;
    }

    public String[][] getCoordinates() {
        return coordinates;
    }
}