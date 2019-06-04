package lab2.controllers;

import lab2.services.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {
    @Autowired
    PaymentsService paymentsService;

    @RequestMapping("/pay")
    void pay(){
        paymentsService.pay();
    }
}
