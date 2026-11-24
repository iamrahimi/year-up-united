package com.iamsrahimi.recapexcercises.generic;

public class StoreOnce <T> {
    private T stored;

    public void put(T v) {
        if (stored == null) {
            stored = v;
        }
    }

    public T get() {
        return stored;
    }
}
