package com.store.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/7/13
 * Time: 2:17 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "users", catalog = "webstore", uniqueConstraints = {
        @UniqueConstraint(columnNames = "login")
})
public class User implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    Integer id;

    @Column(unique = true, nullable = false, length = 30)
    String login;

    @Column(nullable = false, length = 32)
    String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.user")
//    @JoinTable( name="userinroles",
//            joinColumns = @JoinColumn(name = "id", referencedColumnName = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "role_id"))
    List<UserInRoles> userInRole;

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<UserInRoles> getUserInRole() {
        return userInRole;
    }

    public void setUserInRole(List<UserInRoles> userInRole) {
        this.userInRole = userInRole;
    }
}
