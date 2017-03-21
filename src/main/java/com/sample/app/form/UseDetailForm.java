package com.sample.app.form;

import com.sample.domain.model.Customer;
import lombok.Data;

import java.util.Date;

/**
 * Created by abe.akira on 2017/03/20.
 */
@Data
public class UseDetailForm {
    private String useDate;
    private String electricEnergy;
    private String customerId;
    private Customer customer;
}
