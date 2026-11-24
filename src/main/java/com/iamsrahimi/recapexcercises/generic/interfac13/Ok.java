package com.iamsrahimi.recapexcercises.generic.interfac13;

public class Ok<T, E> implements Result<T, E> {
    private final T value;

    public Ok(T value) {
        this.value = value;
    }

    public T value() {
        return value;
    }
}
