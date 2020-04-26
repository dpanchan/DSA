package com.dsa;

public class LinkedList<E extends Comparable<E>> {

	Node<E> head = null;
	int count = 0;

	public LinkedList(Node<E> head2) {
		this.head = head2;
	}

	public LinkedList() {
		this.head = null;
	}

	public void addAsFirstNode(E data) {
		head = new Node<E>(data, head);
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
			current.next = new Node<E>(data);
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
		head = head.next;
		count--;
	}

	public void deleteLastNode() {
		Node<E> current = head;
		if (current == null) {
			System.out.println("It is empty Linked List");
		} else if (current.next == null) {
			head = null;
		} else {
			while (current.next.next != null) {
				current = current.next;
			}
			current.next = null;
		}
		count--;
	}

	public void addNodePos(E data, int pos) {

		Node<E> newNode = new Node<>(data);
		Node<E> current = head;
		if (pos >= 0) {
			if (pos > count) {
				System.out.println("Please select position value between range 0 to " + count);
			} else {
				int ps = 0;
				if (ps == pos) {
					head = new Node<E>(data, head);
				} else {
					while (++ps != pos && current.next != null) {
						current = current.next;
					}
					newNode.next = current.next;
					current.next = newNode;
				}
				count++;
			}
		} else {
			System.out.println("Please provide positive integer position");
		}
	}

	public void deleteNodePos(int pos) {

		Node<E> current = head;
		int ps = 0;

		if (ps == pos) {
			head = head.next;
		} else {
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
		ll.addNodePos(3, 0);
		ll.addNodePos(4, 0);
		ll.addNodePos(5, 0);
		ll.addNodePos(6, 1);
		ll.deleteNodePos(4);
		var l2 = ll.splitLists();
		ll.print();
		l2.print();
	}
}

class Node<E extends Comparable<E>> {

	E data;
	Node<E> next;

	public Node(E data, Node<E> next) {

		this.data = data;
		this.next = next;
	}

	public Node(E data) {
		this.data = data;
		this.next = null;
	}
}
