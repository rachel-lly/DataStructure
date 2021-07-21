package Heap.PriorityQueue;

/**
 * @Author: rachel-lly
 * @Date: 2021-07-21 17:04
 */
public interface Queue<E>{
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
