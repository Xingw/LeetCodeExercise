package com.xingw.m98_isValidBST

import com.xingw.common.TreeNode

/**
 * Create by xingw on 2020/3/3
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
    }

    fun isValidBST(root: TreeNode?): Boolean {
        return helper(root,null,null)
    }

    fun helper(node: TreeNode?, min: Int?, max: Int?): Boolean {
        if (node == null) return true
        if (min != null && node.`val` <= min) return false
        if (max != null && node.`val` > max) return false

        if (!helper(node.left, null, node.`val`)) return false
        if (!helper(node.right, node.`val`, null)) return false
        return true
    }

    fun merge(A: IntArray, m: Int, B: IntArray, n: Int): Unit {
        var p1 = m
        var p2 = n
        while(p1+p2-1 != 0){
            when{
                p2 == 0 || A[p1]>B[p2]->{
                    A[p1+p2-1] = A[p1]
                    p1--
                }
                else->{
                    A[p1+p2-1] = B[p2]
                    p2--
                }
            }
        }
    }
}