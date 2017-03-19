package com.sample.domain.service;

import com.sample.domain.model.BasicPlan;
import com.sample.domain.repository.BasicPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by centos on 3/19/17.
 */
@Service
@Transactional
public class BasicPlanService {

    @Autowired
    BasicPlanRepository basicPlanRepository;

    public List<BasicPlan> findAll() {
        return basicPlanRepository.findAll();
    }

    public void register(BasicPlan basicPlan) {
        basicPlanRepository.save(basicPlan);
    }

    public BasicPlan getOne(Long id) {
        return basicPlanRepository.getOne(id);
    }
}
