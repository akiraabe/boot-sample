package com.sample.domain.service;

import com.sample.app.form.InspectionForm;
import com.sample.domain.model.Contract;
import com.sample.domain.model.Inspection;
import com.sample.domain.model.UseDetail;
import com.sample.domain.repository.InspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by centos on 3/21/17.
 */
@Service
@Transactional
public class InspectionService {

    @Autowired
    InspectionRepository inspectionRepository;

    @Autowired
    ContractService contractService;


    @Autowired
    UseDetailService useDetailService;

    public List<Inspection> findAll() {

        return inspectionRepository.findAll();
    }

    public Inspection getOne(Long id) {
        return inspectionRepository.getOne(id);
    }

    /**
     * Register Inspection object.
     * <pre>
     *     Setting related object.
     *     -UseDetails(target duration)
     *     -Contract
     * </pre>
     * @param form
     */
    public void register(InspectionForm form) {
        Contract contract = contractService.getOne(Long.valueOf(form.getContractId()));
        form.setContract(contract);

        Inspection inspection = new Inspection(form);
        List<UseDetail> useDetails = useDetailService.findByContractIdAndDate(form);
        inspection.setUseDetailList(useDetails);
        this.register(inspection);
    }

    private void register(Inspection inspection) {
        inspectionRepository.save(inspection);
    }
}
