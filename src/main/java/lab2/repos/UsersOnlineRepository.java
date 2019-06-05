package lab2.repos;

import lab2.entities.UsersOnline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersOnlineRepository extends JpaRepository<UsersOnline, String> {


    @Query(value = "select * from users_online as uo where uo.token = :token", nativeQuery = true)
    UsersOnline findByUserId(@Param("token") String token);
}
