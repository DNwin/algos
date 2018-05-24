package com.nguyendennis.ch01stringsarrays;

import java.util.HashSet;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsUnique {
    public static void main(String[] args) {
       assert !isUnique("hello") : "not unique";
       assert isUnique("asdf") : "unique";
       assert isUnique("") : "unique";
    }

    static boolean isUnique(String str) {
        HashSet<Character> characterSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (characterSet.contains(c)) {
                return false;
            }
            characterSet.add(c);
        }
        return true;
    }
}
