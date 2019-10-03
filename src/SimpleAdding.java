/**
 * Have the function SimpleAdding(num) add up all the numbers from 1 to num.
 * For example: if the input is 4 then your program should return 10 because 1 + 2 + 3 + 4 = 10.
 * For the test cases, the parameter num will be any number from 1 to 1000.
 */

public class SimpleAdding
{
    public static void main(String[] args)
    {
        System.out.println(simpleAdding(3));
        System.out.println(simpleAdding(12));
        System.out.println(simpleAdding(140));
        System.out.println(simpleAdding(8));
        System.out.println(simpleAdding(1));
    }

    private static int simpleAdding(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++)
        {
            result += i;
        }
        return result;
    }
}
