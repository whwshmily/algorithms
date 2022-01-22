package day4;

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
public class Code4_Reverse {


    //      Definition for singly-linked list.
    public static class ListNode {
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /**
     * 根据头节点往后的几个节点 加上头节点
     * 假设找三个 往后跳两下就可以了
     */
    public static ListNode findPointLastNode(ListNode head, int skip) {
        while (head != null && --skip > 0) {
            head = head.next;
        }
        return head;
    }


    /**
     * 根据老师的思路 自己的解法 用到的是递归 不是很好
     * 假设链表   1->2->3->4->5->6->7->8 k=3
     * 思想 把链表切开 要几个就切开几个 然后进行单链表反转 每一个返回头节点
     * 最后连成一个新的链表 返回头节点
     * <p>
     * 第一次 1 2 3
     * 先 记下头节点的位置 因为链表反转 记下的头节点的位置 是反转后的链表尾节点的位置
     * 因为每一次返回的是调整后的头节点的位置 然后记下的尾节点的下一个节点就是下一次方法
     * 返回的头节点 这样就把整个链表穿起来了
     * <p>
     * 然后调整链表反转
     * <p>
     * 反转完成之后 这一段链表调整完成 切开
     * 然后把原来链表下一个位置当作头节点继续传入方法 继续重复操作 直到整个链表调整完成
     * (这个每一段的操作都会 返回调整后的头节点 然后把记录的头节点(反转后的尾节点)连接他的下一个节点)
     * 返回头节点
     * 调整后 3 2 1     1是记录的节点 是调整后的尾节点
     * 返回现有的头节点 3
     * 然后把 原链表3的下一个节点 当作头节点继续这个操作
     * 4 5 6 调整后会把6 返回 这时1的下一个就是6 串起来  这样整个链表就串起来了
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode lastNode = findPointLastNode(head, k);
        if (lastNode == null) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        //记录调整前的头节点 是调整后的尾节点
        ListNode first = head;
        ListNode end = lastNode.next;
        //单链表反转
        while (head != end) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        /**
         * 单链表调整完成后 prev 就是原来的尾节点 调整后的头节点 返回出去
         * head 的指针会指向原来链表位置 需要调整的链表的下一个位置
         * 正好可以进行递归调整
         */

        /**
         * 因为返回的都是调整后的头节点 这样正好可以把链表重新串起来
         */
        first.next = reverseKGroup(head, k);
        return prev;
    }

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
        System.out.println(reverseKGroup(node1, 2));
    }


}
