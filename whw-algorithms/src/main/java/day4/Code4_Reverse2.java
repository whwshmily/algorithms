package day4;

import day4.Code4_Reverse.ListNode;

/**
 * K个节点组内的逆序调整
 * 给定一个单链表的头节点head，和一个正数K
 * 实现K个节点的小组内部逆序，如果最后一组不够K个不调整
 * 例子:
 * 调整前: 1->2->3->4->5->6->7->8 k=3
 * 调整后: 3->2->1->6->5->4->7->8
 * <p>
 * 假设 k=3
 * 刚开始从 0 开始找 你把head 节点传进来 k 往下面找几个 把尾节点反出去 、
 * 如果返回是 null 说明不够了 结束了 不是null 说明有
 * 这时候就是单链表的反转吗 code1
 */
public class Code4_Reverse2 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int count = 0;
        ListNode node = reverseKGroup(node1, 2);
        while (node != null && count++ < 10) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode end = Code4_Reverse.findPointLastNode(head, k);
        if (end == null) {
            return head;
        }
        //记录第一次完成反转后的尾节点
        ListNode start = head;
        //链表反转
        reverse(start, end);
        //链表的头节点 当整个链表走完后 这个是头节点 因为第一次
        head = end;
        ListNode last = start;
        //循环判断链表时候够K个位置
        while (last.next != null) {
            //记录反转的头节点 反转后的尾节点
            start = last.next;
            end = Code4_Reverse.findPointLastNode(start, k);
            if (end == null) {
                return head;
            }
            //链表反转
            reverse(start, end);
            //重新将链表连接在一起 last是上一次反转的尾节点 end是反转后的头节点
            last.next = end;
            //start 是反转后的尾节点 继续循环往下面找
            last = start;
        }

        return head;
    }


    //链表反转
    public static void reverse(ListNode start, ListNode last) {
        ListNode end = last.next;
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = start;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        /**
         * 重新串起来 原链表的头节点变成尾节点 以便保持是一个完整的链表
         * 如果不串起来 会把链表切开 一段一段的
         */
        start.next = end;
    }


}
