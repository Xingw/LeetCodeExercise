package com.xingw.m15_threeSum

import com.google.gson.Gson

/**
 * Create by xingw on 2020/1/11
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(threeSum(intArrayOf(-2, 0, 0, 2, 2)))
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (nums.size < 3) return result
        nums.sort()
        for (i in 0 until nums.size - 2) {
            if (i != 0 && nums[i] == nums[i - 1]) continue
            var L = i + 1
            var M = i
            var R = nums.size - 1
            loop@ while (L < R) {
                if (L != i + 1 && nums[L] == nums[L - 1]) {
                    L++
                    continue
                }
                if (R != nums.size - 1 && nums[R] == nums[R + 1]) {
                    R--
                    continue
                }
                when {
                    nums[L] + nums[M] + nums[R] > 0 -> R--
                    nums[L] + nums[M] + nums[R] == 0 -> {
                        // result.add(mutableListOf(nums[L], nums[M], nums[R]))
                        result.add(mutableListOf(M, L, R))
                        L++
                        R--
                    }
                    nums[L] + nums[M] + nums[R] < 0 -> L++
                }
            }
        }
        return result
    }
}