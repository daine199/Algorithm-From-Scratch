package com.thunneycomb.thunneycombarchtype.algorithm;

import com.thunneycomb.thunneycombarchtype.TestNGCaseBase;
import com.thunneycomb.thunneycombarchtype.utility.DataUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ArraysAlgorithmTest extends TestNGCaseBase {

    private final static Logger LOGGER = LoggerFactory.getLogger(ArraysAlgorithmTest.class);

    int[] nums = new int[] {1, 1, 2, 2, 3, 3, 3, 2, 6};
    int[] nums2 = new int[] {1, 3, 5, 34, 23, 1, 2, 2, 3, 24, 311, 356 ,231, 567, 11, 1, 54, 2, 3, 66};
    int[] stock_1 = new int[] {7,1,5,3,6,4};
    int[] stock_2 = new int[] {1,2,3,4,5};
    int[] stock_3 = new int[] {7,6,4,3,1};

    @Test
    public void removeDuplicatesTest() {
        int strip_len =  ArraysAlgorithm.removeDuplicates_0(nums);
        LOGGER.info("函数原始长度为{}, 新长度为{}",nums.length, strip_len);
    };

    @Test
    public void removeDuplicates_2Test() {
        int strip_len =  ArraysAlgorithm.removeDuplicates_2(nums);
        LOGGER.info("函数原始长度为{}, 新长度为{}",nums.length, strip_len);
    }

    @Test
    public void removeDuplicates_3Test() {
        int strip_len =  ArraysAlgorithm.removeDuplicates_3(nums2);
        LOGGER.info("函数原始长度为{}, 新长度为{}",nums.length, strip_len);
    }

    @Test
    public void removeDuplicates_4Test() {
        int strip_len = ArraysAlgorithm.removeDuplicates_3(nums2);
        LOGGER.info("函数原始长度为{}, 新长度为{}",nums2.length, strip_len);
    }

    @Test(dataProvider = "dataMaxProfitTest")
    public void maxProfitTest(int[] prices) {
        /**
         * 输入: prices = [7,1,5,3,6,4]
         * 输出: 7
         * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
         *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
         */
        int max_profit = ArraysAlgorithm.maxProfit(prices);
        LOGGER.info("最大利润为 {}", max_profit);
    }

    @DataProvider
    public  Object[][] dataMaxProfitTest () {
        return DataUtility.getArrays("algorithm/maxProfitCases.json");
    }

    @Test(dataProvider = "dataMaxProfitTest")
    public void maxProfit_1Test(int[] prices) {
        int max_profit = ArraysAlgorithm.maxProfit_1(prices);
        LOGGER.info("最大利润为 {}", max_profit);
    }
}
