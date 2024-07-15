package InMemoryCache.eviction;

import java.util.HashMap;
import java.util.Map;

class Node {
    Node prev;
    Node next;
    String key;

    public Node(String key) {
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}

// Implement using a hashmap and a DLL.
// Recent at the front.
// oldest at the end.
public class LRUEviction implements IEvictionPolicy {
    Map<String, Node> hashMap;
    Node head;
    Node tail;

    public LRUEviction() {
        this.hashMap = new HashMap<>();
        this.head = new Node("");
        this.tail = new Node("");
        this.head.next = tail;
        this.head.prev = null;

        this.tail.prev = head;
        this.tail.next = null;
    }

    @Override
    public String evict() {
        Node lastNode = this.tail.prev;
        removeNode(lastNode);
        return lastNode.key;
    }

    @Override
    public void moveToTheFront(String key) {
        Node curNode = this.hashMap.get(key);
        if (curNode == null) {
            add(key);
            return;
        }

        removeNode(curNode);
        addNode(curNode);
    }

    @Override
    public void add(String key) {
        addNode(new Node(key));
    }

    // at the front
    public void addNode(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;

        this.hashMap.put(node.key, node);
    }

    public void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }
}
