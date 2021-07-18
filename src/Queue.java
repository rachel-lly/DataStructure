import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: rachel-lly
 * @Date: 2021-07-18 17:49
 */
public class Queue {


}

interface QueueMethod<T>{

    T DeQueue();
    void enQueue(T t);
}


class LinkedListQueue<T> implements QueueMethod<T>{

    List<T> list = new ArrayList<>();
    int index = 0;  //下标

    //入队
    public void enQueue(T t){
        list.add(t);
        index++;
    }

    //出队
    public T DeQueue(){
        if(!list.isEmpty()){
            index--;
            return list.remove(0);
        }
        return null;
    }
}

class StackQueue<T> implements QueueMethod<T>{
    
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
