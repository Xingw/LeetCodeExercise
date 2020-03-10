package com.dynamicProgramming.mm1708_bestSeqAtIndex

import java.util.PriorityQueue
import kotlin.math.max

/**
 * Create by xingw on 2020/3/10
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(bestSeqAtIndex(intArrayOf(65, 70, 56, 75, 60, 68), intArrayOf(100, 150, 90, 190, 95, 110)))
    }

    fun bestSeqAtIndex(height: IntArray, weight: IntArray): Int {
        val list = mutableListOf<Person>()
        for (i in height.indices) {
            list.add(Person(height[i], weight[i]))
        }
        list.sortWith(compareBy({ it.height }, { -it.weight }))

        val dp = IntArray(weight.size) { 1 }
        for (i in weight.indices) {
            for (j in 0 until i) {
                if (list[i].weight > list[j].weight) {
                    dp[i] = max(dp[i], dp[j] + 1)
                }
            }
        }
        return dp.max()?:0
    }

    class Person(val height: Int, val weight: Int)
}