package com.sflin.algorithmic.ui

import android.content.pm.ActivityInfo.CONFIG_ORIENTATION
import android.content.pm.ActivityInfo.CONFIG_SCREEN_SIZE
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.sflin.algorithmic.array.EasyArrayUtils
import com.sflin.algorithmic.array.MediumArrayUtils
import com.sflin.algorithmic.dynamic_programming.HardDynamicProgrammingUtils
import com.sflin.algorithmic.linkedList.EasyLinkedListUtils
import com.sflin.algorithmic.linkedList.ListNode
import com.sflin.algorithmic.stack.MediumStackUtils
import com.sflin.algorithmic.string.EasyStringUtils
import com.sflin.algorithmic.string.HardStringUtils
import com.sflin.algorithmic.string.MediumStringUtils
import com.sflin.algorithmic.string.Trie
import com.sflin.algorithmic.tree.TreeNode
import com.sflin.algorithmic.ui.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {

    private var adapter: ListAdapter? = null

    private val listData = arrayListOf<String>()

    private var mOldConfig: Configuration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.sflin.algorithmic.R.layout.activity_main)

        mOldConfig = Configuration(getResources().getConfiguration());

        init()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        val diff = newConfig.diff(mOldConfig)
        if (diff and (CONFIG_ORIENTATION or CONFIG_SCREEN_SIZE) != 0) {
//            onHandleConfigChanged()
        }
        mOldConfig?.setTo(newConfig)
        super.onConfigurationChanged(newConfig)
    }

    private fun init() {
        listData.add("字符串")
        listData.add("数组")
        listData.add("堆栈与队列")
        listData.add("链表")
        listData.add("树")
        listData.add("数学")
        listData.add("动态规划")

        adapter = ListAdapter(listData)
        adapter!!.setOnClickListener(object : ListAdapter.OnCallBack {
            override fun onClick(name: String) {
                switchAlgorithmic(name)
            }
        })
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
    }

    private fun switchAlgorithmic(name: String) {
        when (name) {
            "字符串" ->{
                string()
            }
            "数组" ->{
                array()
            }
            "堆栈与队列" ->{
                stack()
            }
            "链表" ->{
                linkedList()
            }
            "树" ->{
                tree()
            }
            "动态规划" ->{

            }
            "数学" ->{

            }
        }
    }

    private fun string() {
//        EasyStringUtils.isPalindrome("A man, a plan, a canal: Panama")
//        EasyStringUtils.myAtoi("+-2")
//        EasyStringUtils.strStr("mississippi", "issip")
        val str = EasyStringUtils.longestCommonPrefix(arrayOf("flower", "flow", "flight"))
        MediumStringUtils.partition("aab")
        MediumStringUtils.wordBreak("pineapplepenapple", arrayListOf("apple", "pen", "applepen", "pine", "pineapple"))
        HardStringUtils.wordBreak("leetcode", arrayListOf("leet", "code"))

        val trie = Trie();
        trie.insert("apple")
    }

    private fun array() {
        EasyArrayUtils.majorityElement(intArrayOf(3, 2, 3))
//        EasyArrayUtils.intersect(intArrayOf(1, 2), intArrayOf(1, 1))
//        EasyArrayUtils.moveZeroes(intArrayOf(1, 0, 0, 3, 12))
        val arr = Array(3) { IntArray(3) }
        arr[0][0] = 1
        arr[0][1] = 2
        arr[0][2] = 3
        arr[1][0] = 4
        arr[1][1] = 5
        arr[1][2] = 6
        arr[2][0] = 7
        arr[2][1] = 8
        arr[2][2] = 9
//        EasyArrayUtils.rotate(arr)
//
//        val tes = arrayOf(
//            intArrayOf(1, 4, 7, 11, 15),
//            intArrayOf(2, 5, 8, 12, 19),
//            intArrayOf(3, 6, 9, 16, 22),
//            intArrayOf(10, 13, 14, 17, 24),
//            intArrayOf(18, 21, 23, 26, 30)
//        )
        MediumArrayUtils.productExceptSelf(intArrayOf(1, 2, 3, 4))
    }

    private fun stack() {
        MediumStackUtils.findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6),2)
        MediumStackUtils.kthSmallest(arrayOf(intArrayOf(1,5,9),intArrayOf(10,11,13),intArrayOf(12,13,15)),8)
    }

    private fun linkedList() {
        val listNode = ListNode(3)
        listNode.next = ListNode(2)
        listNode.next.next = ListNode(0)
        listNode.next.next.next = ListNode(-4)

//        val listNode2 = ListNode(1)
//        listNode2.next = ListNode(3)
//        listNode2.next.next = ListNode(5)
//        EasyLinkedListUtils.mergeTwoLists(listNode, listNode2)
        EasyLinkedListUtils.hasCycle(listNode)
    }

    private fun tree() {
        val root = TreeNode(1)
        root.left = TreeNode(2).apply {
            left = TreeNode(3).apply {
                left = TreeNode(5)
                right = TreeNode(6)
            }
            right = TreeNode(4).apply {
                left = TreeNode(7)
                right = TreeNode(8)
            }
        }
        root.right = TreeNode(2).apply {
            left = TreeNode(4).apply {
                left = TreeNode(8)
                right = TreeNode(7)
            }
            right = TreeNode(3).apply {
                left = TreeNode(6)
                right = TreeNode(5)
            }
        }
//        EasyTreeUtils.levelOrder(root)
//        Log.e("dsds", "${result}")
//        EasyDynamicProgrammingUtils.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4, 8))
//        EasyMathUtils.countPrimes(10)
//        EasyOtherUtils.isValid("{}[{}]((){})(){}")
        HardDynamicProgrammingUtils.superEggDrop(2, 6)
    }
}
