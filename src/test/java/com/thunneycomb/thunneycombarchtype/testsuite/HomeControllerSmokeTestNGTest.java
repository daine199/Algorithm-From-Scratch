package com.thunneycomb.thunneycombarchtype.testsuite;

import com.thunneycomb.thunneycombarchtype.TestNGCaseBase;
import com.thunneycomb.thunneycombarchtype.sample.HomeController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * thunneycomb-autotest
 * 2019-11-08 11:42
 * unittest Demo
 *
 * @author Daine.H
 * @since 2015
 **/

public class HomeControllerSmokeTestNGTest extends TestNGCaseBase {

    private final static Logger LOGGER = LoggerFactory.getLogger(HomeControllerSmokeTestNGTest.class);

    @Autowired
    private HomeController controller;

    @Test
    public void contexLoadsTest() throws Exception {

        LOGGER.info(controller.greeting());
        assertThat(controller).isNotNull();
    }

}
