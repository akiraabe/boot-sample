package com.sample.domain.model;

import com.sample.app.form.BillForm;
import com.sample.util.CalendarUtil;

import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * Domain model object of Bill.
 * <p>
 * Created by abe.akira on 2017/03/22.
 */

@Data
@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(value = TemporalType.DATE)
    private Date billGeneratedDate;

    @Temporal(value = TemporalType.DATE)
    private Date billDueDate;

    @OneToOne
    @JoinColumn(name = "inspection_id")
    private Inspection inspection;

    public Bill() {
    }

    public Bill(BillForm form) {
        this.setId(null);
        this.setBillGeneratedDate(CalendarUtil.toDate(form.getBillGeneratedDate()));
        this.setBillDueDate(CalendarUtil.toDate(form.getBillDueDate()));
        this.setInspection(form.getInspection());
    }

    public Integer getBillAmount() {
        BigDecimal billAmount = new BigDecimal(0);
        int useAmount = inspection.getUseAmount().intValue();
        if (useAmount <= 120) {
            billAmount = new BigDecimal(useAmount).multiply(new BigDecimal(19.43)).setScale(0, RoundingMode.FLOOR);
            return billAmount.intValue();
        }

        if (useAmount <= 300) {
            billAmount = new BigDecimal("2331.6"); // 120 * 19.43 = 2331.6
            billAmount = billAmount.add(new BigDecimal(useAmount - 120).multiply(new BigDecimal(25.91))).setScale(0, RoundingMode.FLOOR);
            return billAmount.intValue();
        }

        if (useAmount > 300) {
            billAmount = new BigDecimal("6995.4"); // 120 * 19.43 + 180 * 25.91
            billAmount = billAmount.add(new BigDecimal(useAmount - 300).multiply(new BigDecimal(29.93))).setScale(0, RoundingMode.FLOOR);
            return billAmount.intValue();
        }
        return null;
    }
}
