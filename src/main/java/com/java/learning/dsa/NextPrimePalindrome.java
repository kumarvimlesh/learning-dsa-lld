package com.java.learning.dsa;

class NextPrimePalindrome {
    /**
     * 866. Prime Palindrome
     * Given an integer n, return the smallest prime palindrome greater than or equal to n.
     *
     * An integer is prime if it has exactly two divisors: 1 and itself. Note that 1 is not a prime number.
     *
     *     For example, 2, 3, 5, 7, 11, and 13 are all primes.
     *
     * An integer is a palindrome if it reads the same from left to right as it does from right to left.
     *
     *     For example, 101 and 12321 are palindromes.
     *
     * The test cases are generated so that the answer always exists and is in the range [2, 2 * 108].
     * @param args
     *
     * passes 56 test cases out of 63
     */
    public static void main(String[] args) {
        System.out.println(primePalindrome(1));
        System.out.println(primePalindrome(2));
        System.out.println(primePalindrome(3));
        System.out.println(primePalindrome(9));
        System.out.println(primePalindrome(16));
    }
    private static boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }

    private static boolean isPalindrome(int n){
        String s = String.valueOf(n);
        int l = 0, h = s.length()-1;
        while(l<=h){
            if(s.charAt(l)!=s.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }

    public static int primePalindrome(int n) {
        if(n==1) return 2;
        if(n==2) return 3;
        if((n%2==0 && n>2) || n==1) n++;
        while(true){
            if(isPalindrome(n) && isPrime(n)){
                return n;
            }
            n += 2;
        }
    }
}