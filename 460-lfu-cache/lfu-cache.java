import java.util.HashMap;
import java.util.Map;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    private final int capacity;
    private int minFreq;

    private Map<Integer, Node> keyToNode;
    private Map<Integer, DoublyLinkedList> freqToList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key))
            return -1;

        Node node = keyToNode.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        if (keyToNode.size() == capacity) {
            DoublyLinkedList minList = freqToList.get(minFreq);
            Node removed = minList.removeLast();
            keyToNode.remove(removed.key);
        }

        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);

        DoublyLinkedList list = freqToList.getOrDefault(1, new DoublyLinkedList());
        list.addFirst(newNode);
        freqToList.put(1, list);

        minFreq = 1;
    }

    private void updateFrequency(Node node) {
        int freq = node.freq;
        DoublyLinkedList oldList = freqToList.get(freq);
        oldList.remove(node);

        if (freq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList = freqToList.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addFirst(node);
        freqToList.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
