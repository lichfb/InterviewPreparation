package org.example.findFacrotial;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(factorialNumberRecursion(6));

    }
    private static BigInteger factorialNumberRecursion(int number){
        /**
         * i know how working Recursion
         * but didnt understand .valueOf() method and how it return 720
         * and why inside.valueOf() is one
         */
        if (number==0){
            return BigInteger.valueOf(1);
        }
        else if (number < 0) {
            throw new ArithmeticException();
        }

        return BigInteger.valueOf(number).multiply(factorialNumberRecursion(number-1));
    }
    private static int factorialNumberWithLoop(int number){
        int result = 1;
        for (int i = number; i >= 1; i--){
            result*=i;
        }
        return result;
    }
    public static int factorialNumberWithStream(int number){
        return Stream.iterate(1,i -> i < number, i -> i + 1) //with Java 9
                .reduce(1, (x,y) -> x*y);
    }
    public static int factorialNumberWithStream2(int number){
        return Stream.iterate(1, i -> i + 1)
                .limit(number)
                .reduce(1, (x,y) -> x * y);
    }
    public static int factorialNumberWithStream3(int number){
        return IntStream.range(1, number)
                .reduce(1,(x,y) -> x*y);
    }
}
/*
Question-2 Find Factorial

Write a method that returns the factorial number of any given number.
Factorial: Factorial of a non-negative integer, is multiplication of all positive integers smaller than or equal to n.
For example, factorial of 6 is 6*5*4*3*2*1 which is 720.
 */
