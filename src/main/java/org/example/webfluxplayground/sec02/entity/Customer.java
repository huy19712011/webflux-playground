package org.example.webfluxplayground.sec02.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/*
    We do not have @Entity in R2DBC.
    @Table / @Column are not really required here. but adding it here for your reference...!

    Spring data 4.0 seems to expect table and column names in uppercase.
*/

@Table(name = "CUSTOMER")
//@Table(name = "customer")
public class Customer {

    @Id
    private Integer id;

    //@Column("NAME")
    private String name;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
