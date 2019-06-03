package lab2.repos;

import lab2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * FROM users as u JOIN cards as c ON u.id = c.card_owner_id JOIN accounts a on c.account_id = a.id where u.email = :email AND u.password = :pw", nativeQuery = true)
//    @Query("FROM users as u JOIN cards as c ON u.id = c.card_owner_id JOIN accounts as a ON c.account_id = a.id where u.email = :email AND u.password = :pw")
//    @Query("FROM users as u JOIN u.cards as c  where u.email = :email AND u.password = :pw")
    User getUserByEmailAndPassword(@Param("email") String email, @Param("pw") String pw);
}
