package com.dynamicProgramming.m72_minDistance

/**
 * Create by xingw on 2020/3/9
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(minDistance("apple", "bap"))
        println(minDistance2("apple", "bap"))
    }

    //递归算法
    fun minDistance(word1: String, word2: String): Int {
        val memo = Array(word1.length) { IntArray(word2.length) { -1 } }
        fun dp(i: Int, j: Int): Int {
            //回溯条件 当有一个字符串遍历完成后，剩下的步数为另一个字符串的长度
            if (i == -1) return j + 1
            if (j == -1) return i + 1
            //剪枝
            if (memo[i][j] != -1) return memo[i][j]

            //字符相同，不用处理
            if (word1[i] == word2[j]) {
                memo[i][j] = dp(i - 1, j - 1)
            } else {
                memo[i][j] = minOf(
                    dp(i - 1, j) + 1,  //删除
                    dp(i, j - 1) + 1,  //插入
                    dp(i - 1, j - 1) + 1 //替换
                )
            }
            return memo[i][j]
        }

        return dp(word1.length - 1, word2.length - 1)
    }

    //遍历算法
    fun minDistance2(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
        for (i in 0..word1.length) dp[i][0] = i
        for (j in 0..word2.length) dp[0][j] = j
        for (i in 1..word1.length)
            for (j in 1..word2.length) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = minOf(
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1,
                        dp[i - 1][j - 1] + 1
                    )
                }
            }
        return dp[word1.length][word2.length]
    }
}