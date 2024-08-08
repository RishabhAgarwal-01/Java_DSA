package com.Recursion;

public class power {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long pow = n;
        if (pow < 0) pow = -1 * pow;

        while (pow > 0) {
            if (pow % 2 == 1) {
                ans = ans * x;
                pow = pow - 1;
            } else {
                x = x * x;
                pow = pow / 2;
            }
        }
        if (n < 0) ans = (double) (1.0) / (double) ans;
        return ans;
    }

    //using recursion
    // Method to calculate x^n using recursion
    public static double power(double x, int n) {
        // Base case: x^0 is 1
        if (n == 0) {
            return 1;
        }
        // If n is negative, use the reciprocal and make n positive
        else if (n < 0) {
            return 1 / power(x, -n);
        }
        // Recursive case: x^n is x * x^(n-1)
        else {
            return x * power(x, n - 1);
        }
    }
    public static void main(String[] args) {
        double x = 2.000;
        int n = 12;
        double result = power(x, n);
        System.out.println(x + "^" + n + " = " + result);
    }
}