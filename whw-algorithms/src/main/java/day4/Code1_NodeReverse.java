package day4;

/**
 * 实现单链表和双链表的反转
 */
public class Code1_NodeReverse {


    /**
     * 单链表的反转
     * 1 -> 2  ->3 ->4
     * head
     * 最后一个链表的指针指向是null
     * 若是想链表反转 所以开始位置的指针指向null
     * 最开始先操作链表第一个位置 他的前一个位置为null
     * Node prev = null
     * Node next = null
     * Node head = 1
     * 操作的是第一个位置 先面向第一个位置 这时head是第一个位置
     * 先记录head的下一个位置 next = head.next()
     * 然后 把head指向他的前一个位置 perv  head.next = prev
     * 这时候1位置操作完成 把head指针下移 记录当前位置为prev 为下一次准备
     * 然后 记录prev = head
     * 然后把head = next
     * 操作1位置完成 这时 prev 指向第一个位置 head 指向第二位置
     * <p>
     * 然后操作第二个位置
     * 先记录下一个位置 next = head.next()
     * 然后 把指针指向前一个位置  head.next=prev
     * 然后 第二个位置操作完成 记录当前位置为prev 为下一次准备
     * 记录 prev =head
     * 记录 head = next
     * <p>
     * 一直循环到head = null 循环结束
     */
    public static Node<Integer> reverseNode(Node<Integer> header) {
        Node<Integer> prev = null;
        Node<Integer> next = null;
        while (header != null) {
            //先把当前位置的下一个节点记录下来 以便后续的head指针的移动
            next = header.next;
            //当前位置的指针 指向前一个位置 实现指针的反转
            header.next = prev;
            //然后 记录前一个位置的指针 下移 为一个位置提供前一个位置的引用
            prev = header;
            //然后 把 head 下移 找到下一个位置 继续 指针反转
            header = next;
        }

        //最后返回 最后一个位置 因为所有位置的指针都已经反转 这时head=null prev 执行的是原来链表的最后一个位置
        //因为已经反转 所以他变成了最初的位置
        return prev;
    }

    //和单向链表思想类似
    public static DoubleNode<Integer> reverseDoubleNode(DoubleNode<Integer> head) {
        DoubleNode<Integer> prev = null;
        DoubleNode<Integer> next = null;
        while (head != null) {
            //先记录下一个位置的值 方便指针的移动
            next = head.next;
            //把当前位置的下一个指针指向前一个位置
            head.next = prev;
            //把当前位置的前一个指针指向下一个位置
            head.prev = next;
            //把记录前一个位置的指针 指向自己 以便下一个位置时 指针的调整
            prev = head;
            //移动head 指向下一个位置
            head = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(reverseNode(node1));
        DoubleNode<Integer> doubleNode1 = new DoubleNode<Integer>(1);
        DoubleNode<Integer> doubleNode2 = new DoubleNode<Integer>(2);
        DoubleNode<Integer> doubleNode3 = new DoubleNode<Integer>(3);
        DoubleNode<Integer> doubleNode4 = new DoubleNode<Integer>(4);
        doubleNode1.prev = null;
        doubleNode1.next = doubleNode2;
        doubleNode2.prev = doubleNode1;
        doubleNode2.next = doubleNode3;
        doubleNode3.prev = doubleNode2;
        doubleNode3.next = doubleNode4;
        doubleNode4.prev = doubleNode3;
        DoubleNode<Integer> node = reverseDoubleNode(doubleNode1);
        while (node != null){
            System.out.print(node.value+"  ");
            node = node.next;
        }

    }

}
