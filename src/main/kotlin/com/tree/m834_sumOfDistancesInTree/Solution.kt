package com.tree.m834_sumOfDistancesInTree

import com.sun.deploy.util.ArrayUtil
import java.util.Arrays

/**
 * Create by xingw on 2020/3/5
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        print(
            sumOfDistancesInTree(
                2, arrayOf(
                    intArrayOf(1, 0)
                )
            )
        )
        print("")
    }

    lateinit var ans: IntArray
    lateinit var count: IntArray
    lateinit var graph: MutableList<HashSet<Int>>

    fun sumOfDistancesInTree(N: Int, edges: Array<IntArray>): IntArray {
        ans = IntArray(N)
        count = IntArray(N).also {
            it.fill(1, 0, N)
        }
        graph = ArrayList()
        for (i in 0 until N)
            graph.add(HashSet<Int>())
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
        }

        dfs(0, -1)
        dfs2(0, N)
        return ans
    }

    private fun dfs2(node: Int, n: Int) {
        for (child in graph[node]) {
            ans[child] = ans[node] - count[child] + n - count[child]
            dfs2(child,n)
        }
    }

    private fun dfs(node: Int, parent: Int) {
        for (child in graph[node]) {
            dfs(child, node)
            count[node] += count[child]
            ans[node] += ans[child] + count[child]
        }
    }
}