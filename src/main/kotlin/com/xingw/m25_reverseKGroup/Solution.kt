package com.xingw.m25_reverseKGroup

import com.xingw.common.ListNode
import com.xingw.common.createNode
import com.xingw.common.printListNode

/**
 * Create by xingw on 2020/2/25
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        printListNode(reverseKGroup(createNode(1, 2, 3, 4), 3))
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (k < 1) return head
        var n = k - 1
        val firstNode = head
        var endNode = head
        while (n != 0) {
            endNode = endNode?.next
            n--
        }
        if (firstNode == null || endNode == null) return head
        val nextNode = endNode.next
        reverse(firstNode, endNode)
        firstNode.next = reverseKGroup(nextNode, k)
        return endNode
    }

    fun reverse(headNode: ListNode, endNode: ListNode): ListNode? {
        var firstNode = headNode
        var secondNode = headNode.next
        var nextNode = headNode.next?.next
        while (firstNode != endNode && secondNode != null) {
            nextNode = secondNode.next
            secondNode.next = firstNode
            firstNode = secondNode
            secondNode = nextNode
        }
        return endNode
    }
}