/**
 * Have the function FirstFactorial(num) take the num parameter being passed and return the factorial of it.
 * For example: if num = 4, then your program should return (4 * 3 * 2 * 1) = 24.
 * For the test cases, the range will be between 1 and 18 and the input will always be an integer.
 */

public class Factorial
{
    public static void main(String[] args)
    {
        System.out.println(factorial(1));
        System.out.println(factorial(8));
        System.out.println(factorial(4));
        System.out.println(factorial(18));
    }

    private static long factorial(int num) {
        if (num == 1) return num;
        return num * factorial(num - 1);
    }
}
