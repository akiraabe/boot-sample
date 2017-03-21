package com.sample.domain.service;

import com.sample.domain.model.UseDetail;
import com.sample.domain.repository.UseDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sarah on 2017/03/18.
 */
@Service
@Transactional
public class UseDetailService {

    @Autowired
    UseDetailRepository useDetailRepository;

    public List<UseDetail> findAll() {
        return useDetailRepository.findAll();
    }

    public void register(UseDetail useDetail) {
        useDetailRepository.save(useDetail);

    }

    public UseDetail getOne(Long id) {
        return useDetailRepository.getOne(id);
    }
}
