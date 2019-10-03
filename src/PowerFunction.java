import java.math.BigInteger;
import java.text.MessageFormat;

public class PowerFunction
{
    public static void main(String[] args) throws Exception
    {
        toPowerOf(0, 0);
        toPowerOf(10, 1);
        toPowerOf(0, 1);
        toPowerOf(2, -1);
        toPowerOf(2, -2);
        toPowerOf(3, -3);
        toPowerOf(3, 3);
    }

    private static void toPowerOf(double number, int power) {
        double result;
        if (power == 0) result = 1;
        else if (power < 0) {
            int positivePower = power * -1;
            result = 1 / multiply(number, positivePower);
        }
        else
            result = multiply(number, power);
        System.out.println(number + " в степени " + power + " = " + result);
    }

    private static double multiply(double number, int power) {
        double result = number;
        for (int i = 1; i < power; i++)
        {
            result = result * number;
        }
        return result;
    }
}