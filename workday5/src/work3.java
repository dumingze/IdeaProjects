public class work3 {
    public static void main(String[] args){
        System.out.println("1-99以内的同构数有：");
        for (int i=1;i<=99;i++){
            int pingfangshu=i*i;
            int gewei=pingfangshu%10;
            int shiwei=(pingfangshu/10)%10;
            if ((gewei==i)||(shiwei*10+gewei)==i){
                System.out.println(i+"是同构数");
            }
        }


    }
}
