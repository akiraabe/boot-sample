package com.sample.domain.repository;

import com.sample.domain.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sarah on 2017/03/19.
 */
public interface BillRepository extends JpaRepository<Bill, Long> {
}
