package com.store.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/12/13
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Roles {

    @Id
    @Column
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    Integer id;

    @Column
    String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
