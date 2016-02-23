package com.chapter19.learning.l_1910_s;

public interface Competitor<T extends Competitor<T>>{
    Outcome compete(T competitor);
}
