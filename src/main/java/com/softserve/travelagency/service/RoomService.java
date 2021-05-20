package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {

    void addRoom(Room room);

    Room getRoomById(Long id);

    List<Room> getAllRooms();

    List<Room> getAvailableRooms(String country, LocalDate arrivalDate,
                                 LocalDate departureDate);

    void deleteRoom(Long id);
}
