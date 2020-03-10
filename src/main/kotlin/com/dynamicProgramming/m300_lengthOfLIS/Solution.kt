package com.dynamicProgramming.m300_lengthOfLIS

import java.util.PriorityQueue
import kotlin.math.max

/**
 * Create by xingw on 2020/3/10
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(lengthOfLIS(intArrayOf(1, 3, 6, 7, 9, 4, 10, 5, 6)))
    }

    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }

        for (i in 0 until nums.size)
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    dp[i] = max(dp[i], dp[j] + 1)
                }
            }

        var res = 0
        for (i in dp) {
            res = max(res, i)
        }
        return res
    }
}