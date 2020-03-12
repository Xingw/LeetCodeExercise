package com.dynamicProgramming.m714_maxProfit

import kotlin.math.max

object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(maxProfit(intArrayOf(1,3,2,8,4,9),2))
    }

    fun maxProfit(prices: IntArray, fee: Int): Int {
        var dp_i_0 = 0
        var dp_i_1 = Int.MIN_VALUE
        for (i in prices.indices) {
            val temp = dp_i_0
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            dp_i_1 = max(dp_i_1, temp - prices[i]-fee)
        }
        return dp_i_0
    }
}