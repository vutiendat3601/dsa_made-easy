import java.util.List;

public class SingleLinkedList<T> {
    // Attributes
    public T value;
    public SingleLinkedList<T> next;

    // Constructors
    public SingleLinkedList() {
    }

    public SingleLinkedList(T value) {
        this.value = value;
    }

    public SingleLinkedList(T value, SingleLinkedList<T> next) {
        this.value = value;
        this.next = next;
    }

    // Bussiness code

    public void traverList(SingleLinkedList<T> head) {
        if (head == null) {
            return;
        }
        System.out.print("[");
        while (head.next != null) {
            System.out.print(head.value + ", ");
            head = head.next;
        }
        System.out.println(head.value + "]");
    }

    public SingleLinkedList<T> addAtHead(SingleLinkedList<T> head, T value) {
        // Create new node
        SingleLinkedList<T> node = new SingleLinkedList<>(value);
        if (head == null) {
            return node;
        }

        // Assign head for next of new node
        node.next = head;

        return node;
    }

    public void addAfter(SingleLinkedList<T> posNode, T value) {
        // Create new node
        SingleLinkedList<T> node = new SingleLinkedList<>(value);
        if (posNode == null) {
            return;
        }
        node.next = posNode.next;
        posNode.next = node;
    }

    public void addAtEnd(SingleLinkedList<T> head, T value) {
        SingleLinkedList<T> node = new SingleLinkedList<>(value);
        if (head == null) {
            return;
        }
        while (head.next != null) {
            head = head.next;
        }
        head.next = node;
    }

    public SingleLinkedList<T> removeAtHead(SingleLinkedList<T> head) {
        if (head == null || head.next == null) {
            return null;
        }
        return head.next;
    }

    public void removeAfter(SingleLinkedList<T> posNode) {
        if (posNode == null || posNode.next == null) {
            return;
        }
        posNode.next = posNode.next.next;
    }

    public void removeAtEnd(SingleLinkedList<T> head) {
        if (head == null) {
            return;
        }
        SingleLinkedList<T> pre = head;
        head = head.next;
        while (head.next != null) {
            pre = head;
            head = head.next;
        }
        pre.next = null;
    }

    // Main
    public static void main(String[] args) {
        SingleLinkedList<Integer> third = new SingleLinkedList<>(3);
        SingleLinkedList<Integer> second = new SingleLinkedList<>(2, third);
        SingleLinkedList<Integer> head = new SingleLinkedList<>(1, second);
        head.traverList(head);
        head.addAfter(second, 3);
        head.removeAtEnd(head);
        head.removeAfter(second);
        head.traverList(head);
    }

}
