package com.sample.domain.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by sarah on 2017/03/18.
 */
public class CustomerTest {

    @Test
    public void testConstructor() {

        Customer akira = new Customer();
        akira.setCustomerId("0001");
        akira.setName("Akira Abe");
        akira.setPhoneNumber("0000-1111-2222");
        akira.setAddress("Chiba, Japan");

        assertThat(akira.getCustomerId(), is ("0001"));
        assertThat(akira.getName(), is ("Akira Abe"));
        assertThat(akira.getPhoneNumber(), is ("0000-1111-2222"));
        assertThat(akira.getAddress(), is ("Chiba, Japan"));
    }

}
