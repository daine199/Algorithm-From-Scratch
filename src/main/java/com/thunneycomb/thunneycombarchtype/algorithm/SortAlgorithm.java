package com.thunneycomb.thunneycombarchtype.algorithm;

public class SortAlgorithm {
    public static int[] quickSort(int[] arr, int low, int high) {
        /**
         * 快速排序
         */
        int p, i, j, temp;

        if (low >= high) return new int[]{};

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

        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);

        return arr;
    }

    public static int[] bubSort_0(int[] arr) {
        /**
         * 原始冒泡
         */
        long start_time = System.nanoTime();
        long start_time_ms = System.currentTimeMillis();
        int[] arr_done = new int[]{};
        int swap = 0;
        for(int n = 0; n < arr.length; n++) {
            for (int i = 0; i < arr.length -1; i++)
                if (arr[i] > arr[i+1]) {
                    swap = arr[i]; arr[i] = arr[i+1]; arr[i+1] = swap;
                }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        long end_time = System.nanoTime();
        long end_time_ms = System.currentTimeMillis();
        System.out.println(String.format("bugSort_0运行时长%s ns (%s ms)",(end_time - start_time), (end_time_ms - start_time_ms)));
        return arr_done;
    }

    public static int[] bubSort_1(int[] arr) {
        /**
         * 优化1 如果出现已排好的情况，则直接跳过计算
         */
        long start_time = System.nanoTime();
        long start_time_ms = System.currentTimeMillis();
        int[] arr_done = new int[]{};

        int swap = 0;
        boolean flag = true; // 默认是需要交换来完成排序
        for (int n = 0; n < arr.length; n++) {
            if (flag) { // 判断需要交换标志位， 一旦内部排序逻辑发现此次已经完全不需要交换时，提前结束排序
                flag = false; // 设定下次不需要执行
                for (int i = 0; i < arr.length - 1; i++) {
                    if (arr[i] > arr[i + 1]) {
                        flag = true; // 循环中一旦发生过交换，则设置下次需要继续交换
                        swap = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = swap;
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        long end_time = System.nanoTime();
        long end_time_ms = System.currentTimeMillis();
        long time = end_time - start_time;
        long time_ms = end_time_ms - start_time_ms;
        System.out.println(String.format("bugSort_1运行时长%s ns (%s ms)", time, time_ms));
        return arr_done;
    }

}
