package com.thunneycomb.thunneycombarchtype.algorithm;

import com.thunneycomb.thunneycombarchtype.TestNGCaseBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.thunneycomb.thunneycombarchtype.algorithm.ArraysAlgorithm;

public class ArraysAlgorithmTest extends TestNGCaseBase {

    private final static Logger LOGGER = LoggerFactory.getLogger(ArraysAlgorithmTest.class);

    int[] nums = new int[] {1, 1, 2, 2, 3};
    int[] nums2 = new int[] {1, 3, 5, 34, 23, 1, 2, 2, 3};

    @Test
    public void removeDuplicatesTest() {

        int strip_len =  ArraysAlgorithm.removeDuplicates(nums);

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
        int strip_len = ArraysAlgorithm.removeDuplicates_4(nums2);
        LOGGER.info("函数原始长度为{}, 新长度为{}",nums2.length, strip_len);
    }

    @Test
    public void quickSortTest() {
        int[] arr = ArraysAlgorithm.quickSort(nums2, 0, nums2.length - 1);
        int strip_len = ArraysAlgorithm.removeDuplicates_3(arr);
        LOGGER.info("函数原始长度为{}, 新长度为{}",nums.length, strip_len);
    }
}
