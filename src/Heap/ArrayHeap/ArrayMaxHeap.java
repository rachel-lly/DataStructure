package Heap.ArrayHeap;

import Heap.ArrayHeap.Array;

/**
 * @Author: rachel-lly
 * @Date: 2021-07-21 16:56
 */
public class ArrayMaxHeap <E extends Comparable<E>> {
    private Array<E> data;

    public ArrayMaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public ArrayMaxHeap(){
        data = new Array<>();
    }

    //堆里的元素个数
    public int size(){
        return data.getSize();
    }

    //堆是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //根据一个元素的索引，获取他父亲索引
    private int parent(int index){
        if (index == 0){
            throw new IllegalArgumentException("index - 0 does't have parent.");
        }
        return (index - 1) / 2;
    }

    //根据一个元素的索引，获取他右孩子的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    //根据一个元素的索引，获取他左孩子的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    //堆中添加元素
    public void add(E e)
    {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //上浮操作
    private void siftUp(int i){
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0)
        {
            //交换位置
            data.swap(i,parent(i));
            i = parent(i);
        }
    }

    //堆中最大元素
    public E findMax(){
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("堆为空，无法查看值");
        }
        return data.get(0);
    }

    //取出堆顶元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    //下沉操作
    private void siftDown(int i) {
        //比较到他左右孩子那个比他大进行交换操作
        while (leftChild(i) < data.getSize()) {
            int j = leftChild(i);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {//右节点
                j = rightChild(i);
            }
            if (data.get(i).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(i,j);
            i = j;
        }
    }

}
