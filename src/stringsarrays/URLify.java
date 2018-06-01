package stringsarrays;

/**
 * Write a method to replace all spaces in a string with '%20:
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 *
 * EXAMPLE
 * Input: "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
public class URLify {
    public static void main(String[] args) {
        // Simulate a c-string by adding a null terminator
        String input = "Mr John Smith    ";
        int inputTrueLength = 13;
        char[] letters = input.toCharArray();
        letters[inputTrueLength] = '\0';

        urlify(letters, inputTrueLength);

        String output = new String(letters);
        assert output.equals("Mr%20John%20Smith") : "string spaces are replaced with %20";
    }


    /**
     * Replace all spaces with '%20' in place.
     * Runtime Complexity: O(n)
     * Space Complexity: O(1)
     * @param lettersWithBackBuffer char array of cstring
     * @param inputTrueLength true length of trimmed sentence
     */
    static void urlify(char[] lettersWithBackBuffer, int inputTrueLength) {
        // Loop over initial input to determine how many spaces there are
        int spaceCnt = 0;
        for (int i = 0; i < inputTrueLength; i++) {
            if (lettersWithBackBuffer[i] == ' ') {
                spaceCnt++;
            }
        }

        // Using the extra space in the letters array,
        // set the writeIndex equal to: original input length + (spaceCnt * 2)
        // (Note the '\0')
        int backIndex = inputTrueLength + (spaceCnt * 2);

        // Start inspecting each letter, swapping to the end of the buffer. Perform replacement as needed.
        for (int i = inputTrueLength - 1; i >= 0; i--) {
            char letter = lettersWithBackBuffer[i];
            if (letter == ' ') {
                // Replace with "%20"
                lettersWithBackBuffer[--backIndex] = '0';
                lettersWithBackBuffer[--backIndex] = '2';
                lettersWithBackBuffer[--backIndex] = '%';
            } else {
                lettersWithBackBuffer[--backIndex] = letter;
            }
        }
    }
}
