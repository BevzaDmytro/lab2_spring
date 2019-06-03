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
        return null;
    }

    @RequestMapping("/block")
    String block(){
        return null;
    }

    @RequestMapping("/unblock")
    String unblock(){
        return null;
    }
}
