public class CustomHashmap {
    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int SIZE = 10;
    private Node[] buckets;
    public CustomHashmap() {
        buckets = new Node[SIZE];
    }
    private int getIndex(int key) {
        return key % SIZE;
    }
    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = buckets[index];
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }
    public int get(int key) {
        int index = getIndex(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1; 
    }
    public void remove(int key) {
        int index = getIndex(key);
        Node current = buckets[index];
        Node prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    public boolean containsKey(int key) {
        return get(key) != -1;
    }
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            Node current = buckets[i];
            System.out.print(i + " -> ");
            while (current != null) {
                System.out.print("[" + current.key + "," + current.value + "] ");
                current = current.next;
            }
            System.out.println();
        }
    }
    public static void main(String []args) {
    	CustomHashmap map=new CustomHashmap();
    	map.put(5, 1);
    	map.put(3, 2);
    	map.put(32,5);
    	map.put(20, 2);
    	System.out.println(map.get(3));
    	map.remove(3);
    	System.out.println(map.containsKey(30));
    	map.display();
    }
}

