import java.util.Scanner;

public class Work1 {
    public static void main(String[] args){
        System.out.println("请输入台阶级数:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = ways(n);
        sc.close();
        System.out.println("共有" + count + "种方法");
    }
    public static int ways(int x){
        int count = 0;
        if (x == 1 || x == 2){
            count = x;
        } else {
            count = ways(x - 1) + ways(x - 2);
        }
        return count;
    }
}
