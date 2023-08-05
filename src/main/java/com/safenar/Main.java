package com.safenar;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Gilithrimm
 */
public class Main {

    private static long iterations;

    public static long getIterations() {
        return iterations;
    }

    public static void setIterations(long iterations) {
        Main.iterations = iterations;
    }
    //it just won't be my code without this
    public static void println(Object word){
        System.out.println(word);
    }

    public static boolean isPalindromic(BigInteger num){
        return num.equals(reverse(num));
    }

    //found on internet & turned into function
    public static BigInteger reverse(BigInteger num) {
        BigInteger reverse=BigInteger.ZERO;
        while(!num.equals(BigInteger.ZERO)){
            BigInteger remainder = num.mod(BigInteger.valueOf(10));
            reverse = remainder.add(reverse.multiply(BigInteger.valueOf(10)));
            num = num.divide(BigInteger.valueOf(10));
        }
        return reverse;
    }

    //hope it makes its job
    public static BigInteger addReversed(BigInteger num){
        BigInteger adder;
        do {
            adder=num.add(reverse(num));
            num=adder;
            //for checking
            println(num);
            setIterations(getIterations()+1);
        }while (!isPalindromic(num));
        return num;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        println("Write number you want to get");
        BigInteger reversed = addReversed(sc.nextBigInteger());
        println(reversed);
        System.out.printf("It took %d iteration(s).\n",getIterations());
        println(reversed.toString().length());
    }


}
