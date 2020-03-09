package com.xingw.m11_maxArea

import kotlin.math.max
import kotlin.math.min

/**
 * Create by xingw on 2020/1/9
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    }

    fun maxArea(height: IntArray): Int {
        var m = 0
        var n = height.lastIndex
        var max = 0
        while (m < n) {
            max = max(min(height[m], height[n]) * (n - m), max)
            if (height[m] < height[n]) {
                m++
            } else{
                n--
            }
        }
        return max
    }
}