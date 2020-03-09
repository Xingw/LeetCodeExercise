package com.xingw

import java.text.DecimalFormat
import java.util.Locale

/**
 * Create by xingw on 2019/12/30
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
    }

    // fun testPhoneList(phoneList: List<String>, name: String) {
    //
    //     var result: ContactsBean? = null
    //     var pinyinSearch = name.split(" ")
    //     while (pinyinSearch.isNotEmpty()) {
    //         val resultList = findDataByEN(
    //             pinyinSearch,
    //             contactCache
    //         )
    //         val map = HashMap<String, ContactsBean>()
    //         resultList.forEach { map[it.namePinYin!!] = it }
    //         result = queryByInitialConsonant(map, pinyinList)
    //         if (result == null) {
    //             pinyinSearch = pinyinSearch.dropLast(1)
    //             continue
    //         }
    //         break
    //     }
    // }

    //通过拼音或者英文字母
    fun findDataByEN(
        inputStr: String,
        searchContactLists: MutableList<ContactsBean>
    ): MutableList<ContactsBean> {
        val contactLists = mutableListOf<ContactsBean>()
        //把输入的内容变为大写
        val searPinyin = inputStr.toUpperCase(Locale.CHINA)
        //搜索字符串的长度
        val searLength = searPinyin.length
        //搜索的第一个大写字母
        val searPinyinFirst = searPinyin[0]
        for (i in 0 until searchContactLists.size) {
            val contactsBean = searchContactLists[i]
            contactsBean.matchType = 1//字母匹配肯定是名字
            //如果输入的每一个字母都和名字的首字母一样，那就可以匹配比如：你好，NH，输入nh就ok
            if (contactsBean.matchPin.contains(searPinyin)) {
                contactLists.add(contactsBean)
            } else {
                var isMatch = false
                //先去匹配单个字，比如你好：NI,HAO.输入NI，肯定匹配第一个
                for (j in 0 until contactsBean.namePinyinList.size) {
                    val namePinyinPer = contactsBean.namePinyinList[j]
                    if (namePinyinPer.isNotEmpty() && namePinyinPer.startsWith(searPinyin)) {
                        //符合的话就是当前字匹配成功
                        contactLists.add(contactsBean)
                        isMatch = true
                        break
                    }
                }
                if (isMatch) {
                    continue
                }
                //根据拼音包含来实现，比如你好：NIHAO,输入NIHA或者NIHAO。
                if (!contactsBean.namePinYin.isNullOrEmpty() && contactsBean.namePinYin!!.contains(
                        searPinyin
                    )
                ) {
                    //这样的话就要从每个字的拼音开始匹配起
                    for (j in 0 until contactsBean.namePinyinList.size) {
                        val sbMatch = StringBuilder()
                        for (k in j until contactsBean.namePinyinList.size) {
                            sbMatch.append(contactsBean.namePinyinList[k])
                        }
                        if (sbMatch.toString().startsWith(searPinyin)) {
                            //匹配成功
                            //比如输入是NIH，或者NIHA,或者NIHAO,这些都可以匹配上，从而就可以通过NIHAO>=NIH,HIHA,NIHAO
                            isMatch = true
                            contactLists.add(contactsBean)
                        }
                    }
                }

                if (isMatch) {
                    continue
                }

                //最后一种情况比如：广发银行，输入GuangFY或者GuangFYH都可以匹配成功，这样的情况名字集合必须大于等于3
                if (contactsBean.namePinyinList.size > 2) {
                    for (j in 0 until contactsBean.namePinyinList.size) {

                        val sbMatch0 = StringBuilder()
                        sbMatch0.append(contactsBean.namePinyinList[j])
                        //只匹配到倒数第二个
                        if (j < contactsBean.namePinyinList.size - 2) {
                            for (k in j + 1 until contactsBean.matchPin.length) {
                                //依次添加后面每个字的首字母
                                sbMatch0.append(contactsBean.matchPin[k])
                                if (sbMatch0.toString() == searPinyin) {
                                    contactLists.add(contactsBean)
                                    isMatch = true
                                    break
                                }
                            }
                        }

                        if (isMatch) {
                            //跳出循环已找到
                            break
                        }

                        //sbMatch1是循环匹配对象比如GUANGFYH，GUANGFAYH，GUANGFAYINH,GUANGFAYINHANG，
                        //FAYH,YINH
                        val sbMatch1 = StringBuilder()
                        for (k in 0..j) {//依次作为初始匹配的起点
                            sbMatch1.append(contactsBean.namePinyinList[k])
                        }
                        //只匹配到倒数第二个
                        if (j < contactsBean.namePinyinList.size - 2) {
                            for (k in j + 1 until contactsBean.matchPin.length) {
                                //依次添加后面每个字的首字母
                                sbMatch1.append(contactsBean.matchPin[k])
                                if (sbMatch1.toString() == searPinyin) {
                                    contactLists.add(contactsBean)
                                    isMatch = true
                                    break
                                }
                            }
                        }
                        if (isMatch) {
                            //跳出循环已找到
                            break
                        }

                        if (j >= contactsBean.namePinyinList.size - 2) {
                            //如果说是剩余最后两个拼音不需要匹配了
                            break
                        }
                        val sbMatch2 = StringBuilder()
                        sbMatch2.append(contactsBean.namePinyinList[j])
                        for (k in j + 1 until contactsBean.namePinyinList.size) {
                            sbMatch2.append(contactsBean.namePinyinList[k])
                            val sbMatch3 = StringBuilder()
                            sbMatch3.append(sbMatch2.toString())
                            //只匹配到倒数第二个
                            if (j < contactsBean.namePinyinList.size - 2) {
                                for (m in k + 1 until contactsBean.matchPin.length) {
                                    //依次添加后面每个字的首字母
                                    sbMatch3.append(contactsBean.matchPin[m])
                                    if (sbMatch3.toString() == searPinyin) {
                                        contactLists.add(contactsBean)
                                        isMatch = true
                                        break
                                    }
                                }
                            }
                            if (isMatch) {
                                //跳出循环已找到
                                break
                            }
                        }

                        if (isMatch) {
                            //跳出循环已找到
                            break
                        }
                    }
                }
            }
        }
        return contactLists
    }

    fun queryByInitialConsonant(
        contactEntityMap: Map<String, ContactsBean>,
        namePinYinStringList: List<String>
    ): ContactsBean? {
        // log.d("queryByInitialConsonant")
        val pinYinPercentMap: MutableMap<String, Double> =
            java.util.HashMap()
        for (entity in contactEntityMap) {
            val nickName = entity.key
            val contactsBean: ContactsBean = entity.value
            val nickNamePinYin = contactsBean.namePinYin!!
            val namePinYinSearch = namePinYinStringList.joinToString(separator = "")
            val percent = countPercent(nickNamePinYin, namePinYinSearch).toDouble()
            // log.d("name:$nickNamePinYin,percent: $percent")
            pinYinPercentMap[nickName] = percent
        }
        var maxPercent = 0.00
        var maxPercentNickName = ""
        for (mutableEntry in pinYinPercentMap) {
            val nickName = mutableEntry.key
            val percent = mutableEntry.value
            if (percent > maxPercent) {
                // log.d("percent > maxPercent, percent: $percent, maxPercent: $maxPercent")
                maxPercent = percent
                maxPercentNickName = nickName
            }
        }
        // log.d("maxPercent: $maxPercent, maxPercentNickName: $maxPercentNickName")
        return if (maxPercent > 0.66) {
            contactEntityMap[maxPercentNickName]
        } else {
            null
        }
    }

    private fun countPercent(str: String, str1: String): String {
        var str = str.toUpperCase()
        var str1 = str1.toUpperCase()
        if (str.length > str1.length) {
            return countPercent(str1, str)
        }
        val df = DecimalFormat("0.00")
        var count = 0
        val map: MutableMap<Char, Int> = java.util.HashMap()
        val cs = str1.toCharArray()
        for (c in cs) {
            map[c] = if (map[c] == null) 1 else map[c]!! + 1
        }
        for (i in str.indices) {
            if (map[str[i]] != null) {
                if (map[str[i]] != -1) {
                    val s = map[str[i]]!! - 1
                    if (s == 0) {
                        map[str[i]] = -1
                        count++
                    } else if (s > 0) {
                        map[str[i]] = s
                        count++
                    }
                }
            }
        }
        val result = count.toDouble() / str1.length
        return df.format(result)
    }
}

class ContactsBean(
    val contactId: String
) : Comparable<ContactsBean> {
    var name: String? = null
    var matchPin: String = ""
    var namePinYin: String? = null
    var matchType = 1 //匹配类型 名字1，电话号2
    var pinyinFirst = "#"
    var namePinyinList = arrayListOf<String>()
    var numberList = arrayListOf<String>()

    override fun compareTo(other: ContactsBean): Int {
        if (this.pinyinFirst == "#") {
            return 1
        } else if (other.pinyinFirst == "#") {
            return -1
        }
        return this.pinyinFirst.compareTo(other.pinyinFirst)
    }
}