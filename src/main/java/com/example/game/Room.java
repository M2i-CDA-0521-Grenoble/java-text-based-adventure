package com.example.game;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a place the player can visit
 */
public class Room
{
    /**
     * Room name
     */
    private String name;
    /**
     * List of all connected rooms associated with the direction from this room
     */
    private Map<Direction, Room> connectedRooms;

    /**
     * Create new room
     * @param name Room name
     */
    public Room(String name)
    {
        connectedRooms = new HashMap<Direction, Room>();

        this.name = name;
    }

    /**
     * Get room connected to this room in a given direction
     * @param direction The direction from this room
     * @return
     */
    public Room getRoomInDirection(Direction direction)
    {
        return connectedRooms.get(direction);
    }

    /**
     * Set room connected to this room in a given direction
     * @param direction The direction from this room
     * @param targetRoom The target room
     */
    public void setRoomInDirection(Direction direction, Room targetRoom)
    {
        connectedRooms.put(direction, targetRoom);
    }

    /**
     * Get room name
     * @return
     */
    public String getName()
    {
        return name;
    }
}
