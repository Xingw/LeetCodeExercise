package com.xingw.m7_convert

/**
 * Create by xingw on 2020/1/7
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(convert("AB", 2))
    }

    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s

        val stringBuffer = StringBuffer()
        //line1
        var i = 0;
        while (i < s.length) {
            stringBuffer.append(s[i])
            i += (numRows - 2) * 2 + 2
        }
        for (k in 1 until numRows - 1) {
            //两行字母
            stringBuffer.append(covertDouble(s, numRows, k))
        }
        i = numRows - 1
        while (i < s.length) {
            stringBuffer.append(s[i])
            i += (numRows - 2) * 2 + 2
        }
        return stringBuffer.toString()
    }

    private fun covertDouble(s: String, numRows: Int, k: Int): String {
        var i = k
        var jumpPro = (numRows - k - 2) * 2 + 2
        val jumpAft = (numRows - 2) * 2 + 2 - jumpPro
        val stringBuffer = StringBuffer()
        while (i < s.length) {
            stringBuffer.append(s[i])
            if (i + jumpPro < s.length) {
                stringBuffer.append(s[i + jumpPro])
            }
            i += jumpPro + jumpAft
        }
        return stringBuffer.toString()
    }
}