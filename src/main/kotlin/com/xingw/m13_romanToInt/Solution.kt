package com.xingw.m13_romanToInt

/**
 * Create by xingw on 2020/1/9
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(romanToInt("MCMXCIV"))
    }

    fun romanToInt(s: String): Int {
        val roman = HashMap<String, Int>()
        roman["I"] = 1
        roman["IV"] = 4
        roman["V"] = 5
        roman["IX"] = 9
        roman["X"] = 10
        roman["XL"] = 40
        roman["L"] = 50
        roman["XC"] = 90
        roman["C"] = 100
        roman["CD"] = 400
        roman["D"] = 500
        roman["CM"] = 900
        roman["M"] = 1000
        var index = 0
        var result = 0
        while (index < s.length) {
            if (index + 1 < s.length && roman.containsKey(s.substring(index, index + 2))) {
                result += roman[s.substring(index, index + 2)]!!
                index += 2
            } else {
                result += roman[s.substring(index, index + 1)]!!
                index++
            }
        }
        return result
    }
}