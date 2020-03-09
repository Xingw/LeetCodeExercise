package com.xingw.m3_lengthOfLongestSubstring

import java.util.HashMap
import java.util.HashSet
import kotlin.math.max

/**
 * Create by xingw on 2019/12/18
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        System.out.println(lengthOfLongestSubstring2("abccbabb"))
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val hashSet = HashSet<Char>()
        var p1 = 0
        var p2 = 1
        var maxlenght = 1
        var length = 1
        var change = 2
        hashSet.add(s[0])
        while (p1 != s.length && p2 != s.length) {
            println("$p1,$p2,$length")
            if (change == 1) {
                if (s[p1] == s[p2]) {
                    p1++
                    p2++
                    change = p2
                } else {
                    hashSet.remove(s[p1])
                    length--
                    change = p1
                    p1++
                }
            } else {
                val repeat = !hashSet.add(s[p2])
                if (repeat) {
                    change = 1
                } else {
                    length++
                    maxlenght = max(length, maxlenght)
                    p2++
                    change = p2
                }
            }
        }
        return maxlenght
    }

    fun lengthOfLongestSubstring2(s: String): Int {
        val n = s.length
        val set: MutableSet<Char> = HashSet()
        var ans = 0
        var i = 0
        var j = 0
        while (i < n && j < n) { // try to extend the range [i, j]
            println("$i,$j")
            if (!set.contains(s[j])) {
                set.add(s[j++])
                ans = Math.max(ans, j - i)
            } else {
                set.remove(s[i++])
            }
        }
        return ans
    }

    fun lengthOfLongestSubstring3(s: String): Int {
        val n = s.length
        var ans = 0
        val map: MutableMap<Char, Int?> =
            HashMap() // current index of character
        // try to extend the range [i, j]
        var j = 0
        var i = 0
        while (j < n) {
            if (map.containsKey(s[j])) {
                i = Math.max(map[s[j]]!!, i)
            }
            ans = Math.max(ans, j - i + 1)
            map[s[j]] = j + 1
            j++
        }
        return ans
    }
}