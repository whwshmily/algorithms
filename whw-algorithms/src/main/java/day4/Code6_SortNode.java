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
public class Code6_SortNode {
    // 这个没有产生新的node 只是变动了指针
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        //先找到头节点
        ListNode head = head1.val > head2.val ? head2 : head1;
        //头节点的链表 进入下一个节点
        ListNode curr1 = head.next;
        //不是头节点的链表 直接从头开始
        ListNode curr2 = head == head1 ? head2 : head1;
        //指针标记 方便当前位置确定一个节点的时候 操作指针
        ListNode curr = head;
        //有一个链表排完  结束
        while (curr1 != null && curr2 != null) {
            if (curr1.val > curr2.val) {
                /**
                 *  1 -> 3 -> 5
                 *  2 -> 4 -> 6
                 *  头节点是 head=1 curr =1
                 *  curr1 =3  curr2 =2
                 *  这时 curr2< curr1
                 *  然后这时 让curr 的next指针指向从 1 改成 2
                 *  让 curr2 移动到他的下一个= 4 curr1 = 3
                 *  curr 指向他的下一个 = 2
                 *  1 2 4 6
                 *   3 5
                 *  然后进入下一次循环
                 *  curr1 < curr2
                 *  让curr next 指向 3 curr1 移动到5
                 *  curr 移动到next
                 *  curr2=4 curr1 =1
                 *  下一次循环
                 */
                curr.next = curr2;
                curr2 = curr2.next;
            } else {
                curr.next = curr1;
                curr1 = curr1.next;
            }
            curr = curr.next;
        }
        //循环结束 curr的next 指向还没有走完的链表 因为剩余的链表有序
        curr.next = curr1 == null ? curr2 : curr1;
        return head;
    }
}
