package linkedlistpw;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;
    void insertAtEnd(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
        size++;
    }
    void deleteAt(int idx) {
    	if(idx == 0) {
    		head = head.next;
    		size--;
    		return;
    	}
    	Node temp = head;
    	for(int i = 1;i<=idx-1;i++) {
    		temp = temp.next;
    	}
    	temp.next = temp.next.next;
    	tail = temp;
    	size--;
    }
    
    void insertAtHead(int val) {
    	Node temp = new Node(val);
    	if(head == null) { // empty list
    		head = temp;
    		tail = temp;
    	}else { //non empty list
    		temp.next = head;
    		head = temp;
    	}
    	size++;
    }
    
    void insertAt(int idx, int val) {
    	Node t = new Node(val);
    	Node temp = head;
    	if(idx == size) {
    		insertAtEnd(val);
    		return;
    	}
    	else if(idx == 0) {
    		insertAtHead(val);
    		return;
    	}
    	else if(idx<0  || idx>size) {
    		System.out.println("Wrong index");
    		return;
    	}
    	for(int i = 1;i<=idx-1;i++) {
    		temp = temp.next;
    	}
    	t.next = temp.next;
    	temp.next = t;
    	size++;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " "); // Use print instead of println
            temp = temp.next;
        }
        System.out.println();
    }
    int getAt(int idx) {
    	if(idx<0  || idx>size) {
    		System.out.println("Wrong index");
    		return -1;
    	}
    	Node temp = head;
    	for(int i = 1;i<=idx;i++) {
    		temp = temp.next;
    	}
    	return temp.data;
    }
//    int size() { // O(n)
//    	int count = 0;
//    	 Node temp = head;
//         while (temp != null) {
//             count++;
//             temp = temp.next;
//         }
//         return count;
//    }
}

public class Implementation {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(4); // 4
      //  ll.display();
        ll.insertAtEnd(5); // 4 -> 5
     //   ll.display();
//        System.out.println(ll.size());
        ll.insertAtEnd(12); // 4 -> 5 -> 12
      //  ll.display();
        ll.insertAtHead(13); // 13 -> 4 -> 5 -> 12
       // ll.display();
//        ll.insertAt(2, 10); // 13 -> 4 -> 10 -> 5 -> 12
//        ll.display();
        ll.insertAt(4,10); // 13 -> 4 -> 5 -> 12 -> 10
        ll.display();
//        System.out.println(ll.head.data);
//        System.out.println(ll.tail.data);
        ll.insertAt(0,100); // 100 -> 13 -> 4 -> 5 -> 12 -> 10
        ll.display();
        ll.deleteAt(0);//  100 -> 13 -> 4 -> 5 -> 10
        ll.display();
        System.out.println(ll.tail.data);
//        System.out.println(ll.getAt(-8));
//        System.out.println(ll.size);
    }
}
