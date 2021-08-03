package com.example.game;

/**
 * Represents a direction that connects two rooms
 */
public class Direction
{
    /**
     * Command that triggers the direction
     */
    private String command;
    /**
     * Name of the direction
     */
    private String name;

    /**
     * Create new direction
     * @param command
     * @param name
     */
    public Direction(String command, String name)
    {
        this.command = command;
        this.name = name;
    }

    /**
     * Get direction name
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get direction command
     * @return
     */
    public String getCommand()
    {
        return command;
    }
}
