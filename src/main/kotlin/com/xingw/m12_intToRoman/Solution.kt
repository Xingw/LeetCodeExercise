package com.xingw.m12_intToRoman

/**
 * Create by xingw on 2020/1/9
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(intToRoman(3999))
    }

    val table = arrayOf(arrayOf("I", "V"), arrayOf("X", "L"), arrayOf("C", "D"), arrayOf("M"))

    private fun intToRoman(num: Int): String {
        var num = num
        var decimals = 0
        val stringBuffer = StringBuffer()
        while (num != 0) {
            var m = num % 10
            num /= 10
            while (m != 0) {
                when {
                    m == 9 -> {
                        stringBuffer.insert(0, "${table[decimals][0]}${table[decimals + 1][0]}")
                        m = 0
                    }
                    m == 4 -> {
                        stringBuffer.insert(0, "${table[decimals][0]}${table[decimals][1]}")
                        m = 0
                    }
                    m == 5 ->{
                        stringBuffer.insert(0, table[decimals][1])
                        m -=5
                    }
                    else -> {
                        stringBuffer.insert(0, table[decimals][0])
                        m--
                    }
                }
            }
            decimals++
        }
        return stringBuffer.toString()
    }
}