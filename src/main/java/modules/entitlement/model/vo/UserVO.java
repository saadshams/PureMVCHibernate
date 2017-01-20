package modules.entitlement.model.vo;

import javax.persistence.*;

@Entity
@Table(name = "user", catalog = "entitlement", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class UserVO {

    private long id;
    private String emailAddress;
    private String password;
    private String authToken;

    public UserVO() {
    }

    public UserVO(int id) {
        this.id = id;
    }

    public UserVO(int id, String emailAddress, String password, String authToken) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.password = password;
        this.authToken = authToken;
    }

    public UserVO(String emailAddress, String password, String authToken) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.authToken = authToken;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "emailAddress", unique = true, nullable = false)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "authToken", nullable = true)
    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
