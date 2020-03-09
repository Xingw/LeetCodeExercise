package com.xingw.m994_orangesRotting

import java.util.concurrent.LinkedBlockingQueue

/**
 * Create by xingw on 2020/3/4
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(orangesRotting(arrayOf(intArrayOf(1, 2))))
    }

    fun orangesRotting(grid: Array<IntArray>): Int {
        var res = 0
        var p1 = 0
        var p2 = 0
        val queue = LinkedBlockingQueue<Counter>()
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 2) {
                    queue.put(Counter(i, j))
                    p1++
                }
            }
        }
        while (queue.isNotEmpty()) {
            val counter = queue.poll()
            p1--
            val x = counter.x
            val y = counter.y
            if (y + 1 < grid[x].size) {
                if (grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2
                    queue.put(Counter(x, y + 1))
                    p2++
                }
            }
            if (x - 1 >= 0) {
                if (grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2
                    queue.put(Counter(x - 1, y))
                    p2++
                }
            }
            if (x + 1 < grid.size) {
                if (grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2
                    queue.put(Counter(x + 1, y))
                    p2++
                }
            }
            if (y - 1 >= 0) {
                if (grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2
                    queue.put(Counter(x, y - 1))
                    p2++
                }
            }
            if (p1 == 0 && p2 != 0) {
                res++
                p1 = p2
                p2 = 0
            }
        }
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    return -1
                }
            }
        }
        return res
    }

    class Counter(
        val x: Int,
        val y: Int
    )
}