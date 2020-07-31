import java.io.*;

public class Response {

    private String url;

    private OutputStream outputStream;

    public Response(String url, OutputStream outputStream) {
        this.url = url;
        this.outputStream = outputStream;
    }

    public void response() throws IOException {
        //io流
        if(url != null){
            System.out.println(url);
            String s="/Users/dumingze/IdeaProjects/MyserverTest/src/";
            url=s+url;
            System.out.println("s"+url);
            File file = new File(url);
            System.out.println(file.exists());
            System.out.println(file.getName());
            System.out.println(file.isFile());
            StringBuffer stringBuffer = new StringBuffer();

            if(file.exists() && file.isFile()){
                //200 构建响应报文
                stringBuffer.append("HTTP/1.1 200 OK \r\n");
                stringBuffer.append("Content-Type:text/html;charset=utf-8 \r\n");
                stringBuffer.append("\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                int length = 0;
                outputStream.write(stringBuffer.toString().getBytes("utf-8"));
                while ( (length =fileInputStream.read(bytes)) != -1){
                    outputStream.write(bytes,0,length);
                }
                return;
            }
            stringBuffer.append("HTTP/1.1 404 Not Found \r\n");
            stringBuffer.append("Content-Type:text/html;charset=utf-8 \r\n");
            stringBuffer.append("\r\n");
            stringBuffer.append("<h1>File Not Found 404!</h1>");
            outputStream.write(stringBuffer.toString().getBytes("utf-8"));
            // 404
        }
        else {
            System.out.println("url is null");
        }
    }
}
