import java.io.File;

public class test {

    public static void main(String[] args) {
        File file = new File("/Users/dumingze/IdeaProjects/MyserverTest/src/3.html");
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.isFile());

        String wordingDir = System.getProperty("user.dir");
        System.out.println(wordingDir);  //E:\wangdao\java\file
    }
}
