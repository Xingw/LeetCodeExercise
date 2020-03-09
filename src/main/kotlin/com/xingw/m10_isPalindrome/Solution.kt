package com.xingw.m10_isPalindrome

/**
 * Create by xingw on 2020/1/8
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(isPalindrome(121121))
    }

    //方法1 字符串反转
    //计算效率不高
    //执行用时 : 384 ms , 在所有 Kotlin 提交中击败了 5.60% 的用户
    // 内存消耗 : 35.8 MB , 在所有 Kotlin 提交中击败了 100.00% 的用户
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val str = x.toString()
        var p1 = 0
        var p2 = str.lastIndex
        while (p1 < p2) {
            if (str[p1++] != str[p2--]) return false
        }
        return true
    }

    //执行用时 :216 ms, 在所有 Kotlin 提交中击败了 99.20% 的用户
    // 内存消耗 : 34.6 MB , 在所有 Kotlin 提交中击败了 100.00% 的用户
    fun isPalindrome2(x: Int): Boolean {
        if (x < 0) return false
        var x = x
        var revertedNumber = 0
        //当x < revertedNumber时，超过一半
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10
            x /= 10
        }

        //奇数情况 除以10 去掉中位数不影响结果
        return x == revertedNumber || x == revertedNumber / 10
    }
}