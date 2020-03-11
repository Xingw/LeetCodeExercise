package com.dynamicProgramming.m32_longestValidParentheses

/**
 * Create by xingw on 2020/3/11
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(longestValidParentheses("()(()())("))
    }

    fun longestValidParentheses(s: String): Int {
        val dp = IntArray(s.length)
        for (i in 1 until s.length) {
            if (i - dp[i - 1] - 1 >= 0 && s[i] == ')' && s[i - dp[i - 1] - 1] == '(') {
                dp[i] = dp[i - 1] + 2
                if (i - dp[i - 1] - 2 >= 0) {
                    dp[i] += dp[i - dp[i - 1] - 2]
                }
            } else dp[i] = 0
        }
        return dp.max() ?: 0
    }
}