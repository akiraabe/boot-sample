package com.sample.domain.model;

import com.sample.app.form.BasicPlanForm;
import lombok.Data;

import javax.persistence.*;

/**
 * Domain model object of BasicPlan.
 *
 * Created by abe.akira on 2017/03/19.
 */

@Data
@Entity
@Table(name = "basic_plan")
public class BasicPlan {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long  id;
    private String name;
    private Long unitPrice;

    public BasicPlan() {}

    public BasicPlan(BasicPlanForm form) {
        this.setId(null);
        this.setName(form.getName());
        this.setUnitPrice(Long.valueOf(form.getUnitPrice()));
    }
}
