package com.dmz.zrw;

import java.util.HashSet;

/*
3. 给定一个字符串数组 words 和一个字符串 chars.
   如果一个字符串能被 chars 里面的字符组成，那么这个字符串就是"好"的(chars里面每个字符只能使用一次)。
        求：words 里面所有好的字符串的字符总个数。
        比如：
        words = ["cat", "bt", "hat", "tree"]
        chars = "atach"
        好的字符串有 "cat", "hat", 3 + 3 = 6.
        输出：6*/
public class Work3 {

    public static void main(String[] args) {
        HashSet<Character> characters = new HashSet<>();
        String chars = "atach";
        for (int i = 0; i < chars.length(); i++) {
            characters.add(chars.charAt(i));

        }
        String[] strings = new String[]{"cat", "bat", "hat", "tree"};
        System.out.println(goodStrings(characters, strings));

    }

    public static int goodStrings(HashSet<Character> characters, String[] strings) {
        int goodLength = 0;
        for (String s : strings) {
            if (containsString(characters, s)) {
                goodLength = goodLength + s.length();
            }

        }
        return goodLength;
    }

    public static boolean containsString(HashSet<Character> characters, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (characters.contains(s.charAt(i)) == false) {
                return false;
            }

        }
        return true;

    }
}