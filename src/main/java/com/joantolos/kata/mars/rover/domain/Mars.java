package com.joantolos.kata.mars.rover.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.IntStream;

public class Mars {

    private Integer size;
    public static final String OBSTACLE = "\u1040";
    private List<Position> obstacles = new ArrayList<>();

    public Mars() throws IOException {
        Properties marsConfig = new Properties();
        marsConfig.load(this.getClass().getResourceAsStream("/mars.properties"));
        this.size = Integer.valueOf(marsConfig.getProperty("size"));
        this.createObstacles(Integer.valueOf(marsConfig.getProperty("max.obstacles")));
    }

    private void createObstacles(Integer maxObstacle) {
        IntStream.range(0, maxObstacle).forEach(i -> obstacles.add(new Position(randomPoint(), randomPoint())));
    }

    private int randomPoint() {
        return new Random().nextInt(size - 1 + 1) + 1;
    }

    public Integer getSize() {
        return size;
    }

    public List<Position> getObstacles() {
        return obstacles;
    }
}
