package com.sample.app.form;

import com.sample.domain.model.Inspection;
import lombok.Data;

/**
 * Created by akiraabe on 2017/03/23.
 */
@Data
public class BillForm {

    private String billGeneratedDate;
    private String billDueDate;
    private String inspectionId;
    private Inspection inspection;
}
