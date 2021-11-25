package com.thunneycomb.thunneycombarchtype.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.thunneycomb.thunneycombarchtype.algorithm.SortAlgorithm.quickSort;

public class ArraysAlgorithm {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int index;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        index = left + 1;
        System.out.println(String.format("Strip后长度为: %s", index));
        return index;
    }

    public static int removeDuplicates_0(int[] nums) {
        /**
         * 去重数组
         */

        // 判断入参边界
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int index = 1;

        for (int right = 1; right < nums.length; right++) {
            if (nums[left] == nums[right]) {
                System.out.println();
                continue;
            } else {
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
        for (int right = 1; right < nums.length; right++) {
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
        /**
         * 能够完成排序后输出
         */
        if (nums == null || nums.length == 0) return 0;
        int[] arr = quickSort(nums, 0, nums.length - 1);
        return removeDuplicates_2(arr);
    }

    public static int maxProfit(int[] prices) {
        /**
         * 贪心算法
         * 1. 初始3个核心变量， 1-是否持股；2-持股价格；3-收益
         * 2. 用while 或 for 循环，用一个变量对齐下标
         * 3. 由于买股票是按照日期顺序的，所以只用遍历一遍
         * 4. 核心在于高买低卖，遍历过程只要明天比今天高，则今天买入，如果明天比今天低，则今天卖出，其他条件都忽略
         * 5. 在上面的核心逻辑下补充条件，必须不持股才能买入， 必须持股才能卖出
         * 6. 用while写法，天数在全局计算，如果持续涨，会一直不卖，最后可以直接用day坐标价格减去持股价格得到最后一次利润
         * 7. 用for写法， 最后不知道最后一天是哪一天，但可以用数组长度替换。
         */
        int max_profit = 0;
        if (prices == null || prices.length < 2) return max_profit;
        boolean is_buy = false;
        int in_hand = 0;
        int day = 0;
//        int[] nums = new int[] {1, 1, 2, 2, 3};

        while(day < prices.length - 1) {
            if (prices[day] < prices[day + 1]) {
                if (!is_buy) {
                    is_buy = true;
                    in_hand = prices[day];
                }
            }
            else {
                if (is_buy) {
                    is_buy = false;
                    max_profit += prices[day] - in_hand;
                }
            }
            day++;
        }
        if (is_buy) max_profit += prices[day] - in_hand;
        return max_profit;
    }

    public static int maxProfit_1(int[] prices) {
        /**
         * 1. 设定基础参数 是否买入 in_hand, 利润 max_profit, 买入的价格 price
         * 2. 日期和价格已确认，所以遍历一次
         * 3. 当明天比今天贵，且手上没有股票，就买入, 如果手上有股票，就啥事不做
         * 4. 当明天比今天便宜， 且手上有股票，就卖出，如果手上没股票，就啥事也不做
         * 5. 如果股票一直涨，遍历结束后肯定遇不到4的情况，手上还有股票，此时可以直接卖掉
         */

        // 1.
        boolean in_hand = false;
        int max_profit = 0;
        int in_hand_price = 0;
        // 2.
        for (int day = 0; day < prices.length - 1; day++) {
            // 3.
            if (prices[day] < prices[day + 1] && in_hand == false) {
                in_hand = true;
                in_hand_price = prices[day];
            }
            // 4.
            if (prices[day] > prices[day + 1] && in_hand == true) {
                in_hand = false;
                max_profit += prices[day] - in_hand_price;
            }
        }
        // 5.
        if (in_hand) {
            max_profit += prices[prices.length - 1] - in_hand_price;
        }

        return max_profit;
    }
}
