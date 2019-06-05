package lab2.controllers;

import lab2.entities.Card;
import lab2.services.CardsService;
import lab2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardsController {
    @Autowired
    CardsService cardsService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    Iterable<Card> getCards(@RequestHeader("Authorization") String token){
        int userId =  userService.getUserOnline(token);
        return cardsService.getCardsByOwnerId(userId);
    }

    @RequestMapping(value = "/block", method = RequestMethod.POST)
    String block(@RequestHeader("Authorization") String token, @RequestParam("cardToBlock") String cardNum){
        cardsService.block(cardNum);
        return "{\"message\" : \"Card is blocked\"}";
    }

    @RequestMapping(value = "/unblock", method = RequestMethod.POST)
    String unblock(@RequestHeader("Authorization") String token, @RequestParam("unblockCard") String cardNum){
        if(!userService.isUserLoggedIn(token))
            return null;
        if(userService.isUserAdmin(token)) {
            cardsService.unblock(cardNum);
        }
        else {
            //return 500
        }
        return "{\"message\" : \"Card is unblocked\"}";
    }
}
