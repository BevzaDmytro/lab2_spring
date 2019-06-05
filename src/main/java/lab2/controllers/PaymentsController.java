package lab2.controllers;

import lab2.services.PaymentsService;
import lab2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {
    @Autowired
    PaymentsService paymentsService;
    @Autowired
    UserService userService;

    @RequestMapping("/pay")
    public String pay(@RequestHeader("Authorization") String token, @RequestParam("senderCard") String senderCardNum, @RequestParam("recipient") String recipientCardNum, @RequestParam("amount") String amount) {
        if(!userService.isUserLoggedIn(token))
        return null;

        paymentsService.pay(senderCardNum, recipientCardNum, amount);

        return paymentsService.getPaymentStatus();
    }
}
