package com.store.gen;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/13/13
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserinrolesEntityPK implements Serializable {
    private int roleId;
    private int userId;

@Id
@Column(name = "role_id")
public int getRoleId() {
    return roleId;
}

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "user_id")
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

        UserinrolesEntityPK that = (UserinrolesEntityPK) o;

        if (roleId != that.roleId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + userId;
        return result;
}}
