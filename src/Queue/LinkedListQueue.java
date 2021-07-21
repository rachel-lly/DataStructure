package Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: rachel-lly
 * @Date: 2021-07-21 16:53
 */
public class LinkedListQueue<T> implements QueueMethod<T> {

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

