import java.util.Scanner;

class Luke
{
    private int N;
    private double f1 = (1 + Math.sqrt(5)) / 2, f2 = (1 - Math.sqrt(5)) / 2;

    Luke(int N) {
        this.N = N;
    }

    public void Audit()
    {
        long num;
        double res;
        for (int i = 0; i < N; i++)
        {
            num = (long) (Math.pow(f1, i) + Math.pow(f2, i));
            res = Math.sqrt(num - 1);
            if (res == (int)res)
                System.out.println(num);
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введіть к-сть чисел Люка: ");
        int num = scan.nextInt();

        Luke obj = new Luke(num);
        System.out.print("Числа Люка, які можна задати у формі w^2+1 серед перших " + num +"-ти чисел Люка:\n");

        obj.Audit();
    }
}