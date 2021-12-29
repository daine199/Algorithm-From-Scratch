package com.thunneycomb.thunneycombarchtype.algorithm;

import java.util.ArrayList;
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

    public static int searchInsert(int[] nums, int target) {
        /**
         * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
         * 动态规划
         * 1. 遍历数组， int i < target.length
         * 2. 和target 比， 如果大于等于target ， 得到index = i，
         */
        int index = 0;
        if (nums == null || nums.length == 0) return index;
        if (nums[nums.length - 1] < target) return nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int searchInsert_1(int[] nums, int target) {
        /**
         * 1. 遍历数组
         * 2. 如果遇到相等的， 插入位置等于其索引位置+1
         * 3. 如果比完都没有遇到相等的， 插入位置等于输入长度
         */
        int index = 0;
        while (index < nums.length) {
            if (nums[index] >= target) {
                return index;
            } else {
                index++;
            }
        }
        return index;
        /**
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 38.2 MB
         * , 在所有 Java 提交中击败了
         * 18.79%
         * 的用户
         * 通过测试用例：
         * 64 / 64
         */
    }

    public static int searchInsert_2(int[] nums, int start, int endd, int target) {
        /**
         * 1. 遍历数组
         * 2. 如果遇到相等的， 插入位置等于其索引位置+1
         * 3. 如果比完都没有遇到相等的， 插入位置等于输入长度
         * ----
         * TODO 优化项 ， 一个有序数组如果数组特别长，从头比会非常慢，需要有策略的完成切分
         * 1. 默认index为0 ， 当nums.length > 某值 时，做切分策略
         */
        int index = 0;
        int end = nums.length - 1;
        int split = 10;
        if (start > 0 ) index = start;
        if (endd != 0) end = endd;

        if (end - index > split) { // 这个值可以改，改到3就直接变成了二分法
            if (nums[(end - index)/2 + index] > target) {
                end = (end - index)/2 + index;
                return searchInsert_2(nums, start, end, target);
            }
            if (nums[(end - index)/2 + index] == target) {
                index = (end - index)/2 + index;
                return index;
            }
            if (nums[(end - index)/2 + index] < target) {
                start = (end - index)/2 + index;
                return searchInsert_2(nums, start, end, target);
            }
        } else {
            while (index < end) {
                if (nums[index] >= target) return index;
                else index++;
            }
            return index;
        }
        return index;
        /**
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 38.2 MB
         * , 在所有 Java 提交中击败了
         * 15.58%
         * 的用户
         * 通过测试用例：
         * 64 / 64
         */
    }

    public static ArrayList aplusb_Target(int[] nums, int target) {
        /**
         * 查找数组中两个数相加等于入参目标数
         */
        ArrayList abl = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            for (int ii = 1; ii < nums.length; ii++) {
                if ((nums[i] + nums[ii]) == target) {
                    abl.add(new int[] {i, ii});
                }
            }
        }
        // TODO 优化 如果abl 中的 i == ii' , ii == i' 时， 干掉后面这个链
        return abl;
    }

    public ArrayList stripList ( ArrayList num_list) {
        ArrayList remove_list = new ArrayList();
        int base = 0;
        while (base < num_list.size() - 1) {
            int[] numa = (int[])num_list.get(base);
            while (base)
        }
        for (int i = 0; i < num_list.size(); i++) {

            for (int ii = 1; ii < num_list.size(); ii++) {
                int[] numb = (int[])num_list.get(ii);
                if (numa[0] == numb[1] && numa[1] == numb[0])
            }
        }
    }

}
