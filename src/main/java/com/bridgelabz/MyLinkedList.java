package com.bridgelabz;


import java.awt.font.TextMeasurer;

public class MyLinkedList<K> {
    public INode head;
    public INode tail;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public void append(INode<K> myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail == null) {
            this.tail = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    public void add(INode newNode ) {
        if (this.tail == null)
            this.tail = newNode ;
        if (this.head == null)
            this.head = newNode ;
        else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }
    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }
    public INode pop(){
        INode tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }
    public INode popLast(){
        INode tempNode = this.head;
        while(!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = tempNode.getNext();
        return tempNode;
    }
    public INode search(K key){
        INode tempNode = this.head;
        while (tempNode != null && tempNode.getNext() != null) {
            if (tempNode.getKey().equals(key)) {
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return null;
    }
    public INode delete(K key) {
        INode<K> tempNode = this.head;
        while (tempNode.getNext().getKey()!= key ){
            tempNode = tempNode.getNext();
        }
        INode deleteNode = tempNode.getNext();
        tempNode.setNext(tempNode.getNext().getNext());
        return deleteNode;
    }
    public void size(){
        int size=0;
        INode tempNode = this.head;
        while(!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
            size++;
        }
        System.out.println("Size is: " + (size+2));
    }
    public void printMyNodes() {
        StringBuffer myNodes = new StringBuffer("My Nodes: ");
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            myNodes.append(tempNode.getKey());
            if (!tempNode.equals(tail)) myNodes.append("->");
            tempNode = tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }

    @Override
    public String toString() {
        return "MyLinkedListNodes{" + head + '}';
    }
}