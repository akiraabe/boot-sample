package com.sample.domain.model;

import com.sample.app.form.ContractForm;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Domain model object of Contract.
 *
 * Created by abe.akira on 2017/03/19.
 */

@Data
@Entity
@Table(name = "contract")
public class Contract {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long  id;
    private Date contractDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "basic_plan_id")
    private BasicPlan basicPlan;

    public Contract() {}

    public Contract(ContractForm form, Customer customer, BasicPlan basicPlan) {
        this.setId(null);
        this.setContractDate(toDate(form.getContractDate()));
        this.setCustomer(customer);
        this.setBasicPlan(basicPlan);
    }

    private Date toDate(String strDate) {

        return new Date();
    }
}
