/*21.4 (Count consonants and vowels) Write a program that prompts the user to enter a text file name and displays the
 *number of vowels and consonants in the file. Use a set to store the vowels A, E, I, O, and U.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Ex21_4 {
    public static void main(String[] args) throws IOException {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P',
                'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'));
        HashSet<Character> consonants = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));

        // Get text from user specified file
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a txt file name: ");
        String text = Files.readString(Paths.get(input.next()));
        input.close();

        // Remove all digits, whitespace, and punctuation
        String strippedText = text.replaceAll("[\\s+\\p{P}\\d]", "");

        // Count vowels and consonants
        int numConsonants = 0;
        int numVowels = 0;
        for (Character character : strippedText.toCharArray()) {
            if (vowels.contains(Character.toUpperCase(character))) numVowels++;
            else if (consonants.contains(Character.toUpperCase(character))) numConsonants++;
        }
        System.out.println("Number of consonants: " + numConsonants);
        System.out.println("Number of vowels: " + numVowels);
    }
}