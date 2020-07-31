package com.dmz.zrw;


import java.util.HashSet;

/*
2. 给定两个字符串s和t, 它们只包含小写字母。
   字符串t是由s中的字母随机打乱之后，在随机的一个位置添加一个字母生成的。请找出那个添加的字母。
        比如：
        s = "abcd"
        t = "baedc"
        输出：e*/
public class Work2 {
    public static void main(String[] args) {

        HashSet<Character> characters = new HashSet<>();
         String s = "abcd";
        for (int i = 0; i <s.length() ; i++) {
            characters.add(s.charAt(i));

        }

        String  t = "baedc";
        for (int i = 0; i <t.length() ; i++) {
            if (characters.contains(t.charAt(i))==false){
                System.out.println(t.charAt(i));
            }

        }

    }
}
