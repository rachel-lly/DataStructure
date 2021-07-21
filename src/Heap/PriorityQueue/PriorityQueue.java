package Heap.PriorityQueue;

import Heap.ArrayHeap.ArrayMaxHeap;

/**
 * @Author: rachel-lly
 * @Date: 2021-07-21 17:04
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{

    private ArrayMaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new ArrayMaxHeap<>();
    }

    public PriorityQueue(ArrayMaxHeap<E> maxHeap) {
        this.maxHeap = maxHeap;
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
