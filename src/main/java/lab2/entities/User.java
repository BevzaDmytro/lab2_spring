package lab2.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
     private String name;

    @Column(name = "password")
    private  String password;

    @Column(name = "email")
    private String email;

    @Column(name = "is_admin")
    private boolean isAdmin;

    //тут буде ManyToOne

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user" )
    @OneToMany(fetch = FetchType.EAGER )
    @JoinColumn(name = "card_owner_id")
//    @OneToMany
    private Set<Card> cards;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
