package com.dsa.list;

public class ListNode<E extends Comparable<E>> {
    public final E data;
    public ListNode<E> next;

    public ListNode(E data, ListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(E data) {
        this(data, null);
    }
}