package com.dynamicProgramming.m877_stoneGame

import kotlin.math.max

object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(stoneGame(intArrayOf(2,7,9,4,4)))
    }
    fun stoneGame(piles: IntArray): Int {
        val dp = Array(piles.size) { Array(piles.size) { Pair(0, 0) } }
        for (i in piles.indices) {
            dp[i][i] = Pair(piles[i], 0)
        }

        for (l in 2..piles.size)
            for (i in piles.indices) {
                val j = l + i - 1
                if (j > piles.size - 1) continue
                val left = piles[i] + dp[i + 1][j].second
                val right = piles[j] + dp[i][j - 1].second
                if (left > right) {
                    dp[i][j] = Pair(left, dp[i + 1][j].first)
                } else {
                    dp[i][j] = Pair(right, dp[i][j - 1].first)
                }
            }
        return dp[0][piles.size - 1].first
    }

    class Pair(val first:Int,val second:Int)


    fun stoneGameII(piles: IntArray): Int {
        val memo = Array(piles.size) { IntArray(piles.size) { -1 } }
        val s = IntArray(piles.size)
        s[0] = piles.sum()
        for (i in 1 until piles.size) {
            s[i] = s[i - 1] - piles[i - 1]
        }

        fun dp(i: Int, M: Int): Int {

            if (i >= piles.size) return 0
            if (M >= piles.size - i) return s[i]
            if (memo[i][M] != -1) return memo[i][M]

            var best = 0
            for (x in 1..2 * M) {
                best = max(best, s[i] - dp(i + x, max(x, M)))
            }
            memo[i][M] = best
            return best
        }

        return dp(0, 1)
    }

}
