package com.iamsrahimi.recapexcercises.generic;

import java.util.Objects;

public class Wrapper<T> {
    private T value;

    public Wrapper(T value) {
        this.value = value;
    }

    public boolean equalsByValue(Wrapper<T> other) {
        return Objects.equals(value, other.value);
    }
}
