package com.xingw.m28_strStr

/**
 * Create by xingw on 2020/2/25
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        print(strStr("aabaac", "aac"))
    }

    fun strStr(haystack: String, needle: String): Int {
        val kmp = KMP(needle)
        return kmp.search(haystack)
    }
}