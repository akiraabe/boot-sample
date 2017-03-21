package com.sample.app.form;

import com.sample.domain.model.Contract;
import lombok.Data;

/**
 * Created by centos on 3/21/17.
 */
@Data
public class InspectionForm {

    private String inspectionDate;
    private String contractId;
    private Contract contract;
}
