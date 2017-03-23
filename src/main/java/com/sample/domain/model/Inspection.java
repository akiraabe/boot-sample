package com.sample.domain.model;

import com.sample.app.form.InspectionForm;
import com.sample.util.CalendarUtil;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Domain model object of Inspection.
 * <p>
 * Created by abe.akira on 2017/03/21.
 */

@Data
@Entity
@Table(name = "inspection")
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(value = TemporalType.DATE)
    private Date inspectionDate;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
    @OneToMany
    private List<UseDetail> useDetailList;

    public Inspection() {
    }

    public Inspection(InspectionForm form) {
        this.setId(null);
        this.setInspectionDate(CalendarUtil.toDate(form.getInspectionDate()));
        this.setContract(form.getContract());
    }

    public Integer getUseAmount() {
        return useDetailList.stream().mapToInt(o -> o.getElectricEnergy()).sum();
    }

}
