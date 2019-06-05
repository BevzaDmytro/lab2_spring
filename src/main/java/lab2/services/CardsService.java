package lab2.services;


import lab2.entities.Card;
import lab2.repos.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardsService {

    @Autowired
    CardsRepository cardsRepository;

    public Iterable<Card> getCardsByOwnerId(int i){
        return cardsRepository.getCardsByOwnerId(i);
    }

    public void block(String cardNum) {
        Card card = cardsRepository.findCardByNum(cardNum);
        card.setBlocked(true);
        cardsRepository.saveAndFlush(card);
    }

    public void unblock(String cardNum) {
        Card card = cardsRepository.findCardByNum(cardNum);
        card.setBlocked(false);
        cardsRepository.saveAndFlush(card);
    }
}
