package com.thunneycomb.thunneycombarchtype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;


@SpringBootTest(classes = ThunneycombArchtypeApplication.class)
@ImportResource(locations={"classpath:application-context.xml"})
public class TestNGCaseBase extends AbstractTestNGSpringContextTests {

    Logger logger = LoggerFactory.getLogger(TestNGCaseBase.class);

    @BeforeMethod
    public void setUp() {
        logger.info("Init TestNGCaseBase.");
    }
}
