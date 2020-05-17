package com.dsa.list;

public class LinkedList<E extends Comparable<E>> {

	ListNode<E> head = null;
	int count = 0;

	public LinkedList(ListNode<E> head) {
		this.head = head;
	}

	public LinkedList() {
	}

	public void addAsFirstNode(E data) {
		this.head = new ListNode<>(data, head);
		count++;
	}

	public void addAsLastNode(E data) {
		if (head == null) {
			head = new ListNode<E>(data);
		} else {
			ListNode<E> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode<>(data);
		}
		count++;
	}

	public void print() {
		ListNode<E> current = head;
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
			ListNode<E> current = head;
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
			head = new ListNode<E>(data, head);
		} else {
			ListNode<E> current = head;
			int ps = 0;
			while (++ps != pos && current.next != null) {
				current = current.next;
			}
			ListNode<E> newNode = new ListNode<>(data, current.next);
			current.next = newNode;
		}
		count++;
	}

	public void deleteNodeAtPos(int pos) {
		ListNode<E> current = head;
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
		ListNode<E> slow = head, fast = head;

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

