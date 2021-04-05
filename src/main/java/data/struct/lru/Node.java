package data.struct.lru;

public class Node {
    public int key,value;
    public Node next,prev;
    public Node(int k, int v) {
        this.key = k;
        this.value = v;
    }
}
