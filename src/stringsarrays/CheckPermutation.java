package stringsarrays;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class CheckPermutation {
    public static void main(String[] args) {
        assert sortString("cba321").equals("123abc") : "string should be sorted";

        assert isPermutationWithSort("hello", "olleh") : "is a permutation";
        assert !isPermutationWithSort("asdf", "dennis") : "is not a permutation";

        assert isPermutationWithCounts("hello", "olleh") : "is a permutation";
        assert !isPermutationWithCounts("asdf", "dennis") : "is not a permutation";
    }

    /**
     * Checks sorting a string and comparing the string. Permutations should always be equal.
     * Runtime Complexity: O(n log(n))
     * Space Complexity: O(1)
     * @param s1 string 1
     * @param s2 string 2
     * @return isPermutation
     */
    static boolean isPermutationWithSort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        return sortString(s1).equals(sortString(s2));
    }

    private static String sortString(String s) {
        char[] characters = s.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }

    /**
     * Uses an array of ints to simulate a "hash" table.
     * If the counts of a character from the second string ever dip below 0,
     * then that means it contains a different character.
     * Runtime Complexity: O(n)
     * Space Complexity: O(c) - Size of the character set
     * @param s1 string 1
     * @param s2 string 2
     * @return isPermutation
     */
    static boolean isPermutationWithCounts(String s1, String s2) {
        // We assume an ASCII character set
        int[] characterCounts = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            characterCounts[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            characterCounts[s2.charAt(i)]--;
            if (characterCounts[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
