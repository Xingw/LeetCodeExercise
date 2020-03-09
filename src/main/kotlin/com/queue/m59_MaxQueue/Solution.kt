package com.queue.m59_MaxQueue

import java.util.LinkedList
import java.util.Stack
import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.LinkedBlockingQueue

/**
 * Create by xingw on 2020/3/7
 */
class MaxQueue() {
    val queue = LinkedBlockingQueue<Int>()
    val deque = LinkedBlockingDeque<Int>()

    fun max_value(): Int {
        return if (deque.isEmpty()) -1 else deque.first
    }

    fun push_back(value: Int) {
        while (deque.isNotEmpty() && value > deque.last)
            deque.pollLast()
        deque.put(value)
        queue.put(value)
    }

    fun pop_front(): Int {
        if (queue.isEmpty()) return -1
        val value = queue.poll()
        if (value == deque.first) {
            deque.pop()
        }
        return value
    }
}

object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        val maxQueue = MaxQueue()
        maxQueue.push_back(1)
        maxQueue.push_back(3)
        maxQueue.push_back(2)
        maxQueue.push_back(345)
        maxQueue.push_back(210)
        maxQueue.push_back(245)
        maxQueue.push_back(4)
        println("${maxQueue.pop_front()}    ${maxQueue.max_value()}")
        println("${maxQueue.pop_front()}    ${maxQueue.max_value()}")
        println("${maxQueue.pop_front()}    ${maxQueue.max_value()}")
        println("${maxQueue.pop_front()}    ${maxQueue.max_value()}")
        println("${maxQueue.pop_front()}    ${maxQueue.max_value()}")
        println("${maxQueue.pop_front()}    ${maxQueue.max_value()}")
        println("${maxQueue.pop_front()}    ${maxQueue.max_value()}")
    }
}