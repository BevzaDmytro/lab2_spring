package lab2.services;

import lab2.entities.Card;
import lab2.repos.AccountsRepository;
import lab2.repos.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService {

    @Autowired
    CardsRepository cardsRepository;

    @Autowired
    AccountsRepository accountsRepository;

    private boolean isPaymentSuccesfull;
    private String paymentStatus;

    public boolean isPaymentSuccesfull() {
        return isPaymentSuccesfull;
    }

    public void setPaymentSuccesfull(boolean paymentSuccesfull) {
        isPaymentSuccesfull = paymentSuccesfull;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void changePaymentStatus(String paymentStatus) {
        this.paymentStatus = "{ \"message\" : \""+paymentStatus+"\"}";;
    }

    public void pay(String senderCardNum, String recipientCardNum, String amount) {
        float money = Float.valueOf(amount);

        Card card1 = cardsRepository.findCardByNum(senderCardNum);
        Card card2 = cardsRepository.findCardByNum(recipientCardNum);
        if(card2 == null) {
            this.changePaymentStatus( "recipient card does not exist");
            return;
        }

        if(card1.isBlocked() || card2.isBlocked()) this.changePaymentStatus( "Card is blocked");
        if(card1.getAccount().getBalance() < money) this.changePaymentStatus( "Not enough money");

        card1.getAccount().setBalance(card1.getAccount().getBalance() - money);
        card2.getAccount().setBalance(card2.getAccount().getBalance() + money);

        accountsRepository.saveAndFlush(card1.getAccount());
        accountsRepository.saveAndFlush(card2.getAccount());

        this.changePaymentStatus("Payment successful");
    }
}
