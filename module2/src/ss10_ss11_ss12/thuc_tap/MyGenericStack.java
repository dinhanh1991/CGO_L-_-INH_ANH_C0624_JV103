package ss10_ss11_ss12.thuc_tap;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList();
    }public void push(T el) {
        stack.addFirst(el);
    }
    public T pop() {
        if(stack.isEmpty()) {
           throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    public int size() {
        return stack.size();
    }
    public boolean isEmpty() {
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
