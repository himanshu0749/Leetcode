import java.util.Deque;
import java.util.LinkedList;

public class MyCircularDeque {
    private Deque<Integer> dq;
    private int cap;

    public MyCircularDeque(int k) {
        cap = k;
        dq = new LinkedList<>();
    }

    public boolean insertFront(int value) {
        if (dq.size() < cap) {
            dq.addFirst(value);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (dq.size() < cap) {
            dq.addLast(value);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!dq.isEmpty()) {
            dq.removeFirst();
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!dq.isEmpty()) {
            dq.removeLast();
            return true;
        }
        return false;
    }

    public int getFront() {
        if (!dq.isEmpty()) {
            return dq.peekFirst();
        }
        return -1;
    }

    public int getRear() {
        if (!dq.isEmpty()) {
            return dq.peekLast();
        }
        return -1;
    }

    public boolean isEmpty() {
        return dq.isEmpty();
    }

    public boolean isFull() {
        return dq.size() == cap;
    }
}
