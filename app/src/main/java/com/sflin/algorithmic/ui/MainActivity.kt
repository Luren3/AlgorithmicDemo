package com.sflin.algorithmic.ui

import android.os.*
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.sflin.algorithmic.array.EasyArrayUtils
import com.sflin.algorithmic.array.HardArrayUtils
import com.sflin.algorithmic.array.MediumArrayUtils
import com.sflin.algorithmic.dynamic_programming.HardDynamicProgrammingUtils
import com.sflin.algorithmic.dynamic_programming.MediumDynamicProgrammingUtils
import com.sflin.algorithmic.hash.EasyHashUtils
import com.sflin.algorithmic.hash.RandomizedSet
import com.sflin.algorithmic.linkedList.EasyLinkedListUtils
import com.sflin.algorithmic.linkedList.ListNode
import com.sflin.algorithmic.linkedList.MediumLinkedListUtils
import com.sflin.algorithmic.other.EasyOtherUtils
import com.sflin.algorithmic.other.MediumOtherUtils
import com.sflin.algorithmic.sort_and_serarch.MediumSortAndSearchUtils
import com.sflin.algorithmic.stack.HardStackUtils
import com.sflin.algorithmic.stack.MedianFinder
import com.sflin.algorithmic.stack.MediumStackUtils
import com.sflin.algorithmic.string.EasyStringUtils
import com.sflin.algorithmic.string.HardStringUtils
import com.sflin.algorithmic.string.MediumStringUtils
import com.sflin.algorithmic.string.Trie
import com.sflin.algorithmic.tree.Codec
import com.sflin.algorithmic.tree.HardTreeUtils
import com.sflin.algorithmic.tree.TreeNode
import com.sflin.algorithmic.ui.adapter.ListAdapter
import dalvik.system.DexClassLoader
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.ConcurrentHashMap


class MainActivity : AppCompatActivity() {

    private var adapter: ListAdapter? = null

    private val listData = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.sflin.algorithmic.R.layout.activity_main)

        init()
        val map = ConcurrentHashMap<String,String>()
        map.put("1","1")

        startActivity(null)
    }

    private fun init() {
        listData.add("字符串")
        listData.add("数组")
        listData.add("堆栈与队列")
        listData.add("链表")
        listData.add("树")
        listData.add("数学")
        listData.add("动态规划")
        listData.add("哈希与映射")
        listData.add("排序和搜索")
        listData.add("其他")

        adapter = ListAdapter(listData)
        adapter!!.setOnClickListener(object : ListAdapter.OnCallBack {
            @RequiresApi(Build.VERSION_CODES.N)
            override fun onClick(name: String) {
                switchAlgorithmic(name)
            }
        })
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
        list.invalidate()

    }

    @RequiresApi(Build.VERSION_CODES.N)
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
                dp()
            }
            "数学" ->{

            }
            "哈希与映射" ->{
                hash()
            }
            "排序和搜索" ->{
                sortAndSearch()
            }
            "其他" ->{
                other()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
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

        MediumStringUtils.simplifyPath("/home/")

        MediumStringUtils.splitLoopedString(arrayOf("abc","xyz"))

        MediumStringUtils.isSubsequence("abc","ahbgdc")
        EasyStringUtils.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth")
    }

    @RequiresApi(Build.VERSION_CODES.N)
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
        MediumArrayUtils.kthSmallest(arrayOf(intArrayOf(1,5,9),intArrayOf(10,11,13),intArrayOf(12,13,15)),8)

        for (one in MediumArrayUtils.continuousSum(intArrayOf(9,5,2,10,9,1),17)){
            Log.e("test","${one}")
        }

        MediumArrayUtils.search(intArrayOf(4,5,6,7,0,1,2),0)
        MediumArrayUtils.permuteUnique(intArrayOf(1,1,2))
//        HardArrayUtils.jump(intArrayOf(10,9,8,7,6,5,4,3,2,1,1,0))
        MediumArrayUtils.stoneGame(intArrayOf(5,3,4,5))
        MediumArrayUtils.sumSubarrayMins(intArrayOf(3,1,2,4))

        HardArrayUtils.trap(intArrayOf(2,0,2))
        MediumArrayUtils.findMin(intArrayOf(3,4,5,1,2))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun stack() {
//        MediumStackUtils.findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6),2)
        val median = MedianFinder()
        median.addNum(1)
        median.addNum(2)
        median.addNum(3)
        median.addNum(7)
        median.addNum(4)
        median.addNum(6)
        median.addNum(5)
        median.addNum(8)
        median.findMedian()

        HardStackUtils.maxSlidingWindow(intArrayOf(1,2,3,4,5,6,7),3);
        MediumStackUtils.calculate(" 3+5/2 ")
        MediumStackUtils.evalRPN(arrayOf("2", "1", "+", "3", "*"))
    }

    private fun linkedList() {
        val listNode = ListNode(4)
        listNode.next = ListNode(2)
        listNode.next.next = ListNode(1)
        listNode.next.next.next = ListNode(3)

//        val listNode2 = ListNode(1)
//        listNode2.next = ListNode(3)
//        listNode2.next.next = ListNode(5)
//        EasyLinkedListUtils.mergeTwoLists(listNode, listNode2)
//        EasyLinkedListUtils.hasCycle(listNode)
        MediumLinkedListUtils.sortList(listNode)
//        val node = Node()
//        node.`val` = 1
//        node.next = Node().apply {
//            `val` = 2
//            random = Node()
//        }
//        node.random = Node()
//        MediumLinkedListUtils.copyRandomList(node)
        MediumLinkedListUtils.oddEvenList(listNode)
        EasyLinkedListUtils.isPalindrome(listNode)
    }

    private fun tree() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
//        MediumTreeUtils.levelOrder(root)
//        EasyTreeUtils.sortedArrayToBST(intArrayOf(-10,-3,0,5,9))
//        MediumTreeUtils.kthSmallest(root,1)
//        MediumTreeUtils.lowestCommonAncestor(root, TreeNode(6), TreeNode(7))
        val codec = Codec()
        val str = codec.serialize(root)
        Log.e("dsdsd",str)
        codec.deserialize(str)
        HardTreeUtils.maxPathSum(root)
    }

    private fun hash() {
        EasyHashUtils.titleToNumber("AB")
        val randomizedSet = RandomizedSet()
        randomizedSet.insert(1)
        randomizedSet.remove(2)
        randomizedSet.insert(2)
        randomizedSet.random
        randomizedSet.remove(1)
        randomizedSet.insert(2)
        randomizedSet.random
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun dp(){
        MediumDynamicProgrammingUtils.longestSubstring("abb",2)
        HardDynamicProgrammingUtils.longestConsecutive(intArrayOf(0,-1))
        MediumDynamicProgrammingUtils.lengthOfLIS(intArrayOf(5,9,6,5,7,4,8,2))
        MediumDynamicProgrammingUtils.coinChange(intArrayOf(186,419,83,408),6249)
    }

    private fun sortAndSearch() {
        MediumSortAndSearchUtils.minMutation("AAAAACCC","AACCCCCC", arrayOf("AAAACCCC","AAACCCCC","AACCCCCC"))
    }

    private fun other() {
//        val arr = arrayOf(intArrayOf(2))
        val arr = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        EasyOtherUtils.surfaceArea(arr)
        MediumOtherUtils.generateParenthesis(3)
        MediumOtherUtils.numIslands(arrayOf(charArrayOf('1','1','0','0','0'), charArrayOf('1','1','0','0','0'), charArrayOf('0','0','1','0','0'), charArrayOf('0','0','0','1','1')))
    }
}
