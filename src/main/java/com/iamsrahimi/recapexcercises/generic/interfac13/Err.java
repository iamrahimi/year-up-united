package com.iamsrahimi.recapexcercises.generic.interfac13;

public class Err<T, E> implements Result<T, E> {
    private final E error;

    public Err(E error) {
        this.error = error;
    }

    public E error() {
        return error;
    }
}
