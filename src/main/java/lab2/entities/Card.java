package lab2.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "card_number")
    private String cardNum;

    public int getCardOwnerId() {
        return cardOwnerId;
    }

    public void setCardOwnerId(int cardOwnerId) {
        this.cardOwnerId = cardOwnerId;
    }

    @Column(name = "card_owner_id")
    private int cardOwnerId;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "card_owner_id")
//    private User user;

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
    //    @Column(name = "account_id")

    @OneToOne(optional = false)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "is_blocked")
    private boolean isBlocked;

    public Card() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }



    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
