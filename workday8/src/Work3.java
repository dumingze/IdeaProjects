public class Work3 {

    public static void main(String[] args) {
        int x=totalPeach(1);
        System.out.println("第一天有"+x+"个桃子");
    }

    public static int totalPeach(int x) {
        if (x==10){
            return 1;
        }
        else {
             return  (totalPeach(x+1)+1)*2;
        }
    }
}
