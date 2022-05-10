package com.dat;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    // Attributes
    private final int MAX_SIZE;
    private List<T> data;
    private int curIndex;

    // Constructors

    public Stack() {
        this(1000);
    }

    public Stack(int size) {
        curIndex = -1;
        MAX_SIZE = size;
        data = new ArrayList<>();
    }

    // Bussiness code

    public boolean push(T element) {
        if (isFull()) {
            return false;
        }
        curIndex++;
        data.add(element);
        return true;
    }

    public boolean isFull() {
        return curIndex == MAX_SIZE - 1;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public T top() {
        if (curIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        return data.get(curIndex);
    }

    public T pop() {
        if (curIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        T res = data.get(curIndex);
        data.remove(curIndex);
        curIndex--;
        return res;
    }

    public int size() {
        return data.size();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(3);
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("TOP = " + s.top());
        System.out.println("TOP = " + s.pop());
        System.out.println("TOP = " + s.pop());
        System.out.println("TOP = " + s.pop());
        System.out.println("TOP = " + s.pop());
    }
}
