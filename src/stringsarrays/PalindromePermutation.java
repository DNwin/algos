package stringsarrays;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 *
 * Assume:
 * - Only alphabetical characters
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        assert isPermutationOfPallindrome("Tact Coa");
        assert !isPermutationOfPallindrome("ab");
        assert !isPermutationOfPallindrome("bac");
    }

    /**
     * A palindrome has at most one odd count of letters.
     *  ex:
     *    Palindrome: "a", "aa", "bab", "cbabc", "bcbabcb", "cbabca" -> "cbaabc"
     *    Not palindrome: "ab", "bac", "cbabcd", "cccbba"
     *
     *    Runtime Complexity: O(n) - based on number of characters in the word
     *    Space Complexity: O(1) - size of character set
     * @param letters alphabetical character word
     * @return is a permutation of a palindrome
     */
    static boolean isPermutationOfPallindrome(String letters) {
        int[] table = buildCharCountTable(letters);
        return isMaxOneOddCount(table);
    }

    // Checks if there is at most one odd count
    private static boolean isMaxOneOddCount(int[] table) {
        boolean hasOddCount = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (hasOddCount) {
                    return false;
                }
                hasOddCount = true;
            }
        }
        return true;
    }

    // Builds a hash table containing character counts.
    private static int[] buildCharCountTable(String letters) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : letters.toCharArray()){
            int pos = getCharPosition(c);
            if (pos >= 0) {
                table[pos]++;
            }
        }
        return table;
    }

    // Normalize the character numeric value to start at 0, return -1 if not a letter
    private static int getCharPosition(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        // If character is a letter, return normalized value. Else return -1
        int value = Character.getNumericValue(c);
        if (value >= a && value <= z) {
            return value - a;
        }
        return -1;
    }
}
