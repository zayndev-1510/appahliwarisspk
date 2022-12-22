package com.it015.spkhakimwaris.utils;

import java.math.BigInteger;

public class LCM {
    public int findLCM(int arr[]) {
        if(arr.length>0){
            int result = arr[0];
            for (int i = 1; i < arr.length; i++) {
                result = findLCM(result, arr[i]);
            }
            return result;
        }
        return 0;
    }

    public int findLCM(int a, int b) {
        int max, min, lcm = 1, x;
        if (a > b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        for (int i = 1; i < max; i++) {
            x = max * i;
            if (x % min == 0) {
                lcm = x;
                break;
            }
        }

        return lcm;
    }

    public  String convertype(double decimal){
        int digitsAfterPoint = String.valueOf(decimal).length() - String.valueOf(decimal).indexOf('.')+1; // get the count of digits after the point // for example 0.75 has two digits
        BigInteger numerator  = BigInteger.valueOf((long)(decimal*Math.pow(10, digitsAfterPoint))); // multiply 0.75 with 10^2 to get 75
        BigInteger denominator = BigInteger.valueOf((long)(Math.pow(10, digitsAfterPoint)));       // 10^2 is your denominator
        int gcd = numerator.gcd(denominator).intValue();                                           // calculate the greatest common divisor of numerator  and denominator
        if (gcd > 1 ){                                                                             // gcd(75,100) = 25
            return String.valueOf(numerator.intValue()/gcd) +"/"  + String.valueOf(denominator.intValue()/gcd);  // return 75/25 / 100/25 = 3/4
        }
        else{
            return String.valueOf(numerator) +"/"  + String.valueOf(denominator);              // if gcd = 1 which means nothing to simplify just return numerator / denominator
        }
    }
}
