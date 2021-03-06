package com.sample.domain.model;

import com.sample.app.form.CustomerForm;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Domain model object of Customer.
 *
 * Created by abe.akira on 2017/03/18.
 */

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String address;

    public Customer(CustomerForm form) {
        this.setId(form.getId());
        this.setName(form.getName());
        this.setAddress(form.getAddress());
        this.setPhoneNumber(form.getPhoneNumber());
    }
    public Customer() {
        super();
    }
}
