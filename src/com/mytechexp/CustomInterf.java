package com.mytechexp;

public interface CustomInterf {

    void print();
    default void printSomething()
    {
        System.out.println("Default method executed");
    }
}
