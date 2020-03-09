package com.xingw

import java.util.PriorityQueue

/**
 * Create by xingw on 2019/12/17
 */
class Main2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val node1 = createNode(1)
            val node2 = createNode(0)

            val list = mutableListOf(node1, node2)
            var result = mergeKLists(list)
            while (result != null) {
                print("${result.`val`}->")
                result = result.next
            }
        }

        fun createNode(vararg elements: Int): ListNode? {
            val rootNode = ListNode(0)
            var nodeCreater: ListNode? = null
            for (i in elements.indices) {
                if (i == 0) {
                    rootNode.next = ListNode(elements[i])
                    nodeCreater = rootNode.next
                } else {
                    nodeCreater?.next = ListNode(elements[i])
                    nodeCreater = nodeCreater?.next
                }
            }
            return rootNode.next
        }

        fun mergeKLists(lists: MutableList<ListNode?>): ListNode? {
            val firstNodeList = lists.filterNotNull()
            val q = PriorityQueue<ListNode>(NodeComparator())
            q.addAll(firstNodeList)
            val resultNode = ListNode(0)
            var arrowNode = resultNode
            while (q.isNotEmpty()) {
                var node = q.poll()
                arrowNode.next = node
                arrowNode = arrowNode.next!!
                node = node.next
                if (node != null) {
                    q.add(node)
                }
            }
            return resultNode.next
        }

        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            var ll1 = l1
            var ll2 = l2
            val head = ListNode(0)
            var point = head
            while (ll1 != null && ll2 != null) {
                if (ll2.`val` > ll1.`val`) {
                    point.next = ll1
                    point = ll1
                    ll1 = ll1.next
                } else {
                    point.next = ll2
                    point = ll2
                    ll2 = ll2.next
                }
            }
            if (ll1 == null) {
                point.next = ll2
            } else {
                point.next = ll1
            }
            return head.next
        }
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    class NodeComparator : Comparator<ListNode> {
        override fun compare(o1: ListNode, o2: ListNode): Int {
            if (o1.`val` > o2.`val`) return 1
            return -1
        }
    }
}