package com.thunneycomb.thunneycombarchtype.sample;

import com.thunneycomb.thunneycombarchtype.ThunneycombArchtypeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * thunneycomb-autotest
 * 2019-11-08 11:42
 * unittest Demo
 *
 * @author Daine.H
 * @since 2015
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootTest(classes = ThunneycombArchtypeApplication.class)
public class HomeControllerSmokeTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(HomeControllerSmokeTest.class);

    @Autowired
    private HomeController controller;

    @Test
    public void contexLoadsTest() throws Exception {

        LOGGER.info(controller.greeting());
        assertThat(controller).isNotNull();
    }

}
