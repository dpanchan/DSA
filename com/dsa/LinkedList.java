package com.dsa;

public class LinkedList<E extends Comparable<E>> {

	Node<E> head = null;
	int count = 0;

	public LinkedList(Node<E> head) {
		this.head = head;
	}

	public LinkedList() {
	}

	public void addAsFirstNode(E data) {
		this.head = new Node<>(data, head);
		count++;
	}

	public void addAsLastNode(E data) {
		if (head == null) {
			head = new Node<E>(data);
		} else {
			Node<E> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node<>(data);
		}
		count++;
	}

	public void print() {
		Node<E> current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public int length() {
		return count;
	}

	public void deleteFirstNode() {
		if (head != null) {
			head = head.next;
			count--;			
		}
	}

	public void deleteLastNode() {
		if (head == null) {
			System.out.println("empty Linked List");
		} else if (head.next == null) {
			head = null;
		} else {
			Node<E> current = head;
			while (current.next.next != null) {
				current = current.next;
			}
			current.next = null;
		}
		count--;
	}

	public void addNodeAtPos(E data, int pos) {
		if (pos < 0) {
			System.out.println("Please provide positive integer position");
			return;
		}

		if (pos > count) {
			System.out.println("Please select position value between range 0 to " + count);
			return;
		}
		
		if (pos == 0) {
			head = new Node<E>(data, head);
		} else {
			Node<E> current = head;
			int ps = 0;
			while (++ps != pos && current.next != null) {
				current = current.next;
			}
			Node<E> newNode = new Node<>(data, current.next);
			current.next = newNode;
		}
		count++;
	}

	public void deleteNodeAtPos(int pos) {
		Node<E> current = head;
		if (pos == 0) {
			head = head.next;
		} else {
			int ps = 0;
			while (++ps != pos && current.next != null) {
				current = current.next;
			}
			current.next = current.next.next;
		}
	}

	public LinkedList<E> splitLists() {
		Node<E> slow = head, fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			if (fast != null) {
				slow = slow.next;
			}
		}
		if (slow != null) {
			fast = slow.next;
			slow.next = null;
		}
		return new LinkedList<E>(fast);
	}

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.addAsLastNode(7);
		ll.addAsLastNode(6);
		ll.addAsFirstNode(5);
		ll.addAsFirstNode(9);
		ll.deleteFirstNode();
		ll.deleteLastNode();
		ll.addNodeAtPos(3, 0);
		ll.addNodeAtPos(4, 0);
		ll.addNodeAtPos(5, 0);
		ll.addNodeAtPos(6, 1);
		ll.deleteNodeAtPos(4);
		var l2 = ll.splitLists();
		ll.print();
		l2.print();
	}
}

class Node<E extends Comparable<E>> {
	public final E data;
	public Node<E> next;

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}

	public Node(E data) {
		this(data, null);
	}
}
