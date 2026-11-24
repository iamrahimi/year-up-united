package com.iamsrahimi.recapexcercises.generic;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}