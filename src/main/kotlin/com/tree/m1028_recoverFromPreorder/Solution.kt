package com.tree.m1028_recoverFromPreorder

import com.common.TreeNode

/**
 * Create by xingw on 2020/3/5
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        val node = recoverFromPreorder("1-401--349---90--88")
        println()
    }

    var p = 0
    lateinit var array: Array<Num>

    private fun recoverFromPreorder(S: String?): TreeNode? {
        if (S.isNullOrEmpty()) return null
        val regex = Regex("[0-9]+")
        var matchs = regex.findAll(S)
        array = Array(matchs.count()) {
            Num(0, 0)
        }
        for (i in 0 until matchs.count()) {
            val match = matchs.elementAt(i)
            if (i == 0) array[i] = Num(match.value.toInt(), 0)
            else array[i] = Num(match.value.toInt(), match.range.first - matchs.elementAt(i - 1).range.last - 1)
        }

        return recoverFromPreorder(0)
    }

    private fun recoverFromPreorder(depth: Int): TreeNode? {
        if (p >= array.size) return null
        if (array[p].depth == depth) {
            val node = TreeNode(array[p].value)
            p++
            node.left = recoverFromPreorder(depth + 1)
            node.right = recoverFromPreorder(depth + 1)
            return node
        } else return null
    }

    class Num(
        val value:Int,
        val depth:Int
    )
}