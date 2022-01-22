package day4;

/**
 * 用双向链表实现双向队列
 */
public class Code3_Queue {

    public static void main(String[] args) {
        MyDoubleQueue<Integer> queue = new MyDoubleQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.addBeforeTop(4);
        queue.addBeforeTop(5);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static class MyDoubleQueue<T>{
        public int size;
        public DoubleNode<T> head;
        public DoubleNode<T> tail;

        public void add(T value){
            if (head == null){
                head = new DoubleNode<T>(value);
                tail = head;
            } else {
                DoubleNode<T> node = new DoubleNode<T>(value);
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public void addBeforeTop(T value){
            if (head == null){
                head = new DoubleNode<T>(value);
                tail = head;
            } else {
                DoubleNode<T> node = new DoubleNode<T>(value);
                node.next = head;
                head = node;
            }
            size++;
        }

        public T poll(){
            if (head == null){
                return null;
            }
            DoubleNode<T> prev = null;
            DoubleNode<T> next = null;
            next = head.next;
            head.next = prev;
            head.prev = prev;
            prev = head;
            head = next;
            size--;
            return prev.value;
        }

    }



}
