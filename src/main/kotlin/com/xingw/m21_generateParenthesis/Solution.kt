package com.xingw.m21_generateParenthesis

/**
 * Create by xingw on 2020/2/24
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(generateParenthesis2(3))
    }

    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        if (n == 0) {
            result.add("")
        } else {
            for (c in 0 until n)
                for (left in generateParenthesis(c))
                    for (right in generateParenthesis(n - c - 1)) {
                        result.add("(${left})${right}")
                    }
        }
        return result
    }

    fun generateParenthesis2(n: Int): List<String> {
        val result = mutableListOf<String>()
        generate(result, "", 0, 0, n)
        return result
    }

    fun generate(list: MutableList<String>, str: String, open: Int, close: Int, n: Int) {
        if (str.length == n * 2) {
            list.add(str)
            return
        }

        if (close < open) {
            generate(list, "$str)", open, close + 1, n)
        }
        if (open < n) {
            generate(list, "$str(", open + 1, close, n)
        }
    }
}