package Queue;

/**
 * @Author: rachel-lly
 * @Date: 2021-07-21 16:52
 */
public interface QueueMethod<T>{
    T DeQueue();
    void enQueue(T t);
}
