package com.xingw.m28_strStr

/**
 * Create by xingw on 2020/2/25
 */
class KMP(val pat: String) {
    private var dp: Array<IntArray> = Array(pat.length) { IntArray(256) }

    init {
        dp[0][pat[0].toInt()] = 1
        var X = 0
        for (i in 1 until pat.length) {
            for (j in 0 until 256) {
                if (pat[i].toInt() == j) {
                    dp[i][j] = i + 1
                } else {
                    dp[i][j] = dp[X][j]
                }
            }
            X = dp[X][pat[i].toInt()]
        }
    }

    fun search(txt: String): Int {
        val M = pat.length
        val N = txt.length
        var j = 0
        for (i in 0 until N) {
            j = dp[j][txt[i].toInt()]
            if (j == M) return i - M + 1
        }
        return -1
    }
}