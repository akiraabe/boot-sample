package com.sample.domain.repository;

import com.sample.domain.model.UseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by sarah on 2017/03/18.
 */
public interface UseDetailRepository extends JpaRepository<UseDetail, Long> {

    /**
     * Native Query.
     *
     * @param contractId
     * @return List of UseDetail Domain.
     */
    @Query(value = "select * from use_detail where contract_id = :contractId", nativeQuery = true)
    List<UseDetail> findByContractId(@Param("contractId") Long contractId);

    @Query(value = "select * from use_detail where contract_id = :contractId and use_date > :from and use_date <= :to", nativeQuery = true)
    List<UseDetail> findByContractIdAndDuration(@Param("contractId") Long contractId, @Param("from") Date from, @Param("to") Date to);
}
