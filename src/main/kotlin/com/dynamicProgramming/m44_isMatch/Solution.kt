package com.dynamicProgramming.m44_isMatch

/**
 * Create by xingw on 2020/3/11
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"))
        println(isMatch("acdcb", "a*c?b"))
    }

    //递归方法 时间过长
    // fun isMatch(s: String, p: String): Boolean {
    //     if (p.isEmpty()) return s.isEmpty()
    //
    //     val firstMatch = s.isNotEmpty() && (s[0] == p[0] || p[0] == '?')
    //
    //     if (p[0] == '*') {
    //         return isMatch(s, p.substring(1)) ||
    //             (s.isNotEmpty() && (isMatch(s.substring(1), p) ||
    //                 isMatch(s.substring(1), p.substring(1))))
    //     }
    //     return firstMatch && isMatch(s.substring(1), p.substring(1))
    // }

    fun isMatch(s: String, p: String): Boolean {
        val memo = Array(s.length+1) { IntArray(p.length+1){-1} }

        fun dp(i: Int, j: Int): Boolean {
            if (j == p.length) return i == s.length
            if (memo[i][j] != -1) return memo[i][j] == 1

            val firstMatch = i != s.length && (s[i] == p[j] || p[j] == '?')
            val res = if (p[j] == '*') {
                 (dp(i, j + 1) ||
                    (i != s.length && (dp(i + 1, j) ||
                        dp(i + 1, j + 1))))
            } else{
                firstMatch && dp(i + 1, j + 1)
            }
            if (res) memo[i][j] = 1 else memo[i][j] = 0
            return res
        }
        return dp(0, 0)
    }
}