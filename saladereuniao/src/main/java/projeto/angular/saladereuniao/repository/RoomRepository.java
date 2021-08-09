package projeto.angular.saladereuniao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.angular.saladereuniao.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {


}