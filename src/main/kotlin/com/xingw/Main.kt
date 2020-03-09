import sun.rmi.runtime.Log
import java.util.PriorityQueue

private fun main(args: Array<String>) {
    val node1 = createNode(1, 4, 5)
    val node2 = createNode(1, 3, 4)
    val node3 = createNode(2, 6)

    val list = mutableListOf(node1, node2, node3)
    var result = mergeKLists(list)
    while (result != null) {
        print("${result.`val`}->")
        result = result.next
    }
}

private fun quickSort(list: List<Int>): List<Int> {
    return if (list.size <= 1) list
    else {
        list.takeLast(list.lastIndex)
            .partition { it < list[0] }
            .run { quickSort(first) + list[0] + quickSort(second) }
    }
}

//空间占用太大
private fun mergeKLists(lists: MutableList<ListNode?>): ListNode? {
    val firstNodeList = lists.filterNotNull()
    var listResult: List<ListNode?> = quickSort2(firstNodeList)
    val resultNode = ListNode(0)
    var arrowNode = resultNode
    while (listResult.isNotEmpty()) {
        var node = listResult.first()
        arrowNode.next = node
        arrowNode = arrowNode.next!!
        listResult = moveFirstNode(listResult)
    }
    return resultNode.next
}

private fun moveFirstNode(listResult: List<ListNode?>): List<ListNode> {
    var node = listResult.first()
    val list2 = listResult.drop(1).toMutableList()
    node = node?.next
    list2.add(node)
    val list3 = list2.filterNotNull()
    return quickSort2(list3)
}

private fun quickSort2(list: List<ListNode>): List<ListNode> {
    return if (list.size <= 1) list
    else {
        list.takeLast(list.lastIndex)
            .partition { it.`val` < list[0].`val` }
            .run { quickSort2(first) + list[0] + quickSort2(second) }
    }
}

private fun createNode(vararg elements: Int): ListNode? {
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

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}