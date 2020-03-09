package com.xingw.m2_addTwoNumbers

import com.xingw.common.ListNode
import com.xingw.common.createNode

/**
 * Create by xingw on 2019/12/18
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        val node1 = createNode(2, 4, 3, 5)
        val node2 = createNode(5, 6, 4)
        var result = addTwoNumbers(node1, node2)
        while (result != null) {
            print("${result.`val`}->")
            result = result.next
        }
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var head = ListNode(0)
        var point = head
        var p1 = l1
        var p2 = l2
        var carry = 0
        while (p1 != null || p2 != null) {
            val num1 = p1?.`val` ?: 0
            val num2 = p2?.`val` ?: 0
            val result = num1 + num2 + carry
            carry = result / 10
            point.next = ListNode(result % 10)
            point = point.next!!
            p1 = p1?.next
            p2 = p2?.next
        }
        if (carry == 1) {
            point.next = ListNode(1)
        }
        return head.next
    }
}