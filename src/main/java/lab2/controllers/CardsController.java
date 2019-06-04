package lab2.controllers;

import lab2.entities.Card;
import lab2.services.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @Autowired
    CardsService cardsService;


    @RequestMapping("/cards")
    Iterable<Card> getCards(){
        //TODO: додати прийом параметру
        return cardsService.getCardsByOwnerId(1);
    }

    @RequestMapping("/block")
    String block(){
        cardsService.block();
        return "Blocked succesfull";
    }

    @RequestMapping("/unblock")
    void unblock(){
        cardsService.unblock();
    }
}
