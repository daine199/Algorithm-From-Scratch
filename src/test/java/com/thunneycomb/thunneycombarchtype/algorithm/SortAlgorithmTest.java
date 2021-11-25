package com.thunneycomb.thunneycombarchtype.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.thunneycomb.thunneycombarchtype.algorithm.SortAlgorithm.*;

public class SortAlgorithmTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(SortAlgorithmTest.class);

    int[] nums = new int[] {1, 1, 2, 2, 3};
    int[] nums2 = new int[] {1, 3, 5, 34, 23, 1, 2, 2, 3, 24, 311, 356 ,231, 567, 11, 1, 54, 2, 3, 66};


    @Test
    public void quickSortTest() {
        int[] arr = quickSort(nums2, 0, nums2.length - 1);
        int strip_len = ArraysAlgorithm.removeDuplicates_3(arr);
        LOGGER.info("函数原始长度为{}, 新长度为{}",nums.length, strip_len);
    }

    @Test
    public void bubSort_0Test() {
        int[] arr = bubSort_0(nums2);
    }

    @Test
    public void bubSort_1Test() {
        int[] arr = bubSort_1(nums2);
    }
}
