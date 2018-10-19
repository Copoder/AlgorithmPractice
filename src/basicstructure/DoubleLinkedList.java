package basicstructure;

public class DoubleLinkedList<T> {
    private Node rootNode;
    private Node curLastNode;
    public int lenth = 0;

    public void add(T data) {
        Node node = new Node(data);
        lenth++;
        if (rootNode == null) {
            rootNode = node;
            curLastNode = node;
            return;
        }
        curLastNode.footer = node;
        node.header = curLastNode;
        curLastNode = node;
    }

    public int size() {
        int size = 1;
        if (rootNode == null) return 0;
        Node curNode = this.rootNode;
        while (curNode.footer != null) {
            size++;
            curNode = curNode.footer;
        }
        return size;
    }

    public T get(int i) {
        if (i > lenth - 1) throw new IndexOutOfBoundsException();
        Node node = curLastNode;
        int curIndex = lenth;
        T data;
        if (i > lenth / 2) {
            while (curIndex - 1 > i) {
                curIndex--;
                node = node.header;
            }
            data = node.data;
        } else {
            data = getBySingle(i);
        }
        return data;
    }

    public T getByfor(int i) {
        if (i > lenth - 1) throw new IndexOutOfBoundsException();
        if (i < lenth / 2) {
            Node node = rootNode;
            for (int index = 0; index < i; index++) {
                node = node.footer;
            }
            return node.data;
        } else {
            Node node = curLastNode;
            for (int index = lenth - 1; index > i; index--) {
                node = node.header;
            }
            return node.data;
        }
    }

    public T getBySingle(int index) {
        int curIndex = 0;
        if (rootNode == null) return null;
        Node node = rootNode;
        T data;
        while (curIndex < index) {
            curIndex++;
            node = node.footer;
        }
        return node.data;
    }

    public void remove(int index) {
        if (index < 0 || index > lenth) throw new IndexOutOfBoundsException();
        Node removeNode;
        if (index < lenth / 2) {
            Node node = rootNode;
            for (int i = 0; i < index; i++) {
                node = node.footer;
            }
            removeNode = node;
        } else {
            Node node = curLastNode;
            for (int i = lenth - 1; i > index; i++) {
                node = node.header;
            }
            removeNode = node;
        }
        if (removeNode != rootNode) {
            removeNode.header.footer = removeNode.footer;
        } else {
            rootNode = removeNode.footer;
        }
        removeNode.footer.header = removeNode.header;
    }

    private class Node {
        public Node header;
        public Node footer;
        public T data;

        public Node(T data) {
            this.data = data;
        }
    }
}
