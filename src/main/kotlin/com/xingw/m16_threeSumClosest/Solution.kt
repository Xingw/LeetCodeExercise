package com.xingw.m16_threeSumClosest

import kotlin.math.abs

/**
 * Create by xingw on 2020/1/13
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var hash = HashSet<Int>()
        var nearest = Int.MAX_VALUE
        var nearestNum = 0
        for (i in 0 until nums.size - 2) {
            var num = target - nums[i]
            var L = i + 1
            var R = nums.size - 1
            while (L < R) {
                if (abs(nums[L] + nums[R] - num) < nearest) {
                    nearest = abs(nums[L] + nums[R] - num)
                    nearestNum = nums[L] + nums[R] + nums[i]
                }
                if (nums[L] + nums[R] > num) {
                    R--
                } else {
                    L++
                }
            }
            hash.add(nearestNum)
        }
        return nearestNum
    }
}