package com.xingw.m4_findMedianSortedArrays

import kotlin.math.min

/**
 * Create by xingw on 2019/12/19
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        System.out.println(findMedianSortedArrays2(intArrayOf(1), intArrayOf(3, 4)))
    }

    //排序后找中位数
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var a = 0
        var b = 0
        var c = 0
        var nums3 = IntArray(nums1.size + nums2.size)
        while (a < nums1.size && b < nums2.size) {
            if (nums1[a] < nums2[b]) {
                nums3[c] = nums1[a++]
            } else {
                nums3[c] = nums2[b++]
            }
            c++
        }
        while (b < nums2.size) {
            nums3[c++] = nums2[b++]
        }
        while (a < nums1.size) {
            nums3[c++] = nums1[a++]
        }
        //奇数
        return if (nums3.size % 2 == 1) {
            nums3[nums3.size / 2].toDouble()
        } else {
            ((nums3[nums3.size / 2] + nums3[nums3.size / 2 - 1]) / 2f).toDouble()
        }
    }

    fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
        val n = nums1.size
        val m = nums2.size
        var h = (n + m + 1) / 2
        var h2 = (n + m + 2) / 2
        return (findMinNumIndex(nums1, 0, n - 1, nums2, 0, m - 1, h)
            + findMinNumIndex(nums1, 0, n - 1, nums2, 0, m - 1, h2)) * 0.5
    }

    fun findMinNumIndex(
        nums1: IntArray,
        start1: Int,
        end1: Int,
        nums2: IntArray,
        start2: Int,
        end2: Int,
        k: Int
    ): Double {
        val n = end1 - start1 + 1
        val m = end2 - start2 + 1
        if (m < n) return findMinNumIndex(nums2, start2, end2, nums1, start1, end1, k)
        if (n == 0) return nums2[start2 + k - 1].toDouble()
        if (k == 1) return min(nums1[start1], nums2[start2]).toDouble()

        var h = k / 2
        val a = start1 + min(h, n) - 1
        val b = start2 + min(h, m) - 1
        return if (nums1[a] < nums2[b]) {
            findMinNumIndex(nums1, a + 1, end1, nums2, start2, end2, k - min(h, n))
        } else {
            findMinNumIndex(nums1, start1, end1, nums2, b + 1, end2, k - min(h, m))
        }
    }
}