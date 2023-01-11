package org.example.java8.lambda;

@FunctionalInterface
public interface GenericProcess <T,R> {
    R process(T t);
}
