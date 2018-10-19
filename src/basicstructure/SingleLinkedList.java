package basicstructure;

public class SingleLinkedList<T> {
    private Node node;
    private int size;
    private Node header;
    private Node lastNode;

    public SingleLinkedList() {

    }

    public void add(T data) {
        Node currNode = header;
        if (size == 0) {
            header = new Node(data);
        } else {
            for (int i = 0; i < size - 1; i++) {
                //获取当前最后的节点
                currNode = currNode.nextNode;
            }
            currNode.nextNode = new Node(data);
        }
        size++;
    }

    public void superAdd(T data) {
        if (size == 0) {
            header = new Node(data);
            lastNode = header;
        } else {
            lastNode.nextNode = new Node(data);
            lastNode = lastNode.nextNode;
        }
        size++;
    }

    public void remove(int position) {
        if (position > size) return;
        Node currNode = header;
        for (int i = 0; i < position; i++) {
            currNode = currNode.nextNode;
        }
        size--;
        currNode.nextNode = currNode.nextNode.nextNode;
    }

    public T get(int position) {
        Node currNode = header;
        for (int i = 0; i < position; i++) {
            currNode = currNode.nextNode;
        }
        return currNode.data;
    }

    public int size() {
        return size;
    }

    public void insert(int position) {

    }

    private class Node {
        public Node nextNode;

        public T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
