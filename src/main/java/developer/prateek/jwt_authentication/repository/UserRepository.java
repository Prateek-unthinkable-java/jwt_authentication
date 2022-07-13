package developer.prateek.jwt_authentication.repository;

import developer.prateek.jwt_authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Boolean existsByUsername(String userName);

    @Query("select u from User u where u.username=:username")
    public User getUserByName(@Param("username") String username);
}
