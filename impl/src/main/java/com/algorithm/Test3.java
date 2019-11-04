package com.algorithm;

/**
 * @author yufeng li
 * @title: Test3
 * @description:
 * @date 2019/8/19 11:34
 */
public class Test3 {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,3,4,5};
        int[] num2 = new int[]{};
        Test3 test3 = new Test3();
        double medianSortedArrays = test3.findMedianSortedArrays(num1, num2);
        System.err.println(medianSortedArrays);

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //每个数组分两块 小数块的长度之和等于大数块的长度之和或之和加1，所以nums1的分法固定之后  nums2的分法也就固定了
        //int i=0;//i<nums1.length;
        if (nums1.length > nums2.length) {
            int[] a = nums1;
            nums1 = nums2;
            nums2 = a;
        }
        int m = nums1.length;
        int[] a = new int[m + 2];
        a[0] = Integer.MIN_VALUE;
        a[m + 1] = Integer.MAX_VALUE;
        for (int i = 1; i < m + 1; i++) {
            a[i] = nums1[i - 1];
        }
        int n = nums2.length;
        int[] b = new int[n + 2];
        b[0] = Integer.MIN_VALUE;
        b[n + 1] = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            b[i] = nums2[i - 1];
        }

        for (int i = 0; i < a.length; i++) {
            if ((a.length + b.length) % 2 == 1) {
                int j = (a.length + b.length - 1) / 2 - i;
                if (j >= b.length) {
                    continue;
                }
                if ((i < 1 || a[i - 1] <= b[j]) && (j < 1 || b[j - 1] <= a[i])) {
                    if (j >= b.length) {
                        return a[i];
                    } else {
                        return b[j] < a[i] ? b[j] : a[i];
                    }
                }
            } else {
                int j = (a.length + b.length) / 2 - i;
                if ((j >= b.length || i < 1 || a[i - 1] <= b[j]) && (j < 1 || b[j - 1] <= a[i])) {
                    if (j >= b.length) {
                        return (a[i - 1] + a[i]) / 2.0;
                    } else {
                        int x = b[j - 1] > a[i - 1] ? b[j - 1] : a[i - 1];
                        int y = b[j] < a[i] ? b[j] : a[i];
                        return (x + y) / 2.0;
                    }
                }
            }
        }
        return 0.00;

    }


    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
