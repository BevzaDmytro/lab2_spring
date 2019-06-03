package lab2.repos;

import lab2.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<Card, Integer> {
}
