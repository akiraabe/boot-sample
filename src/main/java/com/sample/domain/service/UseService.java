package com.sample.domain.service;

import com.sample.domain.model.Use;
import com.sample.domain.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sarah on 2017/03/18.
 */
@Service
@Transactional
public class UseService {

    @Autowired
    UseRepository useRepository;

    public List<Use> findAll() {
        return useRepository.findAll();
    }

    public void register(Use use) {
        useRepository.save(use);

    }

    public Use getOne(Long id) {
        return useRepository.getOne(id);
    }
}
