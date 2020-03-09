package com.xingw.m96_numTrees

import com.common.TreeNode

/**
 * Create by xingw on 2020/3/2
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        print(numTrees(19))
        print(generateTrees(3))
    }

    fun numTrees(n: Int): Int {
        return helper(IntArray(n + 1), n)
    }

    fun helper(dp: IntArray, n: Int): Int {
        if (n == 0 || n == 1) return 1
        if (dp[n] != 0) {
            return dp[n]
        }
        var num = 0
        for (i in 0 until n) {
            num += helper(dp, n - i - 1) * helper(dp, i)
        }
        dp[n] = num
        return num
    }

    fun generateTrees(n: Int): List<TreeNode?> {
        if (n == 0) return mutableListOf()
        return helper2(1, n)
    }

    fun helper2(start: Int, end: Int): List<TreeNode?> {
        val list = mutableListOf<TreeNode?>()
        if (start > end) {
            list.add(null)
            return list
        }
        for (i in start..end) {
            val leftTrees = helper2(start, i - 1)
            val rightTrees = helper2(i + 1, end)

            for (leftTree in leftTrees)
                for (rightTree in rightTrees) {
                    val cur = TreeNode(i)
                    cur.left = leftTree
                    cur.right = rightTree
                    list.add(cur)
                }
        }
        return list
    }
}