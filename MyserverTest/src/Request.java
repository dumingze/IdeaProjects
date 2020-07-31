import java.io.IOException;
import java.io.InputStream;

public class Request {

    private InputStream inputStream;

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 获取请求的资源名称
     * @return
     */
//    GET /1.html HTTP/1.1
//    Host: localhost:8080
//    Connection: keep-alive
//    Cache-Control: max-age=0
//    Upgrade-Insecure-Requests: 1
//    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36
//    Sec-Fetch-User: ?1
//    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
//    Sec-Fetch-Site: none
//    Sec-Fetch-Mode: navigate
//    Accept-Encoding: gzip, deflate, br
//    Accept-Language: zh-CN,zh;q=0.9
//    Cookie: Idea-83cde6a5=014bf777-5194-49e4-923c-2f4a24d6bff9

    public String getRequestURL() throws IOException {

        // 创建一个数组
        byte[] bytes = new byte[2048];
        //写入到byte数组中的长度
        StringBuffer stringBuffer = new StringBuffer();
        int read = inputStream.read(bytes);
        for (int i = 0; i < read; i++) {
            stringBuffer.append((char) bytes[i]);
        }
        //完整的请求报文

        String content = stringBuffer.toString();
        System.out.println("----------------------------------------------");
        System.out.println(content);
        System.out.println("----------------------------------------------");


        if(content != null && !"".equals(content)){
            System.out.println(content);
           return getFileName(content);
        }
        return null;
    }

    /**
     * 从请求报文中获取访问的资源名称请求行：请求方法 请求资源 版本
     * @param content
     */
    private String getFileName(String content) {
//        System.out.println(content);
       //找到第一个空格所在的位置
        int a = content.indexOf(' ');
        //第二个空格所在的位置
        int b = content.indexOf(' ',a + 1);
        //注意一点，里面很可能包含请求参数，去掉
        String fileName = content.substring(a + 2, b);
        System.out.println(fileName);
        int i = fileName.indexOf('?');
        if(i != -1){
            //存在参数，需要截取
            return fileName.substring(0,i);
        }
        return fileName;
    }
}
