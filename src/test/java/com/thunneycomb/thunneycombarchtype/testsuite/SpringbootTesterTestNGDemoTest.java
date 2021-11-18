package com.thunneycomb.thunneycombarchtype.testsuite;

import com.alibaba.fastjson.JSONObject;
import com.thunneycomb.thunneycombarchtype.TestNGCaseBase;
import com.thunneycomb.thunneycombarchtype.utility.DataUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * thunneycomb-archtype
 * 2019-07-25 17:53
 *
 * @author Daine.H
 * @since 2015
 **/

public class SpringbootTesterTestNGDemoTest extends TestNGCaseBase {

    private final static Logger LOGGER = LoggerFactory.getLogger(SpringbootTesterTestNGDemoTest.class);

    @Test(dataProvider = "testDataProviderTest" )
    public void testNGDemoTest (String caseInfo, JSONObject req, JSONObject exp, String comment) {

        LOGGER.info("TestNG 驱动的集成测试。");
        LOGGER.info(caseInfo);
        LOGGER.info(req.toString());
        LOGGER.info(exp.toString());
        LOGGER.info(comment);

    }

    @DataProvider
    public  Object[][] testDataProviderTest () {
        return DataUtility.getData("data/base.json");
    }

}
