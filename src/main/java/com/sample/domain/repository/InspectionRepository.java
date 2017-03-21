package com.sample.domain.repository;

import com.sample.domain.model.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by centos on 3/21/17.
 */
public interface InspectionRepository  extends JpaRepository<Inspection, Long> {
}
