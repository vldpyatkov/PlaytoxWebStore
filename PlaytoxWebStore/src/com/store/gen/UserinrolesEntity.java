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
@javax.persistence.IdClass(com.store.gen.UserinrolesEntityPK.class)
@javax.persistence.Table(name = "userinroles")
@Entity
public class UserinrolesEntity {
    private int roleId;

    @javax.persistence.Column(name = "role_id")
    @Id
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    private int userId;

    @javax.persistence.Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserinrolesEntity that = (UserinrolesEntity) o;

        if (roleId != that.roleId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + userId;
        return result;
    }
}
