package day4;

import day4.Code4_Reverse.ListNode;

/**
 * 两个有序的链表合并 合并之后依然有序
 * 1->3->3->5 2->4->3->7
 * 返回 1->2->3->3->3->4->5->7
 * <p>
 * 因为链表有有序
 * 所以两个链表同时循环 假设有一个为null循环结束 排序结束
 * 完成排序
 */
public class Code6_SortTwoNode {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node3;
        node3.next = node5;
        node2.next = node4;
        node4.next = node6;
        System.out.println(mergeTwoLists(node1, node2));
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        System.out.println(mergeTwoLists(node7,node8));
    }

    //此方法产生了一个新的链表 不是很好
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode lastNode1 = null;
        ListNode lastNode2 = null;
        //先拿出最小的一个
        ListNode head =  new ListNode(Math.min(list1.val, list2.val));
        //方便指针的移动
        ListNode curr = head;
        //因为已经拿过第一个了 所以要把后续指针往后移动一个
        if (list1.val > list2.val) {
            /**
             * 因为list2的值小 所引标记list1 因为list2往前面走 最后剩下的可能是list1
             * 如果list2走完了 剩下的list1也是有序的
             * 所引直接指向list1剩下的就好了
             */
            lastNode1 = list1;
            list2 = list2.next;
        } else {
            lastNode2 = list2;
            list1 = list1.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                lastNode1 = list1;
                /**
                 * 谁小把值放进去 然后那一条链表的指针下移
                 * 如果两个链表有任意一个走完 直接结束
                 */
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                lastNode2 = list2;
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            //新的链表指针下移
            curr = curr.next;
        }
        // 剩余的链表是有序的 所引剩下的指针指向剩余的链表就好了
        curr.next = list1 == null ? lastNode2 : lastNode1;

        return head;
    }
}
