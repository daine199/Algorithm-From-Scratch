package com.thunneycomb.thunneycombarchtype.algorithm;

import com.thunneycomb.thunneycombarchtype.TestNGCaseBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class ArraysAlgorithmTest extends TestNGCaseBase {

    private final static Logger LOGGER = LoggerFactory.getLogger(ArraysAlgorithmTest.class);

    int[] nums = new int[] {1, 1, 2, 2, 3};
    int[] nums2 = new int[] {1, 3, 5, 34, 23, 1, 2, 2, 3, 24, 311, 356 ,231, 567, 11, 1, 54, 2, 3, 66};

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

    @Test
    public void quickSortTest() {
        int[] arr = ArraysAlgorithm.quickSort(nums2, 0, nums2.length - 1);
        int strip_len = ArraysAlgorithm.removeDuplicates_3(arr);
        LOGGER.info("函数原始长度为{}, 新长度为{}",nums.length, strip_len);
    }

    @Test
    public void bubSort_0Test() {
        int[] arr = ArraysAlgorithm.bubSort_0(nums2);
    }

    @Test
    public void bubSort_1Test() {
        int[] arr = ArraysAlgorithm.bubSort_1(nums2);
    }
}
