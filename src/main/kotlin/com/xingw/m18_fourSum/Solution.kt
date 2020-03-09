package com.xingw.m18_fourSum

/**
 * Create by xingw on 2020/1/19
 */
object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        println(fourSum2(intArrayOf(1, 0, -1, 0, -2, 2), 0))
    }

    fun fourSum2(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val n = nums.size
        val res = mutableListOf<List<Int>>()
        if (nums.size<4)return res
        for (a in 0..n - 4) {
            if (a > 0 && nums[a] == nums[a - 1]) continue
            for (b in a + 1..n - 3) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue
                var c = b + 1
                var d = n - 1
                while (c<d){
                    if (nums[a]+nums[b]+nums[c]+nums[d] < target){
                        c++
                    } else if (nums[a]+nums[b]+nums[c]+nums[d] > target) {
                        d--
                    } else{
                        res.add(mutableListOf(nums[a],nums[b],nums[c],nums[d]))
                        while (c<d&&nums[c] == nums[c+1])c++
                        while (c<d&&nums[d] == nums[d-1])d--
                        c++
                        d--
                    }
                }
            }
        }
        return res
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        if (nums.size < 3) return listOf()
        val hash = HashSet<Int>()
        val result = mutableListOf<List<Int>>()
        nums.sort()
        for (i in nums.indices - 3) {
            if (!hash.add(nums[i])) {
                continue
            }
            result.addAll(
                nSum(
                    nums.copyOfRange(i + 1, nums.size),
                    target - nums[i],
                    3
                ).also { it.map { it.add(nums[i]) } }.toMutableList()
            )
        }
        return result
    }

    fun nSum(nums: IntArray, target: Int, n: Int): MutableList<MutableList<Int>> {
        val list = mutableListOf<MutableList<Int>>()
        if (n == 2) {
            return list.also { it.add(twoSum(nums, target) ?: return mutableListOf()) }
        }
        for (k in nums.indices - n - 1) {
            list.addAll(nSum(
                nums.copyOfRange(k + 1, nums.size),
                target - nums[k],
                n - 1
            ).also { it.map { it.add(nums[k]) } })
        }
        return list
    }

    //无序数组
    fun twoSum(nums: IntArray, target: Int): MutableList<Int>? {
        val hash = HashMap<Int, Int>(nums.size)
        for (i in nums.indices) {
            val a = target - nums[i]
            if (hash.containsKey(a)) return mutableListOf(a, nums[i])
            hash[nums[i]] = i
        }
        return null
    }
}