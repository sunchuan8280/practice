package coding;

/**
 * Created by chuan on 2018/11/9.
 */
public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}