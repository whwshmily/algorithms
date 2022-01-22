package day4;

/**
 * 双链表
 */
public class DoubleNode<T> {
    public T value;
    public DoubleNode<T> prev;
    public DoubleNode<T> next;

    public DoubleNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "value=" + value +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
