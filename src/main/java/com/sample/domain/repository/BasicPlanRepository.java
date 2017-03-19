package com.sample.domain.repository;

import com.sample.domain.model.BasicPlan;
import com.sample.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sarah on 2017/03/18.
 */
public interface BasicPlanRepository extends JpaRepository<BasicPlan, Long> {
}
