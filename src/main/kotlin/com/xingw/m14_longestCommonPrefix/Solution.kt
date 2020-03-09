package com.xingw.m14_longestCommonPrefix

/**
 * Create by xingw on 2020/1/10
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(longestCommonPrefix(arrayOf("flower","flow","flight")))
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var prefix = strs[0]
        for(i in 1 until strs.size){
            while(strs[i].indexOf(prefix) != 0){
                if(prefix.length ==1) return ""
                prefix = prefix.substring(0,prefix.length -1)
                continue
            }
        }

        return prefix
    }
}