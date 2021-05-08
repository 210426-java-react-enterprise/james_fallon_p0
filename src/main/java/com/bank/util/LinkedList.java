package com.bank.util;




public class LinkedList<T> implements List<T>, Queue<T>{
    private int size;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public void add(T data) {
        if(data == null){
            throw new IllegalArgumentException ("This linked list does not accept null values");
        }

        Node<T> newNode = new Node<T>(data);
        if(head == null){
            tail = head = newNode;
        }
        else{
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
        }

        size++;
    }

    @Override
    public T remove(T data) {
        Node<T> runner = new Node<> (data);

        for(Node<T> temp = head; temp != null; temp = temp.nextNode){
            if(temp.getData() == runner.getData()){
                if(temp == head){
                    head=temp.nextNode;
                    head.prevNode = null;
                }
                else if(temp == tail){
                    tail=temp.prevNode;
                    temp.nextNode = null;
                }
                else {
                    temp.nextNode.prevNode = temp.prevNode;
                    temp.prevNode.nextNode = temp.nextNode;
                }
                size--;
                break;
            }

        }
        return data;

    }

    @Override
    public T get(int index) {
        if(index < 0 || index > size){
            throw new IllegalArgumentException ("This provided index would be out of bounds");
        }

        Node<T> runner = head;
        for(int i = 0; i < size; i++){
            if(i == index){
                return runner.data;
            }
            runner = runner.nextNode;
        }
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }



    private static class Node<T>{
        T data;
        Node<T> nextNode;
        Node<T> prevNode;


        Node(T data){
            this.data = data;
        }

        public Node(T data, Node<T> nextNode, Node<T> prevNode) {
            this.data = data;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }

        public T getData() {
            return data;
        }
    }
}
