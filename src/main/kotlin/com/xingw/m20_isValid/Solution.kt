package com.xingw.m20_isValid

import java.util.Stack

/**
 * Create by xingw on 2020/2/24
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(isValid("{[}]"))
    }

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c)
            } else {
                when(stack.pop()){
                    '['-> if (c != ']')return false
                    '{'-> if (c != '}')return false
                    '('-> if (c != ')')return false
                }
            }
        }
        return stack.empty()
    }
}