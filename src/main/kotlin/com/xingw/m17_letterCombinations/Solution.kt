package com.xingw.m17_letterCombinations

/**
 * Create by xingw on 2020/1/19
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(letterCombinations("23"))
    }

    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return mutableListOf<String>()
        val dict = HashMap<Char, String>()
        dict['2'] = "abc"
        dict['3'] = "def"
        dict['4'] = "ghi"
        dict['5'] = "jkl"
        dict['6'] = "mno"
        dict['7'] = "pqrs"
        dict['8'] = "tuv"
        dict['9'] = "wxyz"
        return combination(digits, 0, dict)
    }

    fun combination(digits: String, i: Int, dict: HashMap<Char, String>): List<String> {
        var result = mutableListOf<String>()
        val str = dict[digits[i]]!!
        for (c in str) {
            if (i == digits.length - 1) {
                result.add(c.toString())
            } else {
                result.addAll(combination(digits, i + 1, dict).map {
                    c+it
                })
            }
        }
        return result
    }
}