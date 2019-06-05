package lab2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_online")
public class UsersOnline {
    @Column(name = "user_id")
    private
    int userId;

    @Id
    @Column(name = "token")
    private
    String token;


    public UsersOnline() {
    }

    public UsersOnline(String token, int id) {
        this.userId = id;
        this.token = token;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
