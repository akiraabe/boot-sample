package com.sample.domain.service;

import com.sample.app.form.InspectionForm;
import com.sample.domain.model.UseDetail;
import com.sample.domain.repository.UseDetailRepository;
import com.sample.util.CalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        Sort sort = new Sort(Sort.Direction.ASC, "contract.id", "useDate");
        return useDetailRepository.findAll(sort);
    }

    public void register(UseDetail useDetail) {
        useDetailRepository.save(useDetail);

    }

    public UseDetail getOne(Long id) {
        return useDetailRepository.getOne(id);
    }

    public List<UseDetail> findByContractIdAndDate(InspectionForm form) {
        Date from = getFromDate(form);
        Date to = getToDate(form);
        return useDetailRepository.findByContractIdAndDuration(Long.valueOf(form.getContractId()), from, to);
    }

    private Date getToDate(InspectionForm form) {
        Date baseDate = CalendarUtil.toDate(form.getInspectionDate());
        Date prevMonthDate = CalendarUtil.addMonth(baseDate, -1);
        return CalendarUtil.getLastDayOfMonth(prevMonthDate);
    }

    private Date getFromDate(InspectionForm form) {
        Date baseDate = CalendarUtil.toDate(form.getInspectionDate());
        Date prevMonthDate = CalendarUtil.addMonth(baseDate, -2);
        return CalendarUtil.getLastDayOfMonth(prevMonthDate);
    }
}
