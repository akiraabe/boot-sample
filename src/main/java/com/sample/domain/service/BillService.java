package com.sample.domain.service;

import com.sample.domain.model.Bill;
import com.sample.domain.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sarah on 2017/03/19.
 */
@Service
@Transactional
public class BillService {

    @Autowired
    BillRepository billRepository;

    public List<Bill> findAll() {

        return billRepository.findAll();
    }

    public Bill getOne(Long id) {

        return billRepository.getOne(id);
    }

    public void register(Bill bill) {

        billRepository.save(bill);
    }
}
