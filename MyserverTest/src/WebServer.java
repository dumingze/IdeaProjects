/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/11/18
 * Time: 15:21
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.服务器需要监听某一端口号
 * 2.当请求到达对应端口号时，解析出所请求内容
 * 3.在当前服务器上面搜寻对应的资源，作出响应（200,404）
 */
public class WebServer {

    public static void main(String[] args) {
        //监听8080端口号
        try {
            // 监听端口--->8080
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true){
                Socket socket = serverSocket.accept();
                //请求报文就在输入流中
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                //将请求报文封装到request对象中
                Request request = new Request(inputStream);
                //url代表客户端需要请求的资源
                String url = request.getRequestURL();
                System.out.println("---------");
                System.out.println(url);


                // 数据库连接
////
////                if (url.equals("aaa")){
////                    // 取数
////                }


                System.out.println(url);
                //利用response对象进行响应
                Response response = new Response(url,outputStream);
                //作出响应
                response.response();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
