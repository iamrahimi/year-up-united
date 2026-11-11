package com.iamsrahimi.hotelOperations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    public void checkIn_shouldOccupyRoom_whenRoomIsAvailable() {
        // arrange
        Room room = new Room();
        boolean expectedResult = true;

        // act
        boolean actualResult = room.checkIn();

        // assert
        assertEquals(expectedResult, actualResult);
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void checkOut_shouldMakeRoomAvailable_afterGuestChecksOut() {
        // arrange
        Room room = new Room();
        room.checkIn();

        // act
        room.checkOut();

        // assert
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
    }

    @Test
    public void cleanRoom_shouldClearDirtyStatus_whenRoomIsDirty() {
        // arrange
        Room room = new Room();
        room.checkIn(); // checkIn makes the room dirty

        // act
        room.cleanRoom();

        // assert
        assertFalse(room.isDirty());
        assertTrue(room.isOccupied());
    }
}