package com.xingw.m1_twoSum

import com.xingw.Main2

/**
 * Create by xingw on 2019/12/17
 */
class twoSum {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = twoSum2(intArrayOf(3,2,4), 6)
            for (i in result) {
                println("${i} ")
            }
        }

        fun twoSum(nums: IntArray, target: Int): IntArray {
            var p1 = 0
            var p2 = nums.size - 1
            while (p1 != p2) {
                if (target - nums[p1] == nums[p2]) return intArrayOf(nums[p1], nums[p2])
                if (target - nums[p1] > nums[p2]) {
                    p1++
                } else {
                    p2--
                }
            }
            return intArrayOf(nums[p1], nums[p2])
        }

        //无序数组
        fun twoSum2(nums: IntArray, target: Int): IntArray {
            val hash = HashMap<Int, Int>(nums.size)
            for (i in nums.indices) {
                val a = target - nums[i]
                if (hash.containsKey(a)) return intArrayOf(hash[a]!!,i)
                hash[nums[i]] = i
            }
            return intArrayOf(0, 0)
        }
    }
}