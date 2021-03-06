package com.joantolos.kata.mars.rover.ui;

import com.joantolos.kata.mars.rover.domain.Mars;
import com.joantolos.kata.mars.rover.tools.Compass;

public class Console {

    public void prompt(){
        System.out.println("  __    __     _                           ");
        System.out.println(" / / /\\ \\ \\___| | ___ ___  _ __ ___   ___  ");
        System.out.println(" \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ ");
        System.out.println("  _  /\\  /  __/ | (_| (_) | | | | | |  __/ ");
        System.out.println(" | |_ ___ \\___/\\/\\_______/____|___|_|\\___| ");
        System.out.println(" | __/ _ \\   /    \\ / _` | '__/ __|        ");
        System.out.println(" | || (_) | / /\\/\\ \\ (_| | |  \\__ \\        ");
        System.out.println("  \\__\\___/  \\/    \\/\\__,_|_|  |___/        ");
        System.out.println("                                           ");
        System.out.println("Your rover is located by default at the 0, 0 position and it's facing North.");
        System.out.println("Every run of the program places a maximum of four random obstacles on the planet surface, represented by " + Mars.OBSTACLE);
        System.out.println("Your position on the planet is represented by an arrow pointing where the rover is facing (" +
                Compass.NORTH.getSymbol() + ", " +
                Compass.SOUTH.getSymbol() + ", " +
                Compass.EAST.getSymbol() + " or " +
                Compass.WEST.getSymbol() + ")");
        System.out.println("Type f to go forwards, b to go backwards, N to locate north, S to locate south, E to locate east and W to locate west.");
        System.out.println("Type exit to stop the exploration.");
        System.out.println("Mind the obstacles! The Rover is expensive.");
        System.out.println("");
    }

    public void print(String toPrint){
        System.out.println(toPrint);
    }

    public void exit() {
        System.out.print("\nDisconnected from Mars rover\n\n");
    }

}
