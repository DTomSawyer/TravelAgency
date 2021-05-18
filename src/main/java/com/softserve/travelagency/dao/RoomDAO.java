package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomDAO {

    void saveRoom(Room room);

    Optional<Room> getRoomById(Long id);

    public List<Room> getAllRooms();

    public List<Room> getAvailableRooms(String country, LocalDate arrivalDate,
                                        LocalDate departureDate);

    public void deleteRoom(Long id);
}
