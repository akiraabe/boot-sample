package com.sample.domain.model

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.sample.app.form.BillForm;

/**
 *
 * EDGE TEST for calculation of the BillAmount.
 *
 * @author abe.akira
 *
 */
public class BillTest {

    /**
     * Test method for {@link com.sample.domain.model.Bill#getBillAmount()}.
     */
    @Test
    public void testGetBillAmountUse119() {
        Bill entity = createBean(119);
        assertThat(entity.getBillAmount(), is(2312));
    }

    @Test
    public void testGetBillAmountUse120() {
        Bill entity = createBean(120);
        assertThat(entity.getBillAmount(), is(2331));
    }

    @Test
    public void testGetBillAmountUse121() {
        Bill entity = createBean(121);
        assertThat(entity.getBillAmount(), is(2357));
    }

    @Test
    public void testGetBillAmountUse299() {
        Bill entity = createBean(299);
        assertThat(entity.getBillAmount(), is(6969));
    }

    @Test
    public void testGetBillAmountUse300() {
        Bill entity = createBean(300);
        assertThat(entity.getBillAmount(), is(6995));
    }

    @Test
    public void testGetBillAmountUse301() {
        Bill entity = createBean(301);
        assertThat(entity.getBillAmount(), is(7025));
    }

    /**
     * Helper method for creating test fixture.
     * @param useAmount
     * @return Bill object
     */
    private Bill createBean(Integer useAmount) {
        BillForm form = new BillForm();
        form.setBillDueDate("2017/03/31");
        form.setBillGeneratedDate("2017/03/05");

        Inspection inspection = new Inspection();
        List<UseDetail>  useDetailList = new ArrayList<>();
        UseDetail useDetail = new UseDetail();
        useDetail.setElectricEnergy(useAmount);
        useDetailList.add(useDetail);
        inspection.setUseDetailList(useDetailList);

        form.setInspection(inspection);
        Bill entity = new Bill(form);
        return entity;
    }
}
