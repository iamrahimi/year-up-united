package com.iamsrahimi.recapexcercises.generic.interfac13;

public class Results {
    public static <T, E> Result<T, E> ok(T v) {
        return new Ok<>(v);
    }

    public static <T, E> Result<T, E> err(E e) {
        return new Err<>(e);
    }
}