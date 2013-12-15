package com.store.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/12/13
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "userinrole", catalog = "webstore")
@AssociationOverrides({
        @AssociationOverride(name = "pk.user",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")),
        @AssociationOverride(name = "pk.role",
        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
})
public class UserInRoles {

    @Column(name = "role_id")
    Integer roleId;

    @Column(name = "user_id")
    Integer userId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
