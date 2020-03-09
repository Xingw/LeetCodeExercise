package com.tree.m145_postorderTraversal

import com.common.TreeNode
import java.util.LinkedList

/**
 * Create by xingw on 2020/3/7
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
    }

    fun postorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        if (root == null) return list
        val stack = LinkedList<TreeNode>()
        stack.addFirst(root)
        while (stack.isNotEmpty()) {
            val node = stack.pollLast()
            list.add(0, node.`val`)
            if (node.left != null) {
                stack.addFirst(node.left)
            }
            if (node.right != null) {
                stack.addFirst(node.right)
            }
        }
        return list
    }
}