package com.dmz.zrw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Work2 {
   /* 2. 双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
    红色球号码从1—33中选择；蓝色球号码从1—16中选择；请随机生成一注双色球号码。（要求同色号码不重复）*/

    public static void main(String[] args) {
        HashSet<Integer> redNumber = new HashSet<>();
        HashSet<Integer> blueNumber = new HashSet<>();
        while (redNumber.size()<7){
            int number=(new Random().nextInt(32))+1;
            redNumber.add(number);
        }

        while (blueNumber.size()<1){
            int number=(new Random().nextInt(16))+1;
            blueNumber.add(number);
        }

        System.out.println("红色号码为"+redNumber);
        System.out.println("蓝色号码为"+blueNumber);
    }
}
