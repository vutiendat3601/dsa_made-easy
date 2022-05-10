package com.dat;

import java.util.List;

public class Queue<T> {

    // Attributes
    private final int MAX_SIZE;
    private List<T> data;
    private int headIndex;
    private int endIndex;

    // Constructors

    public Queue() {
        this(1000);
    }

    public Queue(int size) {
        MAX_SIZE = size;
        headIndex = endIndex = -1;
    }

    // Bussiness code
    public boolean push(T element) {
        if (!isFull()) {
            if (isEmpty()) {
                headIndex++;
            }
            endIndex++;
            data.add(endIndex, element);
            return true;
        }
        return false;
    }

    public T pop() {

    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return endIndex - headIndex + 1;
    }

    public boolean isEmpty() {
        return headIndex == -1 && endIndex == -1;
    }

    public boolean isFull() {
        return endIndex == MAX_SIZE - 1;
    }
}