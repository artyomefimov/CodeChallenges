import java.util.Scanner;

/**
 * Have the function LetterChanges(str) take the str parameter being passed and modify it using the following algorithm.
 * Replace every letter in the string with the letter following it in the alphabet (ie. c becomes d, z becomes a).
 * Then capitalize every vowel in this new string (a, e, i, o, u) and finally return this modified string.
 */

public class LetterChanges
{
    public static void main(String[] args)
    {
        System.out.println(letterChanges("scanner.nextLine()"));
        System.out.println(letterChanges("hello*3"));
        System.out.println(letterChanges("fun times!"));
        System.out.println(letterChanges("\"Argument goes here\""));
        System.out.println(letterChanges("Zoo"));
    }

    private static String letterChanges(String input)
    {
        char[] chars = input.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            if (isLatinChar(chars[i]))
            {
                int charValue = chars[i];
                chars[i] = charValue == 'z' ? 'a' : (char) ++charValue;
                if (isVowel(chars[i]))
                    chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        return String.valueOf(chars);
    }

    private static boolean isLatinChar(char c)
    {
        return String.valueOf(c).matches("[a-zA-z]");
    }

    private static boolean isVowel(char c) {
        return String.valueOf(c).matches("[aeiouAEIOU]");
    }
}
