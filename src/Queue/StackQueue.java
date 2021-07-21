package Queue;

import java.util.Stack;

/**
 * @Author: rachel-lly
 * @Date: 2021-07-21 16:52
 */
public class StackQueue<T> implements QueueMethod<T> {

    Stack<T> stackA = new Stack<>();
    Stack<T> stackB = new Stack<>();

    //入队
    public void enQueue(T t) {
        stackA.push(t);
    }

    //出队
    public T DeQueue() {
        if (stackB.isEmpty()) {
            while (stackA.size() > 0) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }
}
