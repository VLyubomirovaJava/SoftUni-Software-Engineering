package automappingobjectsexercise.repository;

import automappingobjectsexercise.models.entity.Game;
import automappingobjectsexercise.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmailAndPassword(String email, String password);
    @Query("SELECT u.games FROM User u WHERE u.id=:id")
    List<Game> findAllByUser(Long id);
}