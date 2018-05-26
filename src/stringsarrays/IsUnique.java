package stringsarrays;

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

       assert !isUniqueBitMask("hello") : "not unique";
       assert isUniqueBitMask("asdf") : "unique";
       assert isUniqueBitMask("") : "unique";
       assert isUniqueBitMask("Abcdefgxyz123456") : "unique";
       assert !isUniqueBitMask("AbcdefgxyzzZZ123456") : "not unique";
    }

    /**
     * Use of extra data structure.
     * Runtime Complexity: O(n)
     * Space Complexity: O(c) - Size of character set
     * @param str
     * @return isUnique
     */
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

    /**
     * Use of bitmask to avoid extra data structure
     * Runtime Complexity: O(n)
     * Space Complexity: O({size of int})
     * @param str
     * @return isUnique
     */
    static boolean isUniqueBitMask(String str) {
        int bitMask = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            if ((bitMask & (1 << c)) > 0) {
                return false;
            }
            bitMask |= (1 << c);
        }
        return true;
    }
}
