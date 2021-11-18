package com.thunneycomb.thunneycombarchtype.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAlgorithm {

    public static int removeDuplicates(int[] nums) {
        /**
         * 去重数组
         */

        // 判断入参边界
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int index = 1;

        for(int right = 1 ; right < nums.length; right++) {
            if (nums[left] == nums[right]) {
                System.out.println();
                continue;
            }
            else {
                left++;
                index++;
                nums[left] = nums[right];
            }
        }
        System.out.println(String.format("Strip后长度为: %s", index));
        return index;
    }

    public static int removeDuplicates_2(int[] nums) {
        /**
         * 通过list生成新数组
         */
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++ ) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }

        List list = new ArrayList();
        for (int i = 0; i <= left; i++)
            list.add(nums[i]);

        System.out.println(String.format("Strip 后的内容 为%s", list));

        return list.size();
    }

    public static int removeDuplicates_3(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        List list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println(list);
    return 0;
    }

    public static int removeDuplicates_4(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] arr = quickSort(nums, 0, nums.length-1);
        return removeDuplicates_2(arr);
    }

    public static int[] quickSort(int[] arr, int low, int high) {
        int p, i, j, temp;

        if (low >= high) return new int[] {};

        p = arr[low];
        i = low;
        j = high;
        while (i < j) {
            while (arr[j] >= p && i < j) j--;
            while (arr[i] <= p && i < j) i++;

            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];
        arr[i] = p;

        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);

        return arr;    }
}
