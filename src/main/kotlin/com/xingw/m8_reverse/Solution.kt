package com.xingw.m8_reverse

import kotlin.math.pow

/**
 * Create by xingw on 2020/1/7
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(reverse(-123))
    }

    fun reverse(x: Int): Int {
        val x1 = x > 0
        var num = x
        var result = mutableListOf<Int>()
        while (num != 0) {
            result.add(0, num % 10)
            num /= 10
        }
        var a = 0
        for (i in 0 until result.size) {
            a += (result[i] * 10.0.pow(i.toDouble())).toInt()
        }
        return if ((x > 0 && a > 0) || (x < 0 && a < 0)) {
            a
        } else{
            0
        }
    }
}