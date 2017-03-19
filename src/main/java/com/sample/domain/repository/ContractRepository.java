package com.sample.domain.repository;

import com.sample.domain.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sarah on 2017/03/19.
 */
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
