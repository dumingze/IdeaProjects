package com.dmz.zrw;

import java.io.*;

/*
1.有这样的一个words数组，数组中每个字符串的格式为“词性:单词”
String[] words = {"verb:eat","verb:drink","verb:sleep","verb:play","noun:rice","noun:meat","noun:hand","noun:hair"};
根据单词性质动词verb全部存入verb.txt文件中
根据单词性质名词noun全部存入noun.txt文件中
 */
public class Work1 {

    public static void main(String[] args) throws IOException {
        String[] words = {"verb:eat","verb:drink","verb:sleep","verb:play", "noun:rice","noun:meat","noun:hand","noun:hair"};
/*        String wordingDir = System.getProperty("user.dir");
        System.out.println(wordingDir);*/

        OutputStream outputStreamVerb=new BufferedOutputStream(new FileOutputStream("/Users/dumingze/IdeaProjects/workday20/verb.txt"));
        OutputStream outputStreamNoun=new BufferedOutputStream(new FileOutputStream("/Users/dumingze/IdeaProjects/workday20/noun.txt"));
        for (String s:words){
            if (s.startsWith("verb")){
                try {
                    outputStreamVerb.write(s.getBytes());
                    outputStreamVerb.write('\n');
                    System.out.println("写入"+s);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (s.startsWith("noun")){
                try {
                    outputStreamNoun.write(s.getBytes());
                    outputStreamNoun.write('\n');
                    System.out.println("写入"+s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        outputStreamVerb.close();
        outputStreamNoun.close();

    }
}