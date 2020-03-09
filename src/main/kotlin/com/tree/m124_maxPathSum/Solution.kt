package com.tree.m124_maxPathSum

import com.xingw.common.TreeNode
import com.xingw.common.createTreeNode
import kotlin.math.max

/**
 * Create by xingw on 2020/3/7

 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(maxPathSum(createTreeNode(2, -1, -2)))
    }

    var maxNum = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        maxPathSum2(root)
        return maxNum
    }

    fun maxPathSum2(root: TreeNode?): Int {
        if (root == null) return 0
        var value = root.`val`
        val left = maxPathSum2(root.left)
        val right = maxPathSum2(root.right)
        val maxNode = max(max(left + value, right + value), value)
        maxNum = max(max(maxNode, left + right + value), maxNum)
        return maxNode
    }
}