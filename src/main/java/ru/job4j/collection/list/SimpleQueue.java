package ru.job4j.collection.list;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> one = new SimpleStack<>();
    private final SimpleStack<T> two = new SimpleStack<>();
    private int size = 0;

    public T poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < size; i++) {
            two.push(one.pop());
        }
        T result = two.pop();
        size--;
        for (int i = 0; i < size; i++) {
            one.push(two.pop());
        }
        return result;
    }

    public void push(T value) {
      one.push(value);
      size++;
    }
}