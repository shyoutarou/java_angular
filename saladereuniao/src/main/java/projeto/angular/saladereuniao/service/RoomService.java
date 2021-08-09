package projeto.angular.saladereuniao.service;

import projeto.angular.saladereuniao.exception.ResourceNotFoundException;
import projeto.angular.saladereuniao.model.Room;
import projeto.angular.saladereuniao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    public Room findRoomById(long id) throws ResourceNotFoundException {
        return verifyIfRoomExists(id);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(long id, Room room) throws ResourceNotFoundException {
        verifyIfRoomExists(id);
        return roomRepository.save(room);
    }

    public void deleteRoom(long id) throws ResourceNotFoundException {
        verifyIfRoomExists(id);
        roomRepository.deleteById(id);
    }

    private Room verifyIfRoomExists(long id) throws ResourceNotFoundException {
        return roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found:: " + id));
    }
}