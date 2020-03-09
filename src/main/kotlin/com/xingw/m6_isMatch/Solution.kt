package com.xingw.m6_isMatch

/**
 * Create by xingw on 2019/12/27
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(isMatch2("aa", "a*"))
    }

    private fun isMatch(text: String, pattern: String): Boolean {
        if (pattern.isEmpty()) return text.isEmpty()
        val firstMatch = (text.isNotEmpty()) && ((pattern[0] == text[0]) || pattern[0] == '.')

        return if (pattern.length >= 2 && pattern[1] == '*') {
            (isMatch(text, pattern.substring(2))
                || (firstMatch && isMatch(text.substring(1), pattern)))
        } else {
            firstMatch && isMatch(text.substring(1), pattern.substring(1))
        }
    }

    lateinit var array: Array<Array<Boolean?>>

    private fun isMatch2(text: String, pattern: String): Boolean {
        array = Array(text.length + 1) { Array<Boolean?>(pattern.length + 1) { null } }
        return dp(0, 0, text, pattern)
    }

    private fun dp(i: Int, j: Int, text: String, pattern: String): Boolean {
        if (array[i][j] != null) return array[i][j]!!
        if (j == pattern.length) {
            array[i][j] = i == text.length
            return array[i][j]!!
        }

        val firstMatch = (i < text.length && (pattern[j] == text[i] || pattern[j] == '.'))

        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            array[i][j] = (dp(i, j + 2, text, pattern) || (firstMatch && dp(i + 1, j, text, pattern)))
            return array[i][j]!!
        }
        array[i][j] = firstMatch && dp(i + 1, j + 1, text, pattern)
        return array[i][j]!!
    }
}