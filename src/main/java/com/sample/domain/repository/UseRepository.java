package com.sample.domain.repository;

import com.sample.domain.model.Customer;
import com.sample.domain.model.Use;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sarah on 2017/03/18.
 */
public interface UseRepository extends JpaRepository<Use, Long>{
}
