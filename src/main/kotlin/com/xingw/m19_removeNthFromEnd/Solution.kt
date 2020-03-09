package com.xingw.m19_removeNthFromEnd

import com.common.ListNode
import com.common.createNode

/**
 * Create by xingw on 2020/2/24
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        removeNthFromEnd(createNode(1, 2), 1).run {
            var move = this
            while (move != null) {
                print(move.`val`)
                print("->")
                move = move.next
            }
        }
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null
        var move = head
        var record = move
        var le = 0
        while (move!!.next != null) {
            move = move.next
            if (le < n) {
                le++
            } else {
                record = record!!.next
            }
        }
        return if (le == n - 1 && record == head) {
            record.next
        } else {
            record!!.next = record!!.next?.next
            head
        }
    }
}