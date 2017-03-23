package com.sample.domain.model;

import com.sample.app.form.UseDetailForm;
import com.sample.util.CalendarUtil;
import lombok.Data;

import javax.persistence.*;
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
    @Temporal(value = TemporalType.DATE)
    private Date useDate;
    private Integer electricEnergy; //kWh(Kilo Watt Hour)

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public UseDetail() {
    }

    public UseDetail(UseDetailForm form) {
        this.setId(null);
        this.setUseDate(CalendarUtil.toDate(form.getUseDate()));
        this.setElectricEnergy(Integer.valueOf(form.getElectricEnergy()));
        this.setContract(form.getContract());
    }
}
