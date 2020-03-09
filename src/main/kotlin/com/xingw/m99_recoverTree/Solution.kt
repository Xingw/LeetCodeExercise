package com.xingw.m99_recoverTree

import com.xingw.common.TreeNode
import com.xingw.common.createTreeNode
import com.xingw.common.printTreeNode

/**
 * Create by xingw on 2020/3/4
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        recoverTree(createTreeNode(1, 3, null, null, 2))
    }

    var prev: TreeNode? = null
    var t: TreeNode? = null
    var s: TreeNode? = null

    fun recoverTree(root: TreeNode?): Unit {
        recoverTree2(root)
        if (s != null && t != null) {
            val tmp = s!!.`val`
            s!!.`val` = t!!.`val`
            t!!.`val` = tmp
        }
    }

    fun recoverTree2(root: TreeNode?): Unit {
        if (root == null) return
        recoverTree2(root.left)
        prev?.let {
            if (root.`val` < it.`val`) {
                if (s == null) {
                    s = prev
                }
                t = root
            }
        }
        prev = root
        recoverTree2(root.right)
    }
}