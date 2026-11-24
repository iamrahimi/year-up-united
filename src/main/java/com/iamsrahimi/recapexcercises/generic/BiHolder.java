package com.iamsrahimi.recapexcercises.generic;

public class BiHolder<A, B> {
    private A first;
    private B second;

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public BiHolder(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public BiHolder<B, A> swap() {
        return new BiHolder<>(second, first);
    }


}
