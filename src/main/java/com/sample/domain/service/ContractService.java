package com.sample.domain.service;

import com.sample.domain.model.Contract;
import com.sample.domain.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sarah on 2017/03/19.
 */
@Service
@Transactional
public class ContractService {

    @Autowired
    ContractRepository contractRepository;

    public List<Contract> findAll() {

        return contractRepository.findAll();
    }

    public Contract getOne(Long id) {

        return contractRepository.getOne(id);
    }

    public void register(Contract contract) {

        contractRepository.save(contract);
    }
}
