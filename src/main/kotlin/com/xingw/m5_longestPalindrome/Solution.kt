package com.xingw.m5_longestPalindrome

import kotlin.math.max
import kotlin.math.min

/**
 * Create by xingw on 2019/12/24
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        System.out.println(longestPalindrome("aaaaaaaa"))
    }

    fun createData(origin: String): String {
        val stringBuffer = StringBuffer()
        stringBuffer.append("$")
        for (c in origin) {
            stringBuffer.append("#")
            stringBuffer.append(c)
        }
        stringBuffer.append("#")
        return stringBuffer.toString()
    }

    fun longestPalindrome(s: String): String {
        val data = createData(s)
        val len = data.length
        var mx = 0
        var id = 0
        var p = IntArray(len)
        var maxlength = 0
        var result = ""

        for (i in 1 until len) {
            if (i < mx) {
                p[i] = min(p[2 * id - i], mx - i)
            } else {
                p[i] = 1
            }

            while (i + p[i] != len && data[i - p[i]] == data[i + p[i]]) {
                p[i]++
            }

            if (mx < i + p[i]) {
                id = i
                mx = i + p[i]
            }

            if (p[i] - 1 > maxlength) {
                maxlength = p[i] - 1
                result = data.substring(i - maxlength, i + maxlength).replace("#".toRegex(), "")
            }
        }
        return result
    }
}