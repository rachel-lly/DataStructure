/**
 * @Describtion: 链表实现 Stack
 * @Author: rachel-lly
 * @Date: 2021-07-17 17:19
 */
public class LinkedListStack<T> {

    private static class Node<T>{
        T item;
        Node<T> next;

        Node(){
            item = null;
            next = null;
        }

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        boolean isEnd(){
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.isEnd()) top = top.next;
        return result;
    }

}
