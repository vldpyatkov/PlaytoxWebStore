package com.store.gen;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/13/13
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "users")
@Entity
public class UsersEntity {
    private String login;

    @javax.persistence.Column(name = "login")
    @Basic
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private int id;

    @javax.persistence.Column(name = "id")
    @Id
    @TableGenerator(table = "id_table", name = "AppUserIdTable",
            allocationSize = 1000, initialValue = 0, pkColumnName = "pk",
            valueColumnName = "value", pkColumnValue = "app_users")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "AppUserIdTable")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String password;

    @javax.persistence.Column(name = "password")
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Set<RolesEntity> roles;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "userinroles", catalog = "webstore", joinColumns = {
            @JoinColumn(name = "user_id", updatable = true, referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id", updatable = true, referencedColumnName = "id") })
    public Set<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesEntity> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
