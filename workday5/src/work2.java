public class work2 {
    public static void main(String[] args) {

        double summoney = 0;//总钱数
        int day = 0;//5天为一个周期
        int coutday = 0;//总天数
        while (summoney < 100) {
            coutday += 1;
            day += 1;
            summoney += 2.5;
            if (day % 5 == 0) {
                summoney = summoney - 6.0;
            }
        }
        System.out.println("经过"+coutday+"天，小芳可以存够100元");

    }
}
