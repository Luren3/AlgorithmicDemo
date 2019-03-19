package com.sflin.algorithmic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sflin.algorithmic.array.EasyArrayUtils
import com.sflin.algorithmic.dynamic_programming.HardDynamicProgrammingUtils
import com.sflin.algorithmic.linkedList.EasyLinkedListUtils
import com.sflin.algorithmic.linkedList.ListNode
import com.sflin.algorithmic.other.EasyOtherUtils
import com.sflin.algorithmic.string.EasyStringUtils
import com.sflin.algorithmic.string.MediumStringUtils
import com.sflin.algorithmic.tree.TreeNode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        array.setOnClickListener {
            EasyArrayUtils.majorityElement(intArrayOf(3,2,3))
//            EasyArrayUtils.intersect(intArrayOf(1,2),intArrayOf(1,1))
//            EasyArrayUtils.moveZeroes(intArrayOf(1,0,0,3,12))
            val arr = Array(3){IntArray(3)}
            arr[0][0] = 1
            arr[0][1] = 2
            arr[0][2] = 3
            arr[1][0] = 4
            arr[1][1] = 5
            arr[1][2] = 6
            arr[2][0] = 7
            arr[2][1] = 8
            arr[2][2] = 9
//            EasyArrayUtils.rotate(arr)

//            val tes = arrayOf(
//                intArrayOf(1, 4, 7, 11, 15),
//                intArrayOf(2, 5, 8, 12, 19),
//                intArrayOf(3, 6, 9, 16, 22),
//                intArrayOf(10, 13, 14, 17, 24),
//                intArrayOf(18, 21, 23, 26, 30)
//            )
            val tes = arrayOf(
                intArrayOf(-5))
            EasyArrayUtils.searchMatrix(tes,-5)
        }

        string.setOnClickListener {
//            EasyStringUtils.isPalindrome("A man, a plan, a canal: Panama")
//            EasyStringUtils.myAtoi("+-2")
//            EasyStringUtils.strStr("mississippi","issip")
            val str = EasyStringUtils.longestCommonPrefix(arrayOf("flower","flow","flight"))
            MediumStringUtils.partition("aab")
            MediumStringUtils.wordBreak("leetcode", arrayListOf("leet","code"))
        }

        linkedList.setOnClickListener {
            val listNode = ListNode(3)
            listNode.next = ListNode(2)
            listNode.next.next = ListNode(0)
            listNode.next.next.next = ListNode(-4)
//
//            val listNode2 = ListNode(1)
//            listNode2.next = ListNode(3)
//            listNode2.next.next = ListNode(5)
//            EasyLinkedListUtils.mergeTwoLists(listNode,listNode2)
            EasyLinkedListUtils.hasCycle(listNode)
        }

        tree.setOnClickListener {
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
//            EasyTreeUtils.levelOrder(root)
//            Log.e("dsds","${result}")
//            EasyDynamicProgrammingUtils.maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4,8))
//            EasyMathUtils.countPrimes(10)
            EasyOtherUtils.isValid("{}[{}]((){})(){}")
            HardDynamicProgrammingUtils.superEggDrop(2,6)
        }
    }
}
