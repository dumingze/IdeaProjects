import java.util.Scanner;

public class Work2 {

    //计算n条直线最多能把平面分成多少部分？ n >= 1
  /*  f(n)=n(n+1)/2+1
    原理：第N条直线可以被前N-1条直线分为N段，对于 每1段则将平面分为两份，所以对于前
    f(n)=f(n-1)+n。
    f(n-1)=f(n-2)+n-1
            ......
    f(1)=f(0)+1;
    f(0)=1;
    等式左右相加可以得到:f(n)+f(n-1).....+f(0)=f(0)+(f1)+.....+f(n-1)+1+1+2+...+n;
    f(n)=1+n(n+1)/2*/
    public static void main(String[] args){

        System.out.println("计算n条直线最多能把平面分成多少部分？ n >= 1");
        Scanner scanner=new Scanner(System.in);
        int i=scanner.nextInt();
        int countAreas=divideAreas(i);
        System.out.println(i+"条线最多可以分成"+countAreas+"块");

    }
    public static int divideAreas(int n){
        if (n==0){
            return 1;
        }
        if (n==1){
            return 2;
        }

        else return n+divideAreas(n-1);
    }
}
