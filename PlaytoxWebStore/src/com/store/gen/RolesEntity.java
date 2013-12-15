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
@javax.persistence.Table(name = "roles")
@Entity
public class RolesEntity {
    private String role;
    private int id;

    @javax.persistence.Column(name = "role")
    @Basic
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @javax.persistence.Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    Set<UsersEntity> users;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
//    public Set<UsersEntity> getUsers() {
//        return this.users;
//    }
//
//    public void setUsers(Set<UsersEntity> users) {
//        this.users = users;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

        if (id != that.id) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = role != null ? role.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
