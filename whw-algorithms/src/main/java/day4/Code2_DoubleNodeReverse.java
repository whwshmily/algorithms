package day4;

/**
 * 用单向链表实现队列和栈
 */
public class Code2_DoubleNodeReverse {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.getSize());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.getSize());
        System.out.println("===============================");
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
    }


    public static class MyStack<T>{
        public int size;
        public Node<T> head;

        public void add(T value){
            if (head == null){
                head = new Node<T>(value);
            } else {
                Node<T> node = new Node<T>(value);
                node.next = head;
                head = node;
            }
            size++;

        }

        public T poll(){
            if (head == null){
                return null;
            }
            size--;
            Node<T> prev = null;
            Node<T> next = null;
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            return prev.value;
        }

    }

    public static class MyQueue<T> {
        public int size;
        public Node<T> head;
        public Node<T> tail;

        public void add(T value) {
            if (head == null) {
                head = new Node<T>(value);
                tail = head;
            } else {
                Node<T> node = new Node<T>(value);
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public int getSize() {
            return size;
        }

        public T poll() {
            if (head == null) {
                return null;
            }
            --size;
            Node<T> prev = null;
            Node<T> next = null;
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            if (head == null) tail = null;
            return prev.value;
        }

        public T peek() {
            if (head == null) {
                return null;
            }
            return head.value;
        }

    }

}
