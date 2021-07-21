package Heap.ArrayHeap;

/**
 * @Author: rachel-lly
 * @Date: 2021-07-21 16:55
 */
public class Array<E> {
    private E[] data;

    private int size;

    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        size = 0;
    }
    //无参数构造函数
    public Array() {
        this(10);
    }

    //获取数组的个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //添加最后一个元素
    public void addLast(E e) {
        add(size,e);
    }

    //添加第一个元素
    public void addFirst(E e){
        add(0,e);
    }

    //获取inde索引位置的元素
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed,index is illegal");
        }
        return data[index];
    }

    public void set(int index,E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed,index is illegal");
        }
        data[index] =  e;
    }

    //获取最后一个元素
    public E getLast(){
        return this.get(size - 1);
    }

    //获取第一个元素
    public E getFirst(){
        return this.get(0);
    }


    //添加元素
    public void add(int index,E e){
        if (index > size || index < 0){
            throw new IllegalArgumentException("add failed beceause index > size or index < 0,Array is full.");
        }
        if (size == data.length){
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;

    }

    //扩容数组
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E[] getData() {
        return data;
    }

    //查找数组中是否有元素e
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //根据元素查看索引
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //删除某个索引元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("detele is fail,index < 0 or index >= size");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;
        if (size < data.length / 2){
            resize(data.length / 2);
        }
        return  ret;
    }

    //删除首个元素
    public E removeFirst(){
        return this.remove(0);
    }

    //删除最后一个元素
    public E removeLast(){
        return this.remove(size - 1);
    }

    //从数组删除元素e
    public void removeElemen(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }

    }

    public void swap(int i,int j){
        if (i < 0 || i >= size || j < 0 || j > size) {
            throw new IllegalArgumentException("索引越界");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;

    }
}
