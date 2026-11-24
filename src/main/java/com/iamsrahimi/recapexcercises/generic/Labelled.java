package com.iamsrahimi.recapexcercises.generic;

public class Labelled <T> {
    private String label;
    private T value;

    public Labelled(String label, T value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String toString() {
        return label + "=" + value;
    }
}
