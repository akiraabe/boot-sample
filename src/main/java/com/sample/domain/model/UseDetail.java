package com.sample.domain.model;

import com.sample.app.form.UseDetailForm;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * Domain model object of UseDetail.
 * <p>
 * Created by abe.akira on 2017/03/20.
 */

@Data
@Entity
@Table(name = "use_detail")
public class UseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(value=TemporalType.DATE)
    private Date useDate;
    private Integer electricEnergy; //kWh(Kilo Watt Hour)

    //FIXME: Fix relationship correct is relate with the Contract.
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public UseDetail() {
    }

    public UseDetail(UseDetailForm form) {
        this.setId(null);
        this.setUseDate(toDate(form.getUseDate()));
        this.setElectricEnergy(Integer.valueOf(form.getElectricEnergy()));
        this.setCustomer(form.getCustomer());
    }

    private Date toDate(String strDate) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        TemporalAccessor ta = fmt.parse(strDate);
        ZonedDateTime zdt = LocalDate.from(ta).atTime(0, 0).atZone(ZoneId.of("Asia/Tokyo"));
        return Date.from(zdt.toInstant());
    }
}
