import java.util.Scanner;

public class work1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入1-9之间的任意一个数字");
        int x = scanner.nextInt();
        for (int i = 1; i <= 9; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(i + "x" + j + "=" + (i * j) + "  ");
            }
            System.out.println();

        }
    }
}

