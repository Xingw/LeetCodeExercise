package com.common

import java.util.concurrent.LinkedBlockingQueue

/**
 * Create by xingw on 2019/12/18
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
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

fun printListNode(node: ListNode?) {
    var node = node
    while (node != null) {
        print(node.`val`)
        print("->")
        node = node.next
    }
}

class TreeNode internal constructor(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun createTreeNode(vararg elements: Int?): TreeNode {
    val queue = LinkedBlockingQueue<TreeNode>()
    val node = TreeNode(elements[0]!!)
    queue.put(node)
    for (i in 1 until elements.size step 2) {
        val root = queue.poll()
        root.left = if (elements[i] == null) {
            null
        } else {
            TreeNode(elements[i]!!).also { queue.put(it) }
        }
        if (i + 1 == elements.size) {
            root.right = null
        } else {
            root.right = if (elements[i + 1] == null) null else TreeNode(elements[i + 1]!!).also { queue.put(it) }
        }
    }
    return node
}

fun printTreeNode(treeNode: TreeNode?) {
    if (treeNode == null) return println("null")
    val result = mutableListOf<Int?>()
    val queue = LinkedBlockingQueue<TreeNode>()
    queue.put(treeNode)
    var nodeLeft = 1
    while (queue.isNotEmpty()) {
        if (nodeLeft < 1) break

        val root = queue.poll()
        if (root.`val` != -1) {
            result.add(root.`val`)
        } else {
            result.add(null)
        }
        if (root.`val` != -1) nodeLeft--

        if (root?.left != null) nodeLeft++
        if (root?.right != null) nodeLeft++
        queue.put(root?.left ?: TreeNode(-1))
        queue.put(root?.right ?: TreeNode(-1))
    }
    print(result)
}