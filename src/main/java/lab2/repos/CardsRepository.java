package lab2.repos;

import lab2.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CardsRepository extends JpaRepository<Card, Integer> {


    @Query(value = "select * from cards where card_owner_id = :id", nativeQuery = true)
    Iterable<Card> getCardsByOwnerId(@Param("id") int i);


    @Query(value = "select * from cards where card_number = :cardNum", nativeQuery = true)
    Card findCardByNum(@Param("cardNum") String cardNum);
}
