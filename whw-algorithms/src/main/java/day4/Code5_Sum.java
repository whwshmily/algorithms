package day4;

import day4.Code4_Reverse.ListNode;

/**
 * 两个链表相加
 * 给定两个链表的头节点head1和head2
 * 认为从左到右是某个数字从低位到高位，返回相加后的链表
 * 例子: 4->3->6  2->5->3
 * 返回: 6->8->9
 * 解释: 634+352=986 如果链表不一样长 1->2->3 2->3 321+31=352 返回 2->5->3
 * <p>
 * 先找到链表长度小的  然后进行相加 把结果替换到长链表的值中
 * 1 2 3 4
 * 2 1 2 1
 * 结果 3 3 5 5
 * 1 2 3 8
 * 3 2 7
 * 结果 4 4 0  9
 * 1 2 3 9 9
 * 3 2 7
 * 结果 4 4 0 0  0 1
 */
public class Code5_Sum {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        System.out.println(addTwoNumbers(l1, l4));
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(5);
        System.out.println(addTwoNumbers(l6, l7));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 先找到链表长度短的链表
         */
        int shortNodeNum = findShortNode(l1, l2);
        //短链表
        ListNode shortNode = shortNodeNum == 0 ? l2 : l1;
        //长链表
        ListNode longNode = shortNodeNum == 0 ? l1 : l2;
        //用来表示两数相加是否进1
        int count = 0;
        //两数相加的和
        int sum = 0;
        //两数相加最后%10得到的结果
        int ans = 0;
        /**
         * 用来表示长链表最后一个节点 用来防止长链表最后一位会进 1 然后
         * 要在后面添加一个新的节点
         * 为什么 要在短链表循环中 也要标记长链表最后一个节点 防止两个链表一样长
         */
        ListNode lastNode = null;
        /**
         * 循环短链表 两数相加之后结果重新放进长链表的结果中
         * 这样就不用创建一个新的链表 最后直接将原来的长链表头节点返回即可
         */
        while (shortNode != null) {
            sum = shortNode.val + longNode.val;
            ans = (sum + count) % 10;
            count = (sum + count) / 10;
            longNode.val = ans;
            lastNode = longNode;
            shortNode = shortNode.next;
            longNode = longNode.next;
        }
        /**
         * 防止 长短链表相加进1 长链表要是9 会一直进1 所以要循环完长链表
         */
        while (longNode != null) {
            sum = longNode.val;
            ans = (sum + count) % 10;
            count = (sum + count) / 10;
            longNode.val = ans;
            lastNode = longNode;
            longNode = longNode.next;
        }
        //长链表若是最后还进1 要在最后一个节点加一个新的节点1 count = 1
        if (count > 0) {
            lastNode.next = new ListNode(count);
        }
        return shortNodeNum == 0 ? l1 : l2;
    }

    public static int findShortNode(ListNode l1, ListNode l2) {
        int count1 = 0;
        int count2 = 0;
        while (l1 != null) {
            count1++;
            l1 = l1.next;
        }

        while (l2 != null) {
            count2++;
            l2 = l2.next;
        }
        return count1 > count2 ? 0 : 1;
    }

}
