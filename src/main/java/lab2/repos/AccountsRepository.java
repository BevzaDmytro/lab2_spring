package lab2.repos;

import lab2.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Account, Integer> {
}
