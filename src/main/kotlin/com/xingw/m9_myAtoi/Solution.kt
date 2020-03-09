package com.xingw.m9_myAtoi

import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

/**
 * Create by xingw on 2020/1/7
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(myAtoi("4193 with words"))
    }

    fun myAtoi(str: String): Int {
        return max(
            min(
                (Regex("^[+-]?\\d+").find(str.trimStart())?.value ?: return 0).toDouble(),
                Int.MAX_VALUE.toDouble()
            ),
            Int.MIN_VALUE.toDouble()
        ).toInt()
    }
}