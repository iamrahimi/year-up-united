package com.iamsrahimi.recapexcercises.generic;

public class OptionalLite <T> {
    private T value;

    private OptionalLite(T value) {
        this.value = value;
    }

    public static <T> OptionalLite<T> of(T v) {
        return new OptionalLite<>(v);
    }

    public static <T> OptionalLite<T> empty() {
        return new OptionalLite<>(null);
    }

    public boolean isPresent() {
        return value != null;
    }

    public T get() {
        return value;
    }

}
