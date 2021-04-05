package data.struct.lru;

public class DoubleList {
    // 头尾虚节点
    private Node head,tail;
    // 链表元素
    private int size;

    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size=0;
    }

    /**
     * 链表尾部添加x  时间复杂度O(1)
     * @param x
     */
    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    /**
     * 删除链表头节点 并返回该节点
     * @return
     */
    public Node removeFirst() {
        if(head.next==tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        size--;
        return first;
    }

    public int size() {
        return size;
    }
}
